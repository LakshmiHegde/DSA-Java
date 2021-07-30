/*
Time = O(n) 1 pass
Space = O(n)
 */
package RBR_DSA.LinkedListPrograms;

import java.util.HashSet;

public class DeleteLoopInLL {
    public static void breakLoopBruteForce(LinkedList l1)
    {
        LinkedList.NodeMod temp=l1.head,previous=null;
        //push all addresses into hash table.
        HashSet nextAddresses=new HashSet();
        boolean inserted=false;
        while(temp!=null)
        {
            if(nextAddresses.add(temp)==false)//current node, is the end node of loop
            {
                previous.next=null;
                break;
            }
            previous=temp;
            temp=temp.next;
        }
    }
    public static void breakLoopInLL(LinkedList l1)
    {
        LinkedList.NodeMod temp=l1.head;
        LinkedList.NodeMod fast,slow,inLoopPtr=null;
        fast=slow=l1.head;

        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                inLoopPtr=fast;
                break;
            }
        }
        //IF no loops
        if(inLoopPtr == null)
            return;
        //No of elements in loop
        int count=1;
        slow=slow.next;
        //Right now, inLoopPtr and slow are pointing to same node
        // move slow one node next, so that inLoopPtr and slow will be different, if not, they don't pass below loop
        while(inLoopPtr!=slow)
        {
            slow=slow.next;
            count++;
        }
        //Distance k-1 between 2 pointers, to find starting of the loop
        slow=fast=l1.head;
        for(int i=1;i<=count-1;i++)
            fast=fast.next;
        //to find the start of loop
        while(fast.next!=slow)
        {
            fast=fast.next;
            slow=slow.next;
        }
        //now fast is at the end of node in loop
        fast.next=null;


    }
    public static void main(String[] args)
    {
        //single node loop
        LinkedList l1=new LinkedList();
        l1.head=new LinkedList.NodeMod(6);
        l1.head.next = l1.head;
        System.out.println("Is loop present? " + RBR_DSA.LinkedListPrograms.LoopInLL.isLoopPresent2(l1));
        //breakLoopBruteForce(l2);
        breakLoopInLL(l1);
        System.out.println("After breaking loop,  Is loop present? " + RBR_DSA.LinkedListPrograms.LoopInLL.isLoopPresent2(l1));
        l1.Display();

        //Loop on itself
        LinkedList l2=new LinkedList();
        l2.head=new LinkedList.NodeMod(6);
        LinkedList.NodeMod newNode=new LinkedList.NodeMod(10);
        l2.head.next = newNode;
        newNode.next=newNode;//6->10->on 10
        System.out.println("Is loop present? " + RBR_DSA.LinkedListPrograms.LoopInLL.isLoopPresent2(l2));
        //breakLoopBruteForce(l2);
        breakLoopInLL(l2);
        System.out.println("After breaking loop,  Is loop present? " + RBR_DSA.LinkedListPrograms.LoopInLL.isLoopPresent2(l2));
        l2.Display();

        //Cycle
        LinkedList l3=new LinkedList();
        l3.head=new LinkedList.NodeMod(6);
        LinkedList.NodeMod temp=new LinkedList.NodeMod(5);// new node with 5 is created
        l3.head.next=temp; //6->5->null
        temp.next=l3.head;//6->5->points to head again, loop
        System.out.println("Is loop present? " + RBR_DSA.LinkedListPrograms.LoopInLL.isLoopPresent2(l3));
        //breakLoopBruteForce(l3);
        breakLoopInLL(l3);
        System.out.println("After breaking loop,  Is loop present? " + RBR_DSA.LinkedListPrograms.LoopInLL.isLoopPresent2(l3));
        l3.Display();

        //No loops
        LinkedList l4=new LinkedList();
        l4.head=new LinkedList.NodeMod(10);
        l4.addAtBegining(new LinkedList.NodeMod(5));
        l4.addAtBegining(new LinkedList.NodeMod(3));
        l4.addAtBegining(new LinkedList.NodeMod(20));
        l4.Display();
        System.out.println("Is loop present? " + RBR_DSA.LinkedListPrograms.LoopInLL.isLoopPresent2(l3));
        //breakLoopBruteForce(l3);
        breakLoopInLL(l3);
        //System.out.println("After breaking loop,  Is loop present? " + RBR_DSA.LinkedListPrograms.LoopInLL.isLoopPresent2(l3));
        l4.Display();

    }
}
