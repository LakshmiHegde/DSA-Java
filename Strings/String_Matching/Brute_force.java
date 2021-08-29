/*
String matching problem
Time - O(mn), m-text length, n-pattern length
Space - O(1)
If i/p is of really huge size, it takes lot of time.
 */
package RBR_DSA.Strings.String_Matching;

public class Brute_force {
    public static int match(String text,String pattern)
    {
        if(text.length() < pattern.length())
            return -1;
        for(int i=0;i<text.length();i++)
        {
            int j=0;
            for(j=0;j<pattern.length();j++)
            {
                if(text.charAt(i+j) != pattern.charAt(j))
                    break;
            }
            if(j == pattern.length())
                return i;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int x=match("101101010101011101101","11101");
        if(x == -1)
            System.out.println("Pattern didn't match");
        else
            System.out.println("Pattern matched text at "+x+1);

        x=match("1011000","11101");
        if(x == -1)
            System.out.println("Pattern didn't match");
        else
            System.out.println("Pattern matched text at "+x+1);
    }
}
