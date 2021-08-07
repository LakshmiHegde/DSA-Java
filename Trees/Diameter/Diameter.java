/*
Diameter/width - Max difference of edges, between two leaf nodes. The diameter need not pass through root
Time = O(N)
Space =O(1)
 */
package RBR_DSA.Trees.Diameter;

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
public class Diameter {
    static int diameter=0;
    public static int height(Node root)
    {
        if(root == null)
            return -1;
        int left_height=height(root.left);
        int right_height=height(root.right);
        diameter=Math.max(diameter,left_height+right_height+2);
        return 1+Math.max(height(root.left),height(root.right));
    }
    public static void diameter(Node root)
    {
        if(root != null)
            height(root);
    }
    public static void main(String[] args)
    {
        Node root=new Node(10);
        root.left=new Node(11);
        root.right=new Node(12);
        root.left.left=new Node(13);
        root.left.right=new Node(14);
        root.left.left.left=new Node(15);
        root.left.left.right=new Node(16);
        root.left.right.right=new Node(19);
        root.left.right.right.left=new Node(20);
        root.left.right.right.right=new Node(21);
        root.left.right.right.right.left=new Node(22);
        root.left.left.right.left=new Node(17);
        root.left.left.right.left.right=new Node(18);
        root.right=new Node(12);
        diameter(root);
        System.out.println("Diameter/Width of binary tree "+diameter);
    }
}
