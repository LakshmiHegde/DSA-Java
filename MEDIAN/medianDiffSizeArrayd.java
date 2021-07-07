/*
Time = O((m+n)/2) = O(m+n)
Space = O(1)
 */
package RBR_DSA.MEDIAN;

public class medianDiffSizeArrayd {
    public static int computeMedian(int arr1[] , int arr2[], int n, int m)
    {
        int len = m+n;
        int mid=len/2;
        int prev=0,min=0;
        int i=0,j=0,k=0;
        if(n == 0 || m ==0)
        {
            if(n == 0 && m == 0)
                return 0;
            if(n==0)
            {
                if(m%2 == 0)
                    return (arr2[m/2] + arr2[m/2 -1])/2;
                else return arr2[m/2];
            }
            else if(m==0)
            {
                if(n%2 == 0)
                    return (arr1[n/2] + arr1[n/2 -1])/2;
                else return arr1[n/2];
            }
        }
        for(i=0;i<=mid && j<n && k<m;i++)
        {
            prev=min;
            if(arr1[j] < arr2[k])
                min=arr1[j++];
            else
                min=arr2[k++];
        }
        if(i==n && j==n)
            prev=arr2[k];
        else if(i==n && k==n)
            prev=arr1[j];
        if(len%2 == 0)
        {
            return (prev+min)/2;
        }
        return min;
    }

    public static void main(String[] args)
    {
        int testCase1[] ={40,43,49,50,54};
        int testCase2[] ={30,42,45, 53};
       // System.out.println(computeMedian(testCase1,testCase2,5,4));


        int arr1[]={1,12,15,26,38};
        int arr2[]={2,13,17,30,45};
       // System.out.println(computeMedian(arr1,arr2,5,5));


        int testCase3[] ={40,52,55,66};
        int testCase4[] ={};
        System.out.println(computeMedian(testCase3,testCase4,4,0));

        int testCase5[] ={};
        int testCase6[] ={};
        System.out.println(computeMedian(testCase5,testCase6,0,0));
    }
}
