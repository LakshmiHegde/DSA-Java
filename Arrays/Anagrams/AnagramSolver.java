package RBR_DSA.AnagramSolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Arrays;

public class AnagramSolver {
    public static void setCharArray(int[] ch, String s) //O(n)
    {
        for(int i=0;i<s.length();i++)
        {
            //Ignore spaces
            if(Character.isWhitespace(s.charAt(i))){
                continue;
            }
            //check if character is ASCII
            if(s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='A' && s.charAt(i)<='Z'){
                ch[s.charAt(i)]++;
            }
            else{
                System.out.println("Invalid Character");
                System.exit(0);
            }
        }

    }
    public static boolean findIfAnagram(int ch[],int c[])//O(c)
    {
        for(int i=0;i<256;i++){
            if(ch[i]!= c[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        String input;
        int ch[]=new int[256];
        String[] source={"Bee Season","alte","tale","editor macros"};
        int c[]=new int[256];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter scrambled string");
        input=sc.nextLine();
        setCharArray(c,input.toUpperCase());//O(n)
        ArrayList results=new ArrayList();
        for(int i=0;i<source.length;i++)//O(n)
        {
            setCharArray(ch, source[i].toUpperCase());
            boolean flag=findIfAnagram(ch,c);
            if(flag == true)
            {
                results.add(source[i]);
            }
            //Since we are using same array ch for every string in collection, one string's character count should not affect others
            //therefore just again reset array back to all 0's
            Arrays.fill(ch,0);
        }
        if(results.size()!=0){
            Iterator itr=results.listIterator();
            System.out.println("Anagrams found are");
            while(itr.hasNext())
            {
                System.out.println(itr.next());
            }
        }
        else{
            System.out.println("No anagrams found...");
        }


    }
}
