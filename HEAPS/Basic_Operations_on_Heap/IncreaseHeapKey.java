/*
increaseHeapKey
Time = O(logn), in worst case,when increase key is called on leaf node, we may run while loop for reaching from last element till root.
Space = O(1)

insertIntoHeap , same as increaseHeapKEy, as we use it as base here
Time = O(logn)
Space = O(1)

DisplayHeap iterating over entire array lise
O(n)
 */
package RBR_DSA.HEAPS;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IncreaseHeapKey {
    public static void increaseHeapKey(ArrayList<Integer> heap, int key, int pos)
    {
        int value=heap.get(pos);
        if(key<value)
            return;
        heap.set(pos, key);
        //System.out.println(Math.ceil(9/2.0));
        int parent = (int)Math.ceil(pos/2.0) -1;
        while(parent >= 0 && heap.get(parent) < heap.get(pos))
        {
            int temp=heap.get(parent);
            heap.set(parent, heap.get(pos));
            heap.set(pos, temp);
            pos=parent;
            parent = (int)Math.ceil(pos/2.0) -1;
        }
    }
    public static void insertIntoHeap(ArrayList<Integer> heap, int data)
    {
        heap.add(Integer.MIN_VALUE);
        increaseHeapKey(heap, data ,heap.size() -1);
    }
    public static void DisplayHeap(ArrayList<Integer> heap)
    {
        Iterator itr=heap.listIterator();
        while(itr.hasNext())
        {
            System.out.print(itr.next() + "   ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Integer heapArr[] = {10,9,7,6,8,5,-4};
        ArrayList<Integer> heap = new ArrayList<Integer>(Arrays.asList(heapArr));
        insertIntoHeap(heap, 3);
        insertIntoHeap(heap, 12);
        insertIntoHeap(heap, -6);
        insertIntoHeap(heap, 9);
        System.out.println("Heap after insertions done");
        DisplayHeap(heap);

        ArrayList<Integer> testCase1=new ArrayList<Integer>();
        insertIntoHeap(testCase1,10);
        System.out.println("Heap after insertions done");
        DisplayHeap(testCase1);


    }
}
