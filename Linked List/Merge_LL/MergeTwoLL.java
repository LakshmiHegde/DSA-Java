/*
L1- m, L2 n sizes
MergeTwoLL
time - O(m+n)
Space = O(m+n)

Inspace-Merge
time - O(m+n)
Space = O(1)

 */
package RBR_DSA.LinkedListPrograms;

public class MergeTwoLL {
    public static LinkedList merge(LinkedList l1, LinkedList l2)
    {
        LinkedList.NodeMod trav1=l1.head;
        LinkedList.NodeMod trav2=l2.head;
        LinkedList l3=new LinkedList();
        LinkedList.NodeMod trav3=l3.head=null;//New LL
        LinkedList.NodeMod newNode;
        while(trav1!=null && trav2!=null)
        {
            if(trav1.data <= trav2.data)
            {
                newNode=new LinkedList.NodeMod(trav1.data);
                trav1=trav1.next;
            }
            else
            {
                newNode=new LinkedList.NodeMod(trav2.data);
                trav2=trav2.next;
            }
            //Add created node to the new list.
            if(l3.head==null)// if first element
            {
                l3.head=newNode;
                trav3=l3.head;
            }
            else
            {
                trav3.next=newNode;
                trav3=newNode;
            }
        }

        //Check if any of the lists have still elements to be processed
        if(trav1!=null)
        {
            while(trav1!=null)
            {
                newNode=new LinkedList.NodeMod(trav1.data);
                trav3.next=newNode;
                trav3=newNode;
                trav1=trav1.next;
            }
        }
        if(trav2!=null)
        {
            while(trav2!=null)
            {
                newNode=new LinkedList.NodeMod(trav2.data);
                trav3.next=newNode;
                trav3=newNode;
                trav2=trav2.next;
            }
        }
        return l3;

    }


    public static LinkedList.NodeMod mergeInPlace(LinkedList l1,LinkedList l2)
    {
        LinkedList.NodeMod trav1=l1.head;
        LinkedList.NodeMod trav2=l2.head;
        LinkedList.NodeMod previous=null;
        LinkedList.NodeMod answer;
        if(trav1==null)//If list 1 is empty
        {
            return trav2;
        }
        else if(trav2==null)//if list 2 is empty
        {
            return trav1;
        }


        if(trav2.data < trav1.data)
        {
            //using answer as temporary variable to swap
            answer=trav1;
            trav1=trav2;
            trav2=answer;
        }
        answer=trav1; //trav1 will be pointing to smallest element at head, that's the begining of sorted final list

        while(trav1!=null && trav2!=null)
        {
            while(trav1!=null && trav1.data<=trav2.data)
            {
                previous=trav1;
                trav1=trav1.next;
            }
                //change pointers
                previous.next=trav2;
                trav2=trav1;
                trav1=previous.next;
        }
        return answer;

    }

    public static void display(LinkedList.NodeMod start)
    {
        LinkedList.NodeMod temp=start;
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        LinkedList result=new LinkedList();
        LinkedList l1=new LinkedList();
        l1.head=new LinkedList.NodeMod(10);
        l1.addAtBegining(new LinkedList.NodeMod(5));
        l1.addAtBegining(new LinkedList.NodeMod(3));
        l1.addAtBegining(new LinkedList.NodeMod(0));

        LinkedList l2=new LinkedList();
        l2.head=new LinkedList.NodeMod(6);
        l2.addAtBegining(new LinkedList.NodeMod(4));
        l2.addAtBegining(new LinkedList.NodeMod(2));
        l2.addAtBegining(new LinkedList.NodeMod(1));
        l2.addAtBegining(new LinkedList.NodeMod(0));
        l2.addAtBegining(new LinkedList.NodeMod(-1));//O(1)

        result=merge(l1,l2);//O(m+n)
        result.Display(); // O(m+n)

        display(mergeInPlace(l1,l2));
        LinkedList l3=new LinkedList();
        l3.head=new LinkedList.NodeMod(3);
        l3.addAtBegining(new LinkedList.NodeMod(2));
        l3.addAtBegining(new LinkedList.NodeMod(1));
        l3.addAtBegining(new LinkedList.NodeMod(0));
        LinkedList l4=new LinkedList();
        l4.addAtBegining(new LinkedList.NodeMod(8));
        l4.addAtBegining(new LinkedList.NodeMod(7));
        l4.addAtBegining(new LinkedList.NodeMod(6));
        l4.addAtBegining(new LinkedList.NodeMod(5));
        l4.addAtBegining(new LinkedList.NodeMod(4));//O(1)

        System.out.println();

        display(mergeInPlace(l3,l4));
    }
}
