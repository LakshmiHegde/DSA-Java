/*
Factorization tree, lists out factors of a number
Time = O(logn)
Space = O(logn), stack depth is logn

 */
package RBR_DSA.Trees;
class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        this.data=d;
        left=right=null;
    }
}
public class Factorization {
    public static Node factorTree(Node root,int n)
    {
        root=new Node(n);
            for(int i=2;i<=n/2;i++)
            {
                if(n%i == 0)
                {
                    root.left=factorTree(root.left,i);
                    root.right=factorTree(root.right,n/i);
                    return root;
                }
            }

        return root;
    }
    public static void preorder(Node root)
    {
        if(root!=null)
        {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String[] args)
    {
        int n=23;
        int n1=48;
        int n4=642;
        Node temp=factorTree(null,48);
        preorder(temp);
    }
}
