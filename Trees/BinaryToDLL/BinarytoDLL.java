/*
Given binary tree convert it to DLL
left pointer is previous
right pointer is next
O/p should be in form of inorder nodes, in DLL
Time = Inorder= O(n)
Space = O(n) inorder
 */
package RBR_DSA.Trees.BinaryToDLL;

class Node
{
    Node left, right;
    int data;

    Node(int d)
    {
        data = d;
        left = right = null;
    }

}
public class BinarytoDLL {
    static Node head=null,previous=null;
    static Node  bToDLL(Node root)
    {
        //  Your code here
        if(root!=null)
        {
            bToDLL(root.left);
            if(head== null)
            {
                Node newnode=new Node(root.data);
                head=newnode;
                previous=head;

            }
            else
            {

                Node newnode=new Node(root.data);

                head.right=newnode;
                newnode.left=head;
                newnode.right=null;
                head=newnode;

            }
            bToDLL(root.right);
        }
        return previous;
    }
    public static void main(String[] args)
    {
        Node r=new Node(10);
        r.left=new Node(20);
        r.right=new Node(30);
        r.left.left=new Node(40);
        r.left.right=new Node(50);
        r=bToDLL(r);
        Node temp=r;
        while(temp!=null)
        {
            System.out.print(temp.data+"   ");
            temp=temp.right;
        }
    }
}
