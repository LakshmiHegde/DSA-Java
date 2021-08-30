/*
No extra/new DLL constructed, for existing tree, we modify right left to make it as per the question.
Time =O(n)
Space = O(n) recursion stack
 */
package RBR_DSA.Trees.BinaryToDLL;

public class BinarytoDLL2 {
    Node head=null;
    Node prev=head;
    void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            if(head == null)
            {
                head=root;
                prev=head;
                head.left=null;
            }else
            {
                prev.right=root;
                root.left=prev;
                prev=prev.right;
            }
            inorder(root.right);
        }
    }
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        inorder(root);
        prev.right=null;
        return head;
    }
}
