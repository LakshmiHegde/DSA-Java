/*
Time = O(n)
Space = O(1)
 */
package RBR_DSA.LinkedListPrograms;


public class ReversingLL {
    LinkedList.NodeMod reverseLL(LinkedList.NodeMod head)
    {
        if(head==null || head.next==null) // List is empty, or only one element in list
            return head;
        LinkedList.NodeMod temp=head;
        LinkedList.NodeMod previous,current,next;
        previous=null;
        current=head;
        while(current!=null)
        {
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }


    LinkedList.NodeMod reverseLLRecursive(LinkedList.NodeMod previous, LinkedList.NodeMod current)
    {
        if(current==null)
          return previous;
        LinkedList.NodeMod temp=current.next;
        current.next=previous;
        return reverseLLRecursive(current,temp);
    }
    public static void main(String[] args)
    {
        LinkedList l=new LinkedList();
        l.head=new LinkedList.NodeMod(2);
        l.addAtBegining(new LinkedList.NodeMod(3));
        l.addAtBegining(new LinkedList.NodeMod(7));
        l.addAtBegining(new LinkedList.NodeMod(5));
        l.addAtBegining(new LinkedList.NodeMod(4));
        l.Display();

        ReversingLL reverse=new ReversingLL();
        l.head=reverse.reverseLL(l.head);
        l.Display();


        LinkedList l1=new LinkedList();
        l1.addAtBegining(new LinkedList.NodeMod(5));
        //l1.addAtBegining(new LinkedList.NodeMod(25));
        //l1.addAtBegining(new LinkedList.NodeMod(10));
        l1.addAtBegining(new LinkedList.NodeMod(3));
        l1.Display();


        l1.head=reverse.reverseLLRecursive(null,l1.head);
        System.out.println(l1.head);
        l1.Display();
    }
}
