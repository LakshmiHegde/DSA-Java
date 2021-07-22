/*
Uses Heap implementation, i,e used for merging K sorted arrays
Same constraints, considerig r and c are odd, we are returning median
This works for elements , even if its less than 0, i,e elements can be negative inside matrix.
Space = O(c), c-columns
Time= O[(n*k)/2 * logK] = O((nK)logK)
 */
package RBR_DSA.ArrayProblems;
import java.util.*;

public class medianOfRowWiseSortedArrays {
    static int median(int arr[][], int r, int c) {
        // code here
        PriorityQueue<HeapEntry> h=new PriorityQueue<HeapEntry>(new MyComparator());
        int totalElements=0;
        for(int j=0;j<r;j++)
        {
            h.add(new HeapEntry(arr[j][0],j,1));
            totalElements+=arr[j].length;
        }
        totalElements/=2;

        for(int i=0;i<totalElements;i++) //O((n*K)/2), k is generalized form of columns
        {
            HeapEntry e=h.poll(); //O(logK)
            if(e.nextEleIndex < arr[e.arrNum].length)
            {
                e.ele=arr[e.arrNum][e.nextEleIndex++];
                h.add(e);//O(logK)
            }
            else
            {
                e.ele=Integer.MAX_VALUE;
            }
        }
        return h.poll().ele;
    }
    public static void main(String args[]) {
        int arr[][] = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        System.out.println(median(arr,3,3));

        int arr2[][] ={
                {1},{2},{3}
        };
        System.out.println(median(arr2,3,1));
    }
}
