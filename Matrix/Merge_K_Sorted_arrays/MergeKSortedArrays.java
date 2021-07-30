/*
Time=O(nK logK)
Space=O(K), if elements are directly printed, if you want to store and return, then, you should, need space of "nk" for result array

 */
package RBR_DSA.ArrayProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

class MyComparator implements Comparator
{
    public int compare(Object o1,Object o2)
    {
        HeapEntry e=(HeapEntry) o1;
        HeapEntry e2=(HeapEntry) o2;
        return e.ele.compareTo(e2.ele);
    }
}
class HeapEntry {
    Integer ele,arrNum,nextEleIndex;
    HeapEntry(int ele,int arrNum,int nextEleIndex)
    {
        this.arrNum=arrNum;
        this.ele=ele;
        this.nextEleIndex=nextEleIndex;
    }
}
public class MergeKSortedArrays {
    public static void mergeMinHeap(int[][] arr,int n)
    {
        PriorityQueue<HeapEntry> h=new PriorityQueue<HeapEntry>(new MyComparator());
        int totalElements=0;
        for(int j=0;j<n;j++)
        {
            h.add(new HeapEntry(arr[j][0],j,1));
            totalElements+=arr[j].length;
        }

        for(int i=0;i<totalElements;i++) //O(nk), k is generalized form of columns
        {
            HeapEntry e=h.poll(); //O(logK)
            System.out.print(e.ele+"     ");
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
    }
    public static void main(String[] args)
    {
        int[][] arr={
                {2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}
        };
        mergeMinHeap(arr,3);
    }
}
