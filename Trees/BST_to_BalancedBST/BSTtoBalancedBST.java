package RBR_DSA.Trees.BST_to_BalancedBST;
class Node
{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}
public class BSTtoBalancedBST {
    static int in[]=new int[200];
    static int index=0;
    static Node construct(Node root,int[] in,int start, int end)
    {
        if(start > end)
            return null;
        if(start ==  end)
            return new Node(in[start]);
        int mid=(start+end)/2;
        root=new Node(in[mid]);
        //System.out.println("New node created "+root.data);
        root.left=construct(root.left,in,start,mid-1);
        root.right=construct(root.right,in,mid+1,end);
       // System.out.println("its left "+root.left.data+" right "+root.right.data);
        return root;
    }
    static  void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            in[index]=root.data;
            index++;
            inorder(root.right);
        }
    }
    static  Node buildBalancedTree(Node root)
    {
        //Add your code here.
        index=0;
        inorder(root);
        for(int i=0;i<index;i++)
            System.out.println(in[i]);
        return construct(root,in,0,index-1);

    }
    public static void main(String[] args)
    {
        Node r1=new Node(3);
        r1.left=new Node(2);
        r1.left.left=new Node(1);
        r1=buildBalancedTree(r1);
        index=0;
        inorder(r1);
        
    }
}
