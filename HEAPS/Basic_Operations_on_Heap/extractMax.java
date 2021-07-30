/*
extractMAxElement
Time = O(logn)
Space = O(logn) as max_heapify called in extract_max, the space and time complexity is O(logn)
 */
package RBR_DSA.HEAPS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class extractMax {
    public static void max_Heapify(ArrayList<Integer> heap, int pos)
    {
        Integer left = 2*pos+1;
        Integer right = 2*pos + 2;
        Integer largest=pos;
        if(left < heap.size() && heap.get(left) > heap.get(largest))
        {
            largest=left;
        }
        if(right < heap.size() && heap.get(right) > heap.get(largest))
        {
            largest=right;
        }

        if(largest!=pos)
        {
            int temp=heap.get(largest);
            heap.set(largest, heap.get(pos));
            heap.set(pos, temp);
            max_Heapify(heap,largest);
        }

    }
    public static int extractMaxElement(ArrayList<Integer> heap)
    {
        int size=heap.size();
        int max = heap.get(0);
        heap.set(0, heap.get(size-1));
        heap.remove(size-1);
        max_Heapify(heap,0);
        return max;
    }

    public static void main(String[] args)
    {
        Integer heapArr[] = {10,9,7,6,8,5,-4};
        ArrayList heap = new ArrayList(Arrays.asList(heapArr));
        System.out.println("Maximum element = "+ extractMaxElement(heap));
        System.out.println(heap.size());
        Iterator itr=heap.listIterator();
        while(itr.hasNext())
        {
            System.out.print(itr.next() + "   ");
        }

    }
}
