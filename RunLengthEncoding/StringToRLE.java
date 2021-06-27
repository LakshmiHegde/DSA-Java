/*
Time complexity = O(n)
Space Complexity =O(1)
 */
package RBR_DSA.RunLengthEncoding;
import java.util.*;
public class StringToRLE {
    public void RLE(String str) //O(n)
    {
        int count;
        int n=str.length();
        for(int i=0;i<n;i++){
            count=1;
            while(i<n-1 && str.charAt(i)==str.charAt(i+1)){
                i++;
                count++;
            }
            System.out.print(str.charAt(i)+""+count);
        }
        System.out.println();
    }
    public static void main(String[] args){
        String testCase1="AAABBCA";
        String testCase2="AAABBAAAABBBB";
        StringToRLE s=new StringToRLE();
        s.RLE(testCase1);
        s.RLE(testCase2);
    }
}
