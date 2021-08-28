/*
Return the longest palindrome substring of string
Time = O(n^2)
Space = O(n^2)
 */
package RBR_DSA.DynamicProgramming.LongestPalindrome;

public class LongestPalindrom {
    static String longestPalin(String S){
        // code here
        int n=S.length();
        if(n==0)
            return "";
        int sub[][]=new int[n][n];
        int maxi=0,maxlen=1;
        for(int i=0;i<n;i++)
        {
            sub[i][i]=1;
        }
        for(int i=0;i<n-1;i++)
        {
            sub[i][i+1]=S.charAt(i)==S.charAt(i+1)?1:0;
            if(sub[i][i+1] ==1 && maxlen<2)
            {
                maxi=i;
                maxlen=2;
            }
        }
        for(int chain=3;chain<=n;chain++)
        {
            int j=chain-1;
            for(int i=0;i<=n-chain;i++)
            {
                if(S.charAt(i)==S.charAt(j) && sub[i+1][j-1]==1)
                {
                    sub[i][j]=1;
                    if(maxlen<chain)
                    {
                        System.out.println("Entered");
                        maxi=i;
                        maxlen=chain;
                        System.out.println(maxi+"   "+maxlen);
                    }
                }
                j++;
            }
        }

        for(int[] x:sub)
        {
            for(int y:x)
                System.out.print(y+"  ");
            System.out.println();
        }
        System.out.println(maxi+"  "+maxlen);
        return S.substring(maxi,maxi+maxlen);
    }
    public static void main(String[] args)
    {
        String s="owo";
        System.out.println(longestPalin(s));
    }
}
