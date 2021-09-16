/*
Count number of subsets in array,  with given sum
Time = O(sum*n)
Space = O(sum*n)
 */
package RBR_DSA.DynamicProgramming.SubsetSumCount;

public class CountSubsets {
    public static int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        int[][] ss=new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
            ss[i][0]=1;
        for(int i=1;i<=sum;i++)
            ss[0][i]=0;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1] > j)
                    ss[i][j]=(ss[i-1][j])%1000000007;
                else
                    ss[i][j]=(ss[i-1][j-arr[i-1]] + ss[i-1][j]) % 1000000007;
            }
        }

        return ss[n][sum];
    }
    public static void main(String[] args)
    {
        int arr[] ={2,3,5,8,10,9,11};
         System.out.println(perfectSum(arr,arr.length,10));
    }
}
