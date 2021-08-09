package RBR_DSA.Trees.Left_View;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Left_viewIteration {
    public static void left_view(Node root)
    {
        Queue<Node> q=new ArrayDeque();
        if(root == null)
            return;
        q.add(root);
        while (!q.isEmpty())
        {
            int size=q.size();
            for(int i=1;i<=size;i++)
            {
                Node temp=q.poll();
                if(i==1)
                    System.out.println(temp.data);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
    }
    public static void right_view(Node root)
    {
        Queue<Node> q=new ArrayDeque();
        if(root == null)
            return;
        q.add(root);
        while (!q.isEmpty())
        {
            int size=q.size();
            for(int i=1;i<=size;i++)
            {
                Node temp=q.poll();
                if(i==size)
                    System.out.println(temp.data);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
    }
    public static void main(String[] args)
    {
        Node root=new Node(4);
        root.left=new Node(5);
        root.right=new Node(2);
        root.right.left=new Node(3);
        root.right.right=new Node(1);
        root.right.left.left=new Node(6);
        root.right.left.right=new Node(7);
        Left_viewIteration l=new Left_viewIteration();
        System.out.println("Left view of binary tree");
        l.left_view(root);
        System.out.println("Right view of binary tree");
        l.right_view(root);

    }
}
