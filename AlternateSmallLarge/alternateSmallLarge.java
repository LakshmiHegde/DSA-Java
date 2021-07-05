/*
Time=O(n^2)
Space=O(1)
 */
package RBR_DSA;

import java.util.Arrays;

public class alternateSmallLarge {
    public static void smallNegative(int[] arr,int n)
    {
        Arrays.sort(arr); //O(nlogn)
        int j=n-1;
        for(int i=0;i<n;i+=2)
        {
            rotate(arr,n,j,i);//first, you move, n-1, next, n-3, next n-5 so on till 1, sum of first n odd / even numbers is n2
        }
    }
    public static void rotate(int[] arr,int size,int toIndex, int fromIndex)//O(n)
    {
        int temp=arr[toIndex];
        for(int i=toIndex; i>fromIndex; i--)
            arr[i]=arr[i-1];
        arr[fromIndex]=temp;
    }
    public static void display(int[] arr)//O(n)
    {
        for(int x:arr)
            System.out.print(x+"   ");
        System.out.println();
    }
    public static void main(String[] args)
    {
        int testCase1[]={1,2,5,0,3,4};
        smallNegative(testCase1,6);
        display(testCase1);

        int testCase2[]={-1,-2,-5,-3,4};
        smallNegative(testCase2,5);
        display(testCase2);
    }
}
