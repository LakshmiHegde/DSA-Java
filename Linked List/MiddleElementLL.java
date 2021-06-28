/*
Using Count(1 and half passes) and 2 pointers approach(1pass) has same time space complexity
Time=O(n)
Space = O(1)
 */
package RBR_DSA.LinkedListPrograms;

public class MiddleElementLL {
    public static int countNodes(LinkedList.NodeMod start)
    {
        LinkedList.NodeMod temp=start;
        int count=0;
        while(temp!=null)
        {
            temp=temp.next;
            count++;
        }
        return count;
    }
    public static void middleElement(LinkedList.NodeMod start)
    {
        LinkedList.NodeMod temp=start;
        int count=countNodes(temp);

        for(int i=0;i<count/2 -1; i++)
            temp=temp.next;

        System.out.print("Middle elements is/are ");
        if(count%2==0)
            System.out.print(temp.data+"  and ");
        System.out.println(temp.next.data);
    }
    public static void twoPointersMiddle(LinkedList.NodeMod start)
    {
        LinkedList.NodeMod fast=start, slow=start;
        if(start==null)
            throw new RuntimeException("No elements in list");
        //for 1 or more elements following code can handle
        while(fast.next !=null && fast.next.next !=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        System.out.print("Middle elements is/are  ");
        if(fast.next==null)
            System.out.println(slow.data);
        else if(fast.next.next==null)
            System.out.println(slow.data+" and "+slow.next.data);
    }

    public static void deleteMiddle(LinkedList l1)
    {
        if(l1.head==null)
            throw new RuntimeException("List is empty");
        LinkedList.NodeMod slow,previous, fast;
        slow=fast=l1.head;
        previous=null;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            previous=slow;
            slow=slow.next;
        }
        if(fast.next==null)
        {
            if(previous==null)//only one element
                l1.head=null;
            else
                previous.next=slow.next;
        }
        else if(fast.next.next==null)
        {
            if(previous==null)//only two elements
                l1.head=null;
            else
                previous.next=slow.next.next;
        }
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
        System.out.println("------------------------------------------");
        middleElement(l1.head);
        deleteMiddle(l1);
        System.out.println("After Deleting middle elements");
        l1.Display();
        System.out.println("------------------------------------------");
        middleElement(l1.head);
        deleteMiddle(l1);
        System.out.println("After Deleting middle elements");
        l1.Display();
        System.out.println("------------------------------------------");
        middleElement(l1.head);
        deleteMiddle(l1);
        System.out.println("After Deleting middle elements");
        l1.Display();
        System.out.println("------------------------------------------");

        LinkedList l2=new LinkedList();
        l2.head=new LinkedList.NodeMod(6);
        l2.addAtBegining(new LinkedList.NodeMod(4));
        l2.addAtBegining(new LinkedList.NodeMod(2));
        l2.addAtBegining(new LinkedList.NodeMod(1));
        l2.addAtBegining(new LinkedList.NodeMod(0));
        l2.addAtBegining(new LinkedList.NodeMod(-1));
        l2.Display();
        System.out.println("------------------------------------------");
        twoPointersMiddle(l2.head);
        deleteMiddle(l2);
        System.out.println("After Deleting middle elements");
        l2.Display();
        System.out.println("------------------------------------------");
        twoPointersMiddle(l2.head);
        deleteMiddle(l2);
        System.out.println("After Deleting middle elements");
        l2.Display();
        System.out.println("------------------------------------------");
        twoPointersMiddle(l2.head);
        deleteMiddle(l2);
        System.out.println("After Deleting middle elements");
        l2.Display();
        System.out.println("------------------------------------------");


    }
}
