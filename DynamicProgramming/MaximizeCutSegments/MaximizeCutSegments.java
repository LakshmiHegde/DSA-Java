/*

Time - O(n) using DP
Space - O(n)+O(n) , depth and array dp space
 */
package RBR_DSA.DynamicProgramming.MaximizeCutSegments;
import java.util.*;
public class MaximizeCutSegments {
    static int dp[];
    public static int max(int n,int x,int y,int z)
    {
        if(n == 0)//if length is 0, then 0 cuts
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int c1=Integer.MIN_VALUE,c2=Integer.MIN_VALUE,c3=Integer.MIN_VALUE;
        if(x <= n)
            c1=max(n-x,x,y,z);
        if(y <= n)
            c2=max(n-y,x,y,z);
        if(z <= n)
            c3=max(n-z,x,y,z);
        dp[n]=1 + Math.max(c1,Math.max(c2,c3));
        return dp[n];
    }
    //Function to find the maximum number of cuts.
    public static int maximizeCuts(int n, int x, int y, int z)
    {
        //Your code here
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        int res=max(n,x,y,z);
        if(res<0)
            return 0;
        return res;

    }
    public static void main(String[] args)
    {
        int N = 5;
        int x = 5, y = 3, z = 2;
        System.out.println("Maximum number of cuts on rod of length 5 , given pieces of 5,3,2 lengths is  "+maximizeCuts(N,x,y,z));
    }
}
