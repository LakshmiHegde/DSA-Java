/*
Longest common subsequence
Time = O(mn)
Space =O(mn)
 */
package RBR_DSA.DynamicProgramming.LongestCommonSubsequence;

public class LCS_bottomUpImplementation {
    public static int lcs(String str1,String str2)
    {
        if(str1.length() == 0 || str2.length() ==0)
            return 0;
        int n=str1.length();
        int m=str2.length();
        int[][] l=new int[n+1][m+1];

        for(int i=1;i<=n;i++)
        {
            char c=str1.charAt(i-1);
            for(int j=1;j<=m;j++)
            {
                if(c == str2.charAt(j-1))
                    l[i][j]=1+l[i-1][j-1];
                else
                    l[i][j]=Math.max(l[i][j-1] , l[i-1][j]);
            }
        }
        subsequence(l,n,m,str1,str2,"",l[n][m]);
        return l[n][m];
    }
    public static void subsequence(int[][] l,int i,int j,String s1,String s2,String sol,int len)
    {
        if(l[i][j] == 0)
            return;
        if(s1.charAt(i-1) == s2.charAt(j-1))
        {
            sol=s1.charAt(i-1)+sol;
            if(sol.length() == len)
                System.out.println(sol);
            subsequence(l,i-1,j-1,s1,s2,sol,len);
        }
        else
        {
            if(l[i-1][j] == l[i][j-1])
            {
                subsequence(l,i,j-1,s1,s2,sol,len);
                subsequence(l,i-1,j,s1,s2,sol,len);
            }
            else
            {
                if(l[i-1][j] < l[i][j-1])
                    subsequence(l,i,j-1,s1,s2,sol,len);
                else
                    subsequence(l,i-1,j,s1,s2,sol,len);
            }
        }
    }
    public static void main(String args[])
    {
        String s1="ABCBDAB";
        String s2="BDCABA";

        System.out.println("Maximum length of subsequence "+lcs(s1,s2));
        System.out.println("--------------");

        String s3="AAB";
        String s4="ACAB";

        System.out.println("Maximum length of subsequence "+lcs(s3,s4));
        System.out.println("--------------");

        String s5="";
        String s6="ACAB";

        System.out.println("Maximum length of subsequence "+lcs(s5,s6));
        System.out.println("--------------");

        String s7="DWDWD";
        String s8="ACAB";

        System.out.println("Maximum length of subsequence "+lcs(s7,s8));
        System.out.println("--------------");
    }
}
