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
        return l[n][m];
    }
    public static void main(String args[])
    {
        String s1="ABCBDAB";
        String s2="BDCABA";

        System.out.println(lcs(s1,s2));

        String s3="AAB";
        String s4="ACAB";

        System.out.println(lcs(s3,s4));

        String s5="";
        String s6="ACAB";

        System.out.println(lcs(s5,s6));
    }
}
