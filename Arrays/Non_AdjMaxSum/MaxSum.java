/*
Max sum of sequence with non adj nodes
Time - O(n)
Space - O(1)
 */
package RBR_DSA.ArrayProblems.Non_AdjMaxSum;

public class MaxSum {
    public static int FindMaxSum(int arr[], int n)
    {
        // Your code here
        if(n == 0)
            return 0;
        int inc=arr[0];
        int exc=0;
        for(int i=1;i<n;i++)
        {
            int c_inc = exc+arr[i];
            exc = Math.max(inc,exc);
            inc=c_inc;
        }
        return Math.max(inc,exc);
    }
    public static void main(String[] args)
    {
        int arr[]={5,10,10,100,6,5};
        System.out.println("Max sum of sequence, with non-adjacent nodes = "+FindMaxSum(arr,6));
    }
}
