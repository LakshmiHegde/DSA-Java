/*
Time complexity of functions -
addAtBegining  - O(1)
addAtEnd - O(n)
addAtPosition - O(n)
deleteAtBeg - O(1)
deleteAtEnd - O(n)
deleteAtPosFromStart - O(n)
deleteAtPosFromEnd - O(n)
Display - O(n)

Time complexity program - O(n)
Space Complexity - O(1)
 */
package RBR_DSA.LinkedListPrograms;
class LinkedList{
    NodeMod head;
    static class NodeMod
    {
        int data;
        NodeMod next;

        NodeMod(int data) {
            this.data = data;
            next = null;
        }
    }
    void addAtBegining(NodeMod newNode){
        newNode.next=head;//You're directly doing it with head, instead of taking current ref
        head=newNode;
    }
    void addAtEnd(NodeMod newNode){
        NodeMod temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
    }
    void addAtPosition(int pos, NodeMod newNode){
        NodeMod temp=head;
        if(pos==1) // one element
        {
            addAtBegining(newNode);
        }
        else
        {
            //Stand one node before the position
            for(int i=1;i<pos-1 && temp!=null;i++)
            {
                temp=temp.next;
            }

            newNode.next=temp.next;
            temp.next=newNode;
        }
    }
    void deleteAtBeg()
    {
        if(head!=null)
            head=head.next;
        else
            throw new RuntimeException("No elements in linked list, to delete");
    }
    void deleteAtEnd(){
        NodeMod temp=head;
        if(temp==null)//No elements
        {
            throw new RuntimeException("No elements in linked list, to delete");
        }
        else if(temp.next==null)
        {
            //only one element
            head=head.next;
        }
        else
        {
            while(temp.next.next!=null)
            {
                temp=temp.next;
            }
            temp.next=null;
        }
    }
    void deleteAtPosFromStart(int pos){
        if(head!=null)
        {
            NodeMod temp=head;
            for(int i=1;i<pos-1 && temp!=null;i++)
            {
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        else
            throw new RuntimeException("No elements in linked list, to delete");
    }
    void deleteAtPosFromEnd(int pos){
        if(head!=null)
        {
            //totalNoOfelements - pos = gives the position count after which the element to delete exist.
            int count=0;
            NodeMod temp=head;
            while(temp!=null)
            {
                temp=temp.next;
                count++;
            }
            temp=head;
            if(count-pos == 0)//first element
            {
                deleteAtBeg();
            }
            else
            {
                for(int i=1;i<count-pos;i++)
                {
                    temp=temp.next;
                }
                temp.next=temp.next.next;
            }
        }
        else
            throw new RuntimeException("No elements in linked list, to delete");
    }
    void deleteAtPosFromEndInOnePass(int pos)
    {
        NodeMod trav1, trav2;
        trav1=trav2=head;
        int beginingDeleteFlag=0;
        for(int i=1;i<=pos+1;i++)
        {
            if(trav2==null)
            {
                beginingDeleteFlag=1;
                break;
            }
            trav2=trav2.next;
        }
        if(beginingDeleteFlag==1)
            deleteAtBeg();
       else
       {
            while(trav2!=null)
            {
                trav2=trav2.next;
                trav1=trav1.next;
            }
            trav1.next=trav1.next.next;
        }
    }
    void Display()
    {
        NodeMod temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println();
    }

}
public class LinkedListClass {
    public static void main(String[] args)
    {
        LinkedList l=new LinkedList();
        l.head=new LinkedList.NodeMod(10);//create object first, we have only declared the reference there.
        l.addAtBegining(new LinkedList.NodeMod(13));
        l.addAtBegining(new LinkedList.NodeMod(23));
        l.Display();

        l.addAtEnd(new LinkedList.NodeMod(90));
        l.addAtEnd(new LinkedList.NodeMod(3));
        l.Display();

        l.addAtPosition(1,new LinkedList.NodeMod(9));
        l.addAtPosition(3,new LinkedList.NodeMod(19));
        l.Display();

        l.deleteAtBeg();
        l.deleteAtEnd();
        l.Display();

        l.deleteAtPosFromEndInOnePass(5);
        l.Display();

        l.deleteAtPosFromEndInOnePass(3);
        l.Display();


        l.deleteAtPosFromEnd(1);
        l.Display();

        l.deleteAtPosFromEnd(2);
        l.Display();

        l.deleteAtEnd();
        l.Display();

    }
}
