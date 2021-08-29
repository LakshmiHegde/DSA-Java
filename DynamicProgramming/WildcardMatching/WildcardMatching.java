/*
Check if string matches with the  wildcard pattern
Time = O(mn)
Space = O(mn)
 */
package RBR_DSA.DynamicProgramming.WildcardMatching;

public class WildcardMatching {
    static boolean wildCard(String pattern, String str)
    {
        // Your code goes here
        int p=pattern.length(),s=str.length();
        boolean[][] T=new boolean[s+1][p+1];
        T[0][0]=true;
        for(int i=1;i<=s;i++)
        {
            T[i][0]=false;
        }
        for(int i=1;i<=p;i++)
        {
            if(pattern.charAt(i-1)=='*')
                T[0][i]=T[0][i-1];
        }
        for(int i=1;i<=s;i++)
        {
            for(int j=1;j<=p;j++)
            {
                System.out.println("entered, str = "+str.charAt(i-1)+"  pattern "+pattern.charAt(j-1));
                if(pattern.charAt(j-1) == str.charAt(i-1) || pattern.charAt(j-1)=='?')
                    T[i][j]=T[i-1][j-1];
                else if(pattern.charAt(j-1) == '*')
                {
                    System.out.println("Entered i= "+i+"  j= "+j);
                    T[i][j]=T[i-1][j] || T[i][j-1] ;
                }
                else if(pattern.charAt(j-1) != str.charAt(i-1))
                    T[i][j]=false;
                System.out.println("T[i][j] = "+T[i][j]);
            }
        }
        return T[s][p];
    }
    public static void main(String args[])
    {
        String pattern = "ba*a?" ;
        String str = "baaabab";
        System.out.println(wildCard(pattern,str));
    }
}
