package RBR_DSA.InterconversionLibrary;

import java.util.Scanner;

public class IntegerToString {
    public static StringBuffer convert(int x){
        char sign;
        if(x<0)
        {
            sign='-';
            x=-x;
        }
        else
        {
            sign='+';
        }

        int  digit;
        StringBuffer result=new StringBuffer();
        while(x>0){
            digit =x%10;
            result.append(digit);
            x=x/10;
        }
        result.append(sign);
        result.reverse();

        return result;

    }
    public static void main(String args[]){
        int number;
        System.out.println("Enter an integer");
        Scanner sc=new Scanner(System.in);
        number=sc.nextInt();
        System.out.println("String : "+convert(number));
    }
}
