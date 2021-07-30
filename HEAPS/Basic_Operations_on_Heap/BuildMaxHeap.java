/*
max_Heapify
Time = O(logn)
Space = O(logn)

buildMaxHeap
Time = O(n)
Space = O(logn) // max heapify takes O(logn) as stack depth in worst  case.
 */
package RBR_DSA.HEAPS;

import java.util.Arrays;

public class BuildMaxHeap {
    public static void max_Heapify(int[] heap, int pos)
    {
        int left = 2*pos+1;
        int right = 2*pos + 2;
        int largest=pos;
        if(left < heap.length && heap[left] > heap[largest])
        {
            largest=left;
        }
        if(right < heap.length && heap[right] > heap[largest])
        {
            largest=right;
        }

        if(largest!=pos)
        {
            int temp=heap[largest];
            heap[largest] = heap[pos];
            heap[pos]=temp;
            max_Heapify(heap,largest);
        }

    }
    public static void buildMaxHeap(int [] heap)
    {
        int nonLeaf = (heap.length/2) -1;
        System.out.println(nonLeaf);
        for(int i=nonLeaf ; i>=0;i--)
        {
            max_Heapify(heap,i);
        }

    }
    public static void main(String[] args)
    {
        int heapArray[] = {1,9,2,4,0,-2,-5,3,-9,10};

        buildMaxHeap(heapArray);
        for(int x: heapArray)
            System.out.print(x + "    ");
    }
}
