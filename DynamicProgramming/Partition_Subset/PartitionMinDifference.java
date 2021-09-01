/*
Partition given array into two subsets such that, difference between sum of those partitions is minimum.
Same like partition subset sum.
Time = O(nw)
Space =O(nw)
 */
package RBR_DSA.DynamicProgramming.Partition_Subset;

public class PartitionMinDifference {
    static public int minDifference(int N,int arr[])
    {
        // Your code goes here
        int sum=0;
        for(int i=0;i<N;i++)
            sum+=arr[i];
        int x=sum;
        sum=sum/2;
        int[][] ss=new int[N+1][sum+1];
        for(int i=0;i<=N;i++)
        {
            ss[i][0]=0;

        }
        for(int i=1;i<=sum;i++)
        {
            ss[0][i]=0;

        }
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1] <= j)
                    ss[i][j]=Math.max(ss[i-1][j-arr[i-1]]+arr[i-1] , ss[i-1][j]);
                else if(arr[i-1] > j)
                    ss[i][j]=ss[i-1][j];
            }
        }
        int other=x-ss[N][sum];
        return Math.abs(other-ss[N][sum]);

    }
    public static void main(String[] args)
    {
        int[] arr = {1, 5, 11, 5};
        System.out.println(minDifference(4,arr));


        int[] arr2 = {1, 5, 6, 5};
        System.out.println(minDifference(4,arr2));

        int[] arr3 = {1, 3};
        System.out.println(minDifference(2,arr3));

    }
}
