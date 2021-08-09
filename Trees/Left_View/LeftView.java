package RBR_DSA.Trees.Left_View;

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
public class LeftView {
    int max_level_reached;
    public void left_view(Node root,int current_level)
    {
        if(root == null)
            return;
        if(current_level > max_level_reached)
            System.out.println(root.data);
        max_level_reached= Math.max(max_level_reached,current_level);
        left_view(root.left,current_level+1);
        left_view(root.right,current_level+1);
    }
    public void right_view(Node root,int current_level)
    {
        if(root == null)
            return;
        if(current_level > max_level_reached)
            System.out.println(root.data);
        max_level_reached= Math.max(max_level_reached,current_level);
        right_view(root.right,current_level+1);
        right_view(root.left,current_level+1);
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
        LeftView l=new LeftView();
        System.out.println("Left view of binary tree");
        l.max_level_reached=-1;
        l.left_view(root,0);
        System.out.println("Right view of binary tree");
        l.max_level_reached=-1;
        l.right_view(root,0);

    }
}
