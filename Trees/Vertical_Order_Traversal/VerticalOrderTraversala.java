/*
Vertical Order traversal
Time = O(n)
Space = O(n)
 */
package RBR_DSA.Trees.Vertical_Order_Traversal;

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

public class VerticalOrderTraversala {
    Map<Integer, ArrayList<Integer>> m =new TreeMap<Integer,ArrayList<Integer>>();
    public void verticalOrder(Node root, int distance)
    {
        if(root == null)
            return;
        if(!m.containsKey(distance))
        {
            m.put(distance,new ArrayList<>());
            m.get(distance).add(root.data);
        }
        else
        {
            m.get(distance).add(root.data);
        }
        verticalOrder(root.left,distance-1);
        verticalOrder(root.right,distance+1);
    }
    public static void main(String[] args)
    {
        Node root=new Node(2);
        root.left=new Node(1);
        root.right=new Node(10);
        root.right.left=new Node(3);
        root.right.left.right=new Node(6);
        root.right.left.right.left=new Node(4);
        root.right.left.right.right=new Node(9);
        root.right.left.right.left.right=new Node(5);
        VerticalOrderTraversala t=new VerticalOrderTraversala();
        t.verticalOrder(root,0);
        for(Map.Entry<Integer,ArrayList<Integer>> e: t.m.entrySet())
        {
            for(Integer x:e.getValue())
                System.out.print(x+"   ");
            System.out.println();
        }
    }
}
