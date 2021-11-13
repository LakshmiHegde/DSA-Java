/*
Program to count anagrams in string, with given pattern.
Time - O(n), n-length of string.
Space - O(1)
 */
package LeetCode.Count_Anagrams;

import java.util.Arrays;

public class Count_Anagrams {
    static int search(String pat, String txt)
    {
        // code here
        int patarr[]=new int[26];
        int strarr[]=new int[26];

        for(int i=0;i<26;i++)
        {
            patarr[i]=0;
            strarr[i]=0;
        }

        int i=0;
        for(i=0;i<pat.length();i++)
        {
            patarr[pat.charAt(i)-'a']++;
            strarr[txt.charAt(i)-'a']++;
        }

        int count=0;
        if(Arrays.equals(patarr,strarr))
        {
            count++;
        }
        int j=0;
        for(;i<txt.length();i++)
        {
            strarr[txt.charAt(j) - 'a']--;
            strarr[txt.charAt(i)-'a']++;

            if(Arrays.equals(patarr,strarr))
            {
                count++;
            }
            j++;
        }
        return count;

    }

    public static void main(String[] args)
    {
        String txt="forxxorfxdofr";
        String pat="for";

        System.out.println("Number of anagrams for "+ pat+" in given string "+txt+ " is/are "+search(pat,txt));
    }
}
