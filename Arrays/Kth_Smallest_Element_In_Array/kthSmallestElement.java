package RBR_DSA;

import java.util.Comparator;
import java.util.PriorityQueue;
class Mycomparator implements Comparator
{
    public int compare(Object o1, Object o2)
    {
        Integer num1=(Integer)o1;
        Integer num2=(Integer)o2;
        return num2.compareTo(num1);
    }
}
public class kthSmallestElement {
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(new Mycomparator());
        int i=l;
        for(;i<k;i++)
        {
            maxHeap.add(arr[i]);
        }
        int pop;
        for(;i<=r;i++)
        {
            if(arr[i]<(Integer)maxHeap.peek())
            {
                pop=maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

        pop=maxHeap.poll();
        return(pop);
    }
    public static void main(String[] args)
    {
        int arr[] =  {7,-1,0,4,12,-3,7,3,10, 4, 20, 15};

        System.out.println(kthSmallest(arr,0,arr.length-1,4));
        System.out.println(kthSmallest(arr,0,arr.length-1,1));
        System.out.println(kthSmallest(arr,0,arr.length-1,arr.length));
        System.out.println(kthSmallest(arr,0,arr.length-1,2));

    }
}
