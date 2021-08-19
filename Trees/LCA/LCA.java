/*
Lowest common ancestor
Time = O(n)
Space = O(n), stack space, worst case,if skewed
 */
package RBR_DSA.Trees.LCA;

class Node {
    int data;
    Node left, right,next;

    public Node(int data){
        this.data = data;
    }
}
public class LCA {
    static Node lca(Node root, int n1,int n2)
    {
        // Your code here
        if(root == null)
            return null;
        if(root.data == n1 || root.data == n2)
            return root;
        Node lh=lca(root.left,n1,n2);
        Node rh=lca(root.right,n1,n2);
        if(lh!=null && rh!=null)
        {
            return root;
        }
        if(lh!=null)
            return lh;
        else return rh;
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
        System.out.println(lca(root,5,0).data);
    }
}
