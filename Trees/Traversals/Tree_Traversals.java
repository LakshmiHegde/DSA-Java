/*
Time = O(n), traversal
Space = O(n), rec stack, in worst case for skewed trees
 */
package RBR_DSA.Trees.Traversal.Traversals;

class BinaryTree
{
    Node root;
    BinaryTree(int data)
    {
        root=new Node(data);
    }
    static class Node
    {
        Node left,right;
        int data;
        Node(int d)
        {
            this.data=d;
            this.left=null;
            this.right=null;
        }
    }
    public void preorder(Node root)
    {
        if(root != null)
        {
            System.out.print(root.data+"  ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void postorder(Node root)
    {
        if(root!=null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+"  ");
        }
    }
    public void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(root.data+"  ");
            inorder(root.right);
        }
    }
}
public class Tree_Traversals {
    public static void main(String[] args)
    {
        BinaryTree t=new BinaryTree(10);
        t.root.left=new BinaryTree.Node(20);
        t.root.right=new BinaryTree.Node(30);
        t.root.left.right=new BinaryTree.Node(15);
        t.root.right.right=new BinaryTree.Node(25);
        System.out.println("Preorder traversal");
        t.preorder(t.root);
        System.out.println();
        System.out.println("Postorder traversal");
        t.postorder(t.root);
        System.out.println();
        System.out.println("Inorder traversal");
        t.inorder(t.root);
        System.out.println();

    }
}
