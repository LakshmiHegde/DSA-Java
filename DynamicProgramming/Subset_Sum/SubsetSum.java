/*
Subset sum, decide if sum is possible with any sequence of array.
Time = O(min(2^n , ns))
Space = O(ns)
 */
package RBR_DSA.DynamicProgramming.Subset_Sum;

public class SubsetSum {
    public static boolean subset(int[] arr,int sum,int n)
    {
        boolean[][] ss=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
            ss[i][0]=true;
        for(int i=1;i<=sum;i++)
            ss[0][i]=false;
        for(int i=1;i<=n;i++)
        {
            int ai=arr[i-1];
            for(int j=1;j<=sum;j++)
            {
                if(ai <= j)
                    ss[i][j]=ss[i-1][j-ai] | ss[i-1][j];
                else
                    ss[i][j]=ss[i-1][j];
            }
        }
        return ss[n][sum];
    }
    public static void main(String[] args)
    {
        int arr[]={6,3,2,1};
        int sum=10;
        System.out.println("Is sum of "+sum+ " possible? "+subset(arr,sum,arr.length));
        System.out.println("Is sum of "+0+ " possible? "+subset(arr,0,arr.length));
        System.out.println("Is sum of "+12+ " possible? "+subset(arr,12,arr.length));
        System.out.println("Is sum of "+12+ " possible? "+subset(arr,15,arr.length));
    }
}
