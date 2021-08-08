package RBR_DSA.Trees.Bottom_View;

import RBR_DSA.Trees.Top_View.TopView;

import java.util.Map;
import java.util.TreeMap;

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
public class BottomView {
    Map<Integer, Pair> m =new TreeMap<Integer, Pair>();
    public void bottomView(Node root, int distance, int level)
    {
        if(root == null)
            return;
        if(!m.containsKey(distance) || m.get(distance).level < level)
        {
            m.put(distance, new Pair(root.data,level));
        }
        bottomView(root.left,distance-1,level+1);
        bottomView(root.right,distance+1,level+1);
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
        BottomView b=new BottomView();
        b.bottomView(root,0,0);
        for(Map.Entry<Integer, Pair> e: b.m.entrySet())
        {
            System.out.println(e.getValue().data);
        }
    }
}
