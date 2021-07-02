/*
Time = O(n)
Space = O(1)
 */
package RBR_DSA.MEDIAN;

public class UsingMergeProcedure {
    public static int merge(int arr1[], int arr2[], int n)
    {
        int j=0,k=0,min=0,prev=0 ,i;
        for(i=0;i<=n && j<n && k<n ;i++) //run for n+1 times
        {
            prev=min;
            if(arr1[j]<arr2[k])
                min=arr1[j++];
            else
                min=arr2[k++];
        }
        if(i==n && j==n)
            prev=arr2[k];
        else if(i==n && k==n)
            prev=arr1[j];

        return (min+prev)/2;
    }
    public static void main(String[] args)
    {
        int arr1[]={1,12,15,26,38};
        int arr2[]={2,13,17,30,45};
        System.out.println(merge(arr1,arr2,5));

        int testCase2[] ={40,52,55,66,78};
        System.out.println(merge(arr1,testCase2,5));

        System.out.println(merge(testCase2,arr2,5));
    }
}
