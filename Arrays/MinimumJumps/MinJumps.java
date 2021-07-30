/*
Problem Statement - Minimum jumps to reach end of the array
Time = O(n2)
Space = O(n)
 */
package RBR_DSA.MinimumJumps;

import java.util.Arrays;

public class MinJumps {
    static int minJumps(int[] arr)
    {
        int size=arr.length , minVal;
        int[] minJumpsSoFar= new int[arr.length];
        Arrays.fill(minJumpsSoFar,-1);
        minJumpsSoFar[size-1]=0;
        if(arr[0] == 0)
            return -1;
        for(int i=size-2; i>=0 ; i--)
        {
            minVal= minimumJumpsCompute(minJumpsSoFar, arr,i+1,i+1+arr[i]);
            if(minVal == Integer.MAX_VALUE)
           // By using current jump value, if you're not able to land on any place where jump value is > 0, then you're returned with min value as initialized in minimumJumpsCompute.
           //For ex: 2 0 0 1, you cannot reach end at even after jumping two times then, minimumJumpsCompute will return Integer.MAX_VALUE.
           // If no follow up path, is not present, then return -1.
            {
                return -1;
            }
            else if (minVal == -1) // If current jump  value is 0, then, it is indicated by special pattern of -100.
            {
                minJumpsSoFar[i]=-100;
            }
            else
            {
                minJumpsSoFar[i]=1 + minVal;
            }
        }
        return minJumpsSoFar[0];
    }
    static int minimumJumpsCompute(int[] T,int[] arr, int start ,int len)
    {
        int min=Integer.MAX_VALUE;
        if(start==len)
            return -1;
        if(len > arr.length)
            return 0;

        for(int i=start; i<len;i++)
        {
            if(T[i] >=0) // Ignore if the jumps are 0.
            {
                if(T[i]<min)
                    min=T[i];
            }
        }
        return min;
    }
    public static void main(String[] args)
    {
        String arr[] = "70 40 9 19 94 84 15 87 71 45 87 85 5 53 13 43 10 50 94 91 38 63 98 33 99 91 86 66 43 80 35 79 20 10 98 80 61 13 66 31 24 18 82 97 72 61 39 48 11 99 38 49 27 2 49 26 59 0 58 1 81 59 80 67 70 77 46 97 56 79 27 81 63 75 77 0".split(" ");
        int intarr[]= new int[arr.length];
        for(int i=0;i<arr.length;i++)
            intarr[i]=Integer.valueOf(arr[i]);
        System.out.println("Minimum jumps required "+minJumps(intarr));

        int testCase1[]={2, 3 ,1, 1, 2, 4 ,2 ,0, 1, 1};
        System.out.println("Minimum jumps required "+minJumps(testCase1));

        int testCase2[]={2,2 ,0, 1, 1};
        System.out.println("Minimum jumps required "+minJumps(testCase2));

        int testCase3[]={1,0, 1, 1};
        System.out.println("Minimum jumps required "+minJumps(testCase3));

        int testCase4[]={0,2, 1, 1};
        System.out.println("Minimum jumps required "+minJumps(testCase4));

        int testCase5[]={2, 0, 0};
        System.out.println("Minimum jumps required "+minJumps(testCase5));

    }
}
