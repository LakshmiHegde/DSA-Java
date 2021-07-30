/*
pushNegativeLeft - Insertion order not preserved, in-place
Time = O(n)
Space = O(1)
pushPreservingOrder - Out-place arrangement, insertion order preserved using merge sort
Time = O(n)
Space =O(n)
 */
package RBR_DSA.ArrayProblems;

import java.util.Arrays;

public class negativeToOneSide {
    public static void pushNegativeLeft(int[] arr) //Insertion order not preserved
    {
        int j=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<0)
            {
                j++;
                arr[j]=arr[i]+arr[j];
                arr[i]=arr[j]-arr[i];
                arr[j]=arr[j]-arr[i];
            }
        }
    }
    public static void pushPreservingOrder(int[] arr , int left, int mid, int right)
    {
        int[] leftArr, rightArr;
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int arrleft = 0, arrright = arr.length - 1;
        leftArr = new int[leftSize];
        rightArr = new int[rightSize];
        for (int i = 0; i < leftSize; i++)
            leftArr[i] = arr[i];
        int index = leftSize;
        for (int i = 0; i < rightSize; i++)
            rightArr[i] = arr[index++];


        index = 0;
        //Add negative part of left and right halves.
        while (index < leftSize)
        {
            if (leftArr[index] < 0)
                arr[arrleft++] = leftArr[index++];
            else
                index++;
        }

        index=0;
        while(index<rightSize)
        {
            if (rightArr[index] < 0)
                arr[arrleft++] = rightArr[index++];
            else
                index++;
        }

        //Add positive part of left and right halves.
        index=0;
        while(index<leftSize)
        {
            if (leftArr[index] >= 0)
                arr[arrleft++] = leftArr[index++];
            else
                index++;
        }

        index=0;
        while(index<rightSize)
        {
            if (rightArr[index] >= 0)
                arr[arrleft++] = rightArr[index++];
            else
                index++;
        }
    }

    public static void main(String[] args)
    {
        int testCase1[]={12, 11 ,-13, -5, 6, -7, 5, -3, -6};
        int mid = (testCase1.length-1)/2;
        pushPreservingOrder(testCase1 , 0 , mid , testCase1.length-1 );
        for(int element:testCase1)
           System.out.print(element+"   ");
        System.out.println();

        int testCase2[]={0,-1,-2,-4,-3,-8,1};
        mid=(testCase2.length-1)/2;
        pushPreservingOrder(testCase2 , 0 , mid , testCase2.length-1);
        for(int element:testCase2)
            System.out.print(element+"   ");
        System.out.println();

        int testCase3[]={0,1,2,4,-3,-8,-1};
        mid=(testCase3.length-1)/2;
        pushPreservingOrder(testCase3 , 0 , mid , testCase3.length-1);
        for(int element:testCase3)
            System.out.print(element+"   ");
        System.out.println();

        int testCase4[]={0,1,2,4,3,0,1};
        mid=(testCase4.length-1)/2;
        pushPreservingOrder(testCase4 , 0 , mid , testCase4.length-1);
        for(int element:testCase4)
            System.out.print(element+"   ");
        System.out.println();

        int testCase5[]={-0,-1,-2,4,3,0,1};
        mid=(testCase5.length-1)/2;
        pushPreservingOrder(testCase5 , 0 , mid , testCase5.length-1);
        for(int element:testCase5)
            System.out.print(element+"   ");
        System.out.println();

    }
}
