/*
First n fibonacci series using dynamic programming
Time = O(n)
Space = O(n)
 */
package RBR_DSA.DynamicProgramming.Fibonacci_Series;

public class Using_bottomUpImplementation {
    public static void fibonacci(int n)
    {
        System.out.println("First "+n+" fibonacci series");
        if(n == 1)
        {
            System.out.println("0");
        }
        else if( n ==2)
        {
            System.out.println("0  1");
        }
        else
        {
            int T[]=new int[n];
            T[0]=0;
            T[1]=1;
            System.out.print(T[0]+"  "+T[1]+"   ");
            for(int i=2;i<n;i++)
            {
                T[i]=T[i-1]+T[i-2];
                System.out.print(T[i]+"   ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        fibonacci(5);
        fibonacci(2);
        fibonacci(3);
    }
}
