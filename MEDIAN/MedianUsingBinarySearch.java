/*
Binary search is done on minimum sized array
therefore, time = O(log(min(m,n)))
Space=O(1)
 */
package RBR_DSA.MEDIAN;

public class MedianUsingBinarySearch {
    public static int findMedian(int[] arr1, int[] arr2,int m, int n)
    {
        if(n<m)
            return findMedian(arr2,arr1,n,m);//always considering arr1 as small, therefore, if second array is smaller, just shift and call the method
        int high=m;//max elements that can be taken from arr1
        int low=0;//max elements that can be taken from arr1
        while(low<=high)
        {
            int eleFromArr1=(high+low)/2;
            int restEleFromArr2 = (n+m)/2 - eleFromArr1;

            int l1=(eleFromArr1!=0)?arr1[eleFromArr1-1]:Integer.MIN_VALUE;
            int l2=(restEleFromArr2!=0)?arr2[restEleFromArr2-1]:Integer.MIN_VALUE;
            int r1=(eleFromArr1!=m)?arr1[eleFromArr1]:Integer.MAX_VALUE;
            int r2=(restEleFromArr2!=n)?arr2[restEleFromArr2]:Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1)
            {
                int totalLen=(n+m);
                if(totalLen%2 == 0)
                {
                    return ((Math.max(l1,l2) + Math.min(r1,r2)) / 2);
                }
                else
                {
                    return Math.min(r1,r2);
                }
            }
            else if(l1>r2)
            {
                high=eleFromArr1-1;
            }
            else{
                low=eleFromArr1+1;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int testCase1[] ={40,43,49,50,54};
        int testCase2[] ={30,42,45, 53};
        System.out.println(findMedian(testCase1,testCase2,5,4));

        int arr1[]={1,12,15,26,38};
        int arr2[]={2,13,17,30,45};
        System.out.println(findMedian(arr1,arr2,5,5));

        int testCase3[] ={40,52,55,66};
        int testCase4[] ={};
        System.out.println(findMedian(testCase3,testCase4,4,0));

        int testCase5[] ={};
        int testCase6[] ={};
        System.out.println(findMedian(testCase5,testCase6,0,0));

    }
}
