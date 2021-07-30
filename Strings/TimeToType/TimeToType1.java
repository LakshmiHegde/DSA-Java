/*
Time to type a string
Time complexity: O(n2)
Space complexity: O(1)
 */
package RBR_DSA.TimeToType;

import java.util.Scanner;

public class TimeToType1 {
    public static void main(String[] args){
        String keyboard="QWERTYUIOPASDFGHJKLZXCVBNM";
        String text;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text you want to type");
        text = sc.next().toUpperCase();//toUpperCase takes O(n) as string needs to be traversed to convert

        int time=0;
        for(int i=1;i<text.length();i++){
            int x=text.charAt(i);//O(1), just using character array , on which string is formed, and retrieving the character at 'i'
            int y=text.charAt(i-1);
            //The complexity of Java's implementation of indexOf is O (m*n) where n and m are the length of the search string and pattern respectively.
            //String length is n, pattern length is 1, Therefore, O(n)
            time=time+Math.abs(keyboard.indexOf(x)-keyboard.indexOf(y));
        }
        System.out.println("Time taken to type "+text+" is "+time);
    }
}
