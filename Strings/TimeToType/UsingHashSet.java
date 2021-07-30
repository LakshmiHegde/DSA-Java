/*
when there are more characters especially when unicode is used as character set, we cant create array to hold them all
You can use hash table, where key is character and value is its index in array
Time = O(n)
Space = O(keyboardLength)
 */
package RBR_DSA.TimeToType;


import java.util.Hashtable;

import java.util.Scanner;

public class UsingHashSet {
    public static void main(String[] args) {
        String keyboard = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String text;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text you want to type");
        text=sc.next().toUpperCase();
        Hashtable h=new Hashtable(); //O(keyboardLength)
        for(int i=0;i<keyboard.length();i++){
            h.put(keyboard.charAt(i),i);
        }
        System.out.println(h);

        int time=0;
        for(int i=1;i<text.length();i++)//O(n)
        {
            int x=Integer.valueOf(h.get(text.charAt(i)).toString()); //charAt O(1)
            int y=Integer.valueOf(h.get(text.charAt(i-1)).toString());
            time=time+Math.abs(x-y);
        }
        System.out.println("Time taken to type "+text+" is "+time);
    }

}
