/*
Count number of partitions ,with given difference.
Time - O(nm), n-number of elements, m-target sum
Space - O(nm)
 */
package RBR_DSA.DynamicProgramming.Partition_Subset;

public class CountPartitions {
    public static int count(int[] arr,int diff)
    {
        int sum=0,n=arr.length;
        for(int i=0;i<n;i++)
            sum+=arr[i];

        int target=(sum+diff)/2;
        int ss[][]=new int[n+1][target+1];
        for(int i=0;i<=target;i++)
            ss[0][i]=0;
        for(int i=0;i<=n;i++)
            ss[i][0]=1;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=target;j++)
            {
                if(arr[i-1] > j)
                    ss[i][j]=ss[i-1][j];
                else
                    ss[i][j]=ss[i-1][j-arr[i-1]]+ss[i-1][j];
            }
        }
        return ss[n][target];
    }
    public static void main(String[] args)
    {
        int[] arr={2,3,5,10,1,6,7};
        System.out.println("No. of subsets with difference 1 , "+count(arr,14));

        int[] arr2={1,1,2,3};
        System.out.println("No. of subsets with difference 1 , "+count(arr2,1));
    }
}
