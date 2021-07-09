/*
Enhanced Merge Sort
Time = O(nlogn)
Space = O(n)
 */
package RBR_DSA.ArrayProblems;


public class countInversions {
    static int merge(long[] arr,int start,int mid,int end)
    {
        int count=0;
        int l1=mid-start+1;
        int l2=end-mid;
        long a1[]=new long[l1];
        long a2[]=new long[l2];
        int k=start;
        for(int i=0;i<l1;i++)
        {
            a1[i]=arr[k++];
        }
        for(int i=0;i<l2;i++)
        {
            a2[i]=arr[k++];
        }
        int i=0,j=0;
        k=start;
        while(i<l1 && j<l2)
        {
            if(a1[i]<=a2[j])
            {
                arr[k++]=a1[i];
                i++;
                //count++;
            }
            else
            {
                count+=(l1-i);
                arr[k++]=a2[j];
                j++;
            }
        }
        if(j!=l2)
        {
            while(j<l2)
            {
                arr[k++]=a2[j++];
            }
        }
        if(i!=l1)
        {
            while(i<l1)
            {
                arr[k++]=a1[i++];
            }
        }
        return count;
    }
    static void display(long[] arr)
    {
        for(long x:arr)
            System.out.print(x+"     ");
    }
    static int mergeSort(long[] arr,int l,int r)
    {
        int c=0;
        if(l<r)
        {
            int mid=(l+r)/2;
            c+=mergeSort(arr,l,mid);
            c+=mergeSort(arr,mid+1,r);
            c+=merge(arr,l,mid,r);
        }
        return c;
    }
    public static void main(String[] args)
    {
        long arr[]={10};
        System.out.println("\nNo. Of inversions " +mergeSort(arr,0,0));
        System.out.println("Sorted array ");
        display(arr);
        System.out.println();


        long arr1[]={1,0,-1,-2,5,3};
        System.out.println("\nNo. Of inversions " +mergeSort(arr1,0,5));
        System.out.println("Sorted array ");
        display(arr1);
        System.out.println();

        String [] arr2= ("174 165 142 212 254 369 48 145 163 258 38 360 224 242 30 279 317 36 191 343 289 107 41 443 265 149 447 306 391 230 371 351 7 102").split(" ");
        long[] arr3=new long[34];
        int i=0;
        for(String x:arr2)
        {
            arr3[i++]=Integer.valueOf(x);
        }
        System.out.println("\nNo. Of inversions " +mergeSort(arr3,0,33));
        System.out.println("Sorted array ");
        display(arr3);
        System.out.println();

    }
}
