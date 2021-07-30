package RBR_DSA.InterconversionLibrary;

import javax.print.CancelablePrintJob;
import java.util.Scanner;

public class StringToInteger {
    public static void convert(String s)
    {
        if(s.length()==0 || s==null)
            throw new RuntimeException("Empty String");

        s=s.trim();
        int sign=0,index=0;
       if(s.charAt(0)=='+' || s.charAt(0)=='-')
       {
           index=1;
           if(s.charAt(0)=='+')
                 sign=1;
           else
               sign=-1;
       }

       int x, data=0;
       for(;index<s.length();index++){
           if(Character.isDigit(s.charAt(index))){
               x=s.charAt(index)-'0';
               data=data*10+x;
           }
           else throw new IllegalArgumentException("Invalid input");
       }
       if(sign!=0)
           System.out.println(data*sign);
       else
           System.out.println(data);

    }
    public static void main(String args[]){
        String s;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        s=sc.next();
        convert(s);

    }
}
