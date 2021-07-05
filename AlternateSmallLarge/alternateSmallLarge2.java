/*
WORKS ONLY FOR POSITIVE NUMBERS WITHIN ARRAY.
Since sorting is employed O(nlogn) is time complexity.
When they give you sorted array, the approach just takes O(n)
Space = O(1)
 */
package RBR_DSA;

import java.util.Arrays;

public class alternateSmallLarge2 {
    public static void rearrange(int arr[], int n){
        Arrays.sort(arr); // O(nlogn)
        int j=n-1;
        int bound=arr[n-1]+1;
        int large=0,small=1;
        for(int i=0;small<n;i++,j--) //O(n)
        {
            arr[large] += (arr[j]%bound)*bound;
            arr[small] += (arr[i]%bound)*bound;
            large+=2;
            small+=2;
        }
        if(n%2!=0)
        {
            arr[large]+=(arr[j]%bound)*bound;
        }
        for(int i=0;i<n;i++)
        {
            arr[i]/=bound;
        }
    }
    public static void display(int[] arr)
    {
        for(int x:arr)
            System.out.print(x+"   ");
        System.out.println();
    }
    public static void main(String[] args)
    {
        int testCase1[]={1,2,5,0,3,4};
        rearrange(testCase1,6);
        display(testCase1);

        int testCase2[]={1,2,5,0};
        rearrange(testCase2,4);
        display(testCase2);

        int testCase3[]={10,2,15,33,14};
        rearrange(testCase3,5);
        display(testCase3);
    }
}
