/*
Level order traversal of tree/BFS
Time = O(n), visit every node
Space= O(n) queue space
 */
package RBR_DSA.Trees.LevelOrderTraversal;
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
public class LevelOrderTraversal {
    ArrayList<Integer> l=new ArrayList<>();
    ArrayList <Integer> levelOrder(Node node)
    {
        Queue<Node> q=new ArrayDeque();
        if(node == null)
            return l;
        q.add(node);
        while(q.isEmpty()==false)
        {
            Node u=q.poll();
            l.add(u.data);
            if(u.left == null && u.right == null)
                continue;
            if(u.left == null)
            {
                q.add(u.right);
            }
            else if(u.right == null)
            {
                q.add(u.left);
            }
            else
            {
                q.add(u.left);
                q.add(u.right);
            }
        }
        return l;
    }
    public static void main(String[] args)
    {
        LevelOrderTraversal t=new LevelOrderTraversal();
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right.left=new Node(60);
        root.right.right=new Node(70);
        root.left.left.left=new Node(80);
        root.left.left.right=new Node(100);

        root.right.right.left=new Node(205);
        root.right.right.right=new Node(230);
        t.l=t.levelOrder(root);
        for(Integer x:t.l)
            System.out.println(x);
    }
}
