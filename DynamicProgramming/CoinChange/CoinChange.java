/*
number of ways to change the amount, using given coins
Time = O(mn), m- number of coins,n-total amount
Space = O(mn)
 */
package RBR_DSA.DynamicProgramming.CoinChange;

public class CoinChange {
    public static long count(int S[], int m, int n)
    {
        //code here.
        int[][] sol=new int[m+1][n+1];
        for(int i=0;i<n+1;i++)
            sol[0][i]=0;
        for(int i=0;i<m+1;i++)
            sol[i][0]=1;
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(S[i-1] <= j)
                    sol[i][j]=sol[i-1][j]+sol[i][j-S[i-1]];
                else
                    sol[i][j]=sol[i-1][j];
            }
        }
        return sol[m][n];
    }
    public static void main(String[] args)
    {
        int s[]={2,5,3,6};
        System.out.println(count(s,4,10));
    }
}
