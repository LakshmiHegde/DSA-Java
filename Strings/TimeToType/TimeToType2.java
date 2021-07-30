/*
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY =O(1)
 */
package RBR_DSA.TimeToType;

import java.util.Scanner;

public class TimeToType2 {
    public static void main(String[] args){
        String keyboard="QWERTYUIOPASDFGHJKLZXCVBNM";
        String text;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text you want to type");
        text = sc.next().toUpperCase();//toUpperCase takes O(n) as string needs to be traversed to convert
        int[] key=new int[256];//O(c)
        for(int i=0;i<keyboard.length();i++) //O(keyboard size) constant
        {
            key[keyboard.charAt(i)]=i;
        }

        int time=0;
        for(int i=1;i<text.length();i++)//O(n)
        {
            int x=key[text.charAt(i)]; //charAt O(1)
            int y=key[text.charAt(i-1)];
            time=time+Math.abs(x-y);
        }
        System.out.println("Time taken to type "+text+" is "+time);
    }
}
