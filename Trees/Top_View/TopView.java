/*
Top view of tree using recursion
Time = O(n)
Space = O(n) if skewed
 */
package RBR_DSA.Trees.Top_View;

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
class Pair{
    int data,level;
    Pair(int d,int l)
    {
        this.data=d;
        this.level=l;
    }
}
public class TopView {
    Map<Integer,Pair> m =new TreeMap<Integer,Pair>();
    public void topView(Node root,int distance,int level)
    {
        if(root == null)
            return;
        if(!m.containsKey(distance) || m.get(distance).level > level)
        {
            m.put(distance, new Pair(root.data,level));
        }
        topView(root.left,distance-1,level+1);
        topView(root.right,distance+1,level+1);
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
        TopView t=new TopView();
        t.topView(root,0,0);
        for(Map.Entry<Integer,Pair> e: t.m.entrySet())
        {
            System.out.println(e.getValue().data);
        }
    }
}
