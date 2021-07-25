/*
Time Complexity: O(n)
Space Complexity: O(1)
 */
package RBR_DSA.MaxProduct;

import java.util.Scanner;

public class source {
    public static int maxPro(int[] a){

        int max1=Integer.MIN_VALUE, max2=Integer.MIN_VALUE, max3=Integer.MIN_VALUE;//Just assigning Max value, so that its easy to compare.
        int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;

        for(int n:a){
            //Top 3 max elements are obtained
            if(n>max1){
                max3=max2;
                max2=max1;
                max1=n;
            }
            else if(n>max2){
                max3=max2;
                max2=n;
            }
            else if(n>max3){
                max3=n;
            }


            //For Min element finding
            if(n<min1){
                min2=min1;
                min1=n;
            }
            else if(n<min2){
                min2=n;
            }
        }
        //Find max of two products
        int prod1 = max1*max2*max3;
        int prod2=max1*min1*min2;

        return Math.max(prod1,prod2);
    }
    public static void main(String[] args){
        int[] arr;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size");
        int n=sc.nextInt();
        arr=new int[n];
        System.out.println("enter "+n+" elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        if(arr.length<=2)
            System.out.println("Provide atleast 3 elements");
        else
            System.out.println(maxPro(arr));

    }
}
