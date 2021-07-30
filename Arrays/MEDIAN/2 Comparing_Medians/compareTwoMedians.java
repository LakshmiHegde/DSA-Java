/*
Problem Statement: Median of 2 arrays, when merged

Every time cutting array at median
T(n) = T(n/2) + O(1)
O(logn)
space = O(1)
 */

package RBR_DSA.MEDIAN;

public class compareTwoMedians {
    public static int compareMediansInHalves(int arr1[] , int arr2[], int start1, int end1, int start2, int end2)
    {
        int mid1 = start1 + (end1-start1+1)/2 ;
        int mid2 = start2 + (end2-start2+1)/2 ;

        if((end1 - start1) == 1)
        {
            return  (Math.max(arr1[start1],arr2[start2]) + Math.min(arr1[end1],arr2[end2]))/2;
        }

        int med1=computeMedian(arr1,start1,end1);
        int med2=computeMedian(arr2,start2,end2);

        if(med1 == med2)
            return med1;
        if(med1<med2)
            return compareMediansInHalves(arr1,arr2,mid1,end1, start2,mid2);
        else
            return compareMediansInHalves(arr1,arr2,start1,mid1, mid2,end2);
    }
    public static int computeMedian(int[] arr, int start, int end)
    {
        int len=end-start+1;
        int mid=start + (len/2);
        if(len%2 == 0)//even array
            return ((arr[mid] + arr[mid-1])/2);
        return arr[mid];
    }
    public static void main(String[] args)
    {
        int arr1[]={1,12,15,26,38};
        int arr2[]={2,13,17,30,45};
        System.out.println(compareMediansInHalves(arr1,arr2,0,arr1.length-1,0,arr2.length-1));

        int testCase2[] ={1, 2, 3, 6,40,52,55,66};
        int testCase1[] ={4, 6, 8, 10,33,43,54,60}; //1,2,3,4,6,6,8,10,33,40,43,52,54,55,60,66
        System.out.println(compareMediansInHalves(testCase2,testCase1,0,testCase2.length-1,0,testCase1.length-1));

    }
}
