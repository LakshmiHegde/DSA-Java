package RBR_DSA.Trees.Traversal.Traversals.Traversals_Iteration;
import java.util.*;
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

public class Traversals_Iteration {
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
        Stack<Node> s=new Stack<>();
        s.push(root);
        System.out.println("Preorder ");
        while(!s.isEmpty())
        {
            Node t=s.pop();
            System.out.print(t.data+"   ");
            if(t.right!=null)
                s.push(t.right);
            if(t.left!=null)
                s.push(t.left);
        }
        System.out.println();
    }
    public static void postorder(Node root)
    {
        if (root == null) {
            return;
        }
        Stack<Node> s=new Stack<>();
        Stack<Integer> s1=new Stack<>();
        s.push(root);
        while(!s.isEmpty())
        {
            Node t=s.pop();
            s1.push(t.data);
            if(t.left!=null)
                s.push(t.left);
            if(t.right!=null)
                s.push(t.right);
        }
        System.out.println("Postorder ");
        while(!s1.isEmpty())
            System.out.print(s1.pop()+"   ");
        System.out.println();
    }
    public static void inorder(Node root)
    {
        if(root == null)
            return;
        Stack<Node> s=new Stack<>();
        Node curr=root;
        System.out.println("Inorder ");
        while(!s.isEmpty() || curr!=null)
        {
            if(curr!=null)
            {
                s.push(curr);
                curr=curr.left;
            }
            else if(!s.isEmpty())
            {
                curr=s.pop();
                System.out.print(curr.data + "   ");
                curr=curr.right;
            }
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Node root=new Node(10);
        root.left=new Node(3);
        root.right=new Node(2);
        root.right.right=new Node(3);
        root.right.right.left=new Node(0);
        root.right.right.left.left=new Node(6);
        root.right.right.left.right=new Node(-1);
        root.left.left=new Node(5);
        root.left.left.left=new Node(4);
        root.left.left.right=new Node(1);
        inorder(root);
        postorder(root);
        preorder(root);

    }
}
