/*
Partition given array into two subsets such that, sum of those partitions are same.
Same like subset sum
Time = O(nw)
Space =O(nw)
 */
package RBR_DSA.DynamicProgramming.Partition_Subset;

public class PartitionSubset {
    static boolean equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<N;i++)
            sum+=arr[i];

        if(sum%2 != 0)
            return false;

        sum=sum/2;
        boolean[][] ss=new boolean[N+1][sum+1];
        for(int i=0;i<=N;i++)
        {
            ss[i][0]=true;

        }
        for(int i=1;i<=sum;i++)
        {
            ss[0][i]=false;

        }
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1] <= j)
                    ss[i][j]=ss[i-1][j-arr[i-1]] || ss[i-1][j];
                else if(arr[i-1] > j)
                    ss[i][j]=ss[i-1][j];
            }
        }
        return ss[N][sum];

    }
    public static void main(String[] args)
    {
        int[] arr = {1, 5, 11, 5};
        if(equalPartition(4,arr))
            System.out.println("Yes");
        else
            System.out.println("No");


        int[] arr2 = {1, 5, 6, 5};
        if(equalPartition(4,arr2))
            System.out.println("Yes");
        else
            System.out.println("No");

        int[] arr3 = {1, 3};
        if(equalPartition(2,arr3))
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
