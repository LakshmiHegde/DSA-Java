/*
Find  mirror image of tree
Time - O(n)
Space - O(n)//recursion stack
*/

package RBR_DSA.Trees.Mirror;


class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class Mirror_tree {
    public static void mirror(Node root)
    {
        if(root == null || (root.left == null && root.right == null))
            return;
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirror(root.left);
        mirror(root.right);
    }
    public static void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(root.data+"    ");
            inorder(root.right);
        }
    }
    public static void main(String[] args)
    {
        Node root =new Node(5);
        root.left=new Node(3);
        root.right=new Node(6);
        root.left.right=new Node(4);
        root.left.left=new Node(2);
        mirror(root);
        inorder(root);
    }
}
