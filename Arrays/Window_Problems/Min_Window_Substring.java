/*
Problem Statement:
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".

Time: O(m+n)
Space: O(1)
 */
package LeetCode.Window_Problems;

public class Min_Window_Substring {
    public int equal(int s[],int p[])
    {
        for(int i=0;i<256;i++)
        {
            if(p[i] == s[i])
                continue;
            else if(p[i] > s[i])
                return 0;

        }
        return 1;
    }
    public String minWindow(String s, String t) {
        int pattern[]=new int[256];
        int str[]=new int[256];
        int left=0,len=Integer.MAX_VALUE,start=-1;

        for(int i=0;i<256;i++)
        {
            pattern[i]=0;
            str[i]=0;
        }

        for(int i=0;i<t.length();i++)
        {
            pattern[t.charAt(i)]++;
        }

        int i=0;
        while(i<s.length())
        {
            str[s.charAt(i)]++;

            if(equal(str,pattern) == 1)
            {
                if(len > i-left+1)
                {
                    len=i-left+1;
                    start=left;
                }

                while(left<=i)
                {

                    str[s.charAt(left)]--;
                    left++;

                    if(equal(str,pattern) == 1)
                    {
                        if(len > i-left+1)
                        {
                            len=i-left+1;
                            start=left;
                        }
                        continue;
                    }
                    else
                        break;
                }
            }
            i++;
        }
        if(start!=-1)
            return s.substring(start,start+len);
        else
            return "";

    }
    public static void main(String[] args)
    {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        Min_Window_Substring m=new Min_Window_Substring();
        System.out.println("Min window substring containing "+ t + " is "+m.minWindow(s,t));
    }
}
