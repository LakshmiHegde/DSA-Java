/*
Print sorted elements of row-column wise sorted matrix
Even if row is sorted, and columns not sorted it works
Space = O(m), m- No of rows
Time = O(nm log m)
 */
package RBR_DSA.ArrayProblems;

import java.util.PriorityQueue;

public class printSortedElements {
    public static void printSort(int[][] arr,int m,int n)
    {
        //We used HeapEntry and MyComparator from mergeKSortedArrays Program
        PriorityQueue<HeapEntry> p=new PriorityQueue<HeapEntry>(new MyComparator());
        for(int i=0;i<m;i++)
        {
            p.add(new HeapEntry(arr[i][0],i,1));//O(m)
        }
        for(int j=0;j<n*m;j++)//O(nm)
        {
            HeapEntry r=p.poll();//O(log m)
            System.out.print(r.ele+"    ");
            if(r.nextEleIndex<n)
            {
                r.ele=arr[r.arrNum][r.nextEleIndex++];
                p.add(r);//O(log m)
            }
        }
    }
    public static void main(String[] args)
    {
        int[][] arr={
                {2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}
        };
        printSort(arr,3,4);
        System.out.println();
        int[][] arr2={
                {1,2,5,7,8},
                {3,9,10,21,22},
                {-13,-1,0,6,11}
        };

        printSort(arr2,3,5);
        System.out.println();
    }
}
