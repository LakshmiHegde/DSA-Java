/*
isLoopPresent -
Time - O(n)
Space = O(n)

isLoopPresent2 -
Time - O(n)
Space = O(1)

 */
package RBR_DSA.LinkedListPrograms;

import java.util.HashSet;
import java.util.PriorityQueue;

public class LoopInLL {
    public static boolean IsLoopPresent(LinkedList l1)
    {
        LinkedList.NodeMod temp=l1.head;
        //push all next addresses into hash table.
        HashSet nextAddresses=new HashSet();
        boolean inserted=false;
        while(temp!=null)
        {
            if(nextAddresses.add(temp)==false)
            {
                //loop exists
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public static boolean isLoopPresent2(LinkedList l1)
    {
        LinkedList.NodeMod temp=l1.head;
        LinkedList.NodeMod fast,slow;
        fast=slow=l1.head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        LinkedList result=new LinkedList();
        LinkedList l1=new LinkedList();
        l1.head=new LinkedList.NodeMod(10);
        l1.addAtBegining(new LinkedList.NodeMod(5));
        l1.addAtBegining(new LinkedList.NodeMod(3));
        l1.addAtBegining(new LinkedList.NodeMod(0));
        l1.addAtBegining(new LinkedList.NodeMod(10));
        l1.Display();
        System.out.println("Is loop present? " + isLoopPresent2(l1));
        LinkedList l2=new LinkedList();
        l2.head=new LinkedList.NodeMod(6);
        l2.head.next = l2.head; // loop
        System.out.println("Is loop present? " + IsLoopPresent(l2));
        //System.out.println("Is loop present? " + isLoopPresent2(l2));
        LinkedList l3=new LinkedList();
        l3.head=new LinkedList.NodeMod(6);
        LinkedList.NodeMod temp=new LinkedList.NodeMod(5);// new node with 5 is created
        l3.head.next=temp; //6->5->null
        temp.next=l3.head;//6->5->points to head again, loop
        System.out.println("Is loop present? " + isLoopPresent2(l3));



    }
}
