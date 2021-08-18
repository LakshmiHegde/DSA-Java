/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string ""

Time =O(minLength), among all the strings, we are checking for only shorter length times,  in worst case, shorter length string maybe the common prefix
for character at i:
    for each string in stringarray
        check if all strings have same character at i, if not, return the common string, found till then.
 */
package LeetCode;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++)
            min=Math.min(strs[i].length(),min);
        String res="";
        for(int i=0;i<min;i++)
        {
            int j=0;
            char key='\0';
            while(j<strs.length)
            {
                if(j==0)
                {
                    key=strs[j].charAt(i);
                }
                else
                {
                    if(key != strs[j].charAt(i))
                        return res;
                }
                j++;
            }
            res+=key;
        }
        return res;
    }
    public static void main(String[] args)
    {
        String strs[] = {"flower","flow","flight"};
        System.out.println("Common prefix "+longestCommonPrefix(strs));

        String strs2[] = {"dog","racecar","car"};
        System.out.println("Common prefix "+longestCommonPrefix(strs2));

        String strs3[] = {"geeks","geeksforgeeks","geeksquiz","geeksplatform"};
        System.out.println("Common prefix "+longestCommonPrefix(strs3));

    }
}
