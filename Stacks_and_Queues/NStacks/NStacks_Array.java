/*
N stacks in an array
Time = O(n)
Space = O(k+n), k-no of stacks, top arr space
n- array size, for next array
 */
package RBR_DSA.Stacks_and_Queues.NStacks;

import java.util.Arrays;

public class NStacks_Array {
    int[] top,next,arr;
    int free_slot;
    NStacks_Array(int n,int k)
    {
        free_slot=0;
        top=new int[k];
        next=new int[n];
        arr=new int[n];
        Arrays.fill(top,-1);
        for(int i=0;i<n-1;i++)
            next[i]=i+1;
        next[n-1]=-1;
    }
    public void push(int data, int stack_num)
    {
        if(free_slot == -1)
        {
            System.out.println("Stack full");
            return;
        }
        //put data in free slot
        arr[free_slot]=data;
        int i=free_slot;
        //make free_slot point to next available slots
        free_slot=next[free_slot];
        //store previous ele's stack top in next array
        next[i]=top[stack_num];
        //update stack top to current inserted index
        top[stack_num]=i;
    }
    public void pop(int stack_num)
    {
        if(top[stack_num] == -1)
        {
            System.out.println("Stack empty");
            return;
        }
        int t=top[stack_num];
        //make prev ele index as top
        top[stack_num]=next[t];
        //whatever is current free slot, make it as next available slot , at next[top_stack], so that, after utilizing, space available at popped element, you can use this free slot
        next[t]=free_slot;
        //current ele at arr[stack_top] is removed, therefore make stack_top as free slot.
        free_slot=t;
        System.out.println("Popped element at stack "+(stack_num+1)+" is "+arr[t]);
    }
    public static void main(String[] args)
    {
        NStacks_Array s=new NStacks_Array(10,4);
        s.push(3,0);
        s.push(-1,2);
        s.push(1,1);
        s.push(0,1);
        s.push(-4,2);
        s.push(5,0);
        s.push(2,1);
        s.push(13,3);
        s.push(8,0);
        s.push(40,3);
        s.pop(1);
        s.push(100,3);
        for(int x:s.arr)
            System.out.println(x);
        s.push(10,2);
    }
}
