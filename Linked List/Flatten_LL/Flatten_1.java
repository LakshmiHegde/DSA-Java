/*
Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘next’ pointer in the code below)
(ii) Pointer to a linked list where this node is headed (we call it the ‘bottom’ pointer in the code below).

Use concept of merging 2 LL at a time, from the last LL, keep on merging 2 at a time.
L1 L2 L3 L4
first merge L3 L4 ,res, what you get, merge it with L2 and so on
Merge w/o extra space can be of help to merge in O(1) space, and O(m+n) time, where m, n are no. of nodes in LL

Total time , we scan every node of LL,
M- children, N-Num of such LL
O(MN)
Space = O(1)

 */
package RBR_DSA.LinkedListPrograms.Flatten_LL;
class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
public class Flatten_1 {
    static Node flatten(Node root)
    {
        // Your code here
        if(root == null || root.next == null)
            return root;
        root.next=flatten(root.next);
        root=merge(root,root.next);
        return root;
    }
    static Node merge(Node root,Node newlist)
    {
        if(root == null)
            return newlist;
        if(newlist == null)
            return root;
        //System.out.println("merging "+root.data+"  "+newlist.data);
        Node res;
        if(root.data > newlist.data)
        {
            Node temp;
            temp=root;
            root=newlist;
            newlist=temp;
        }
        res=root;
        Node final_r=res;
        root=root.bottom;
        while(root!=null)
        {
            if(root.data <= newlist.data)
            {
                //System.out.println(root.data);
                res=root;
                root=root.bottom;
            }
            else
            {
                Node temp;
                temp=root;
                root=newlist;
                newlist=temp;
                res.bottom=root;
                res=root;
                root=root.bottom;
            }

        }
        if(newlist!=null)
            res.bottom=newlist;
        res.next=null;
        /*System.out.println("After merge");
        display(final_r);*/
        return final_r;
    }
    public static void display(Node head)
    {
        while (head!=null)
        {
            System.out.print(head.data+"   ");
            head=head.bottom;
        }
    }
    public static void main(String[] args)
    {
        Node head=new Node(5);
        head.bottom=new Node(7);
        head.bottom.bottom=new Node(8);
        head.bottom.bottom.bottom=new Node(30);

        head.next=new Node(10);

        head.next.next=new Node(19);
        head.next.next.bottom=new Node(22);
        head.next.next.bottom.bottom=new Node(50);

        head.next.next.next=new Node(28);

        Node h=flatten(head);
        display(h);

    }
}
