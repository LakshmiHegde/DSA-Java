/*
Given 2 strings, check if one is valid shuffle of other or not
Time = O(m)+O(n)
Space = O(256*2) = O(1)
 */
package RBR_DSA.Strings.Shuffle;


public class Shuffle {
    public static boolean shuffle(String str1,String str2)
    {
        int ch1[]=new int[256];
        int ch2[]=new int[256];
        int j=0;
        for(j=0;j<str1.length();j++)
        {
            ch1[str1.charAt(j)-'a']++;
        }
        for(j=0;j<str2.length();j++)
        {
            ch2[str2.charAt(j)-'a']++;
        }
        for(int i=0;i<256;i++)
        {
            if(ch1[i] > ch2[i] ||ch1[i] > 0 && ch2[i] == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        String txt = "BAC";
        String pat = "ABB";
        if(shuffle(pat.toLowerCase(),txt.toLowerCase()))
            System.out.println("Valid shuffle");
        else
            System.out.println("Not a valid shuffle");
    }
}
