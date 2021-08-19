/*
Populate inorder of every node
Time  = O(n), in worst case, binary tree is skewed, therefore O(n)
Space = O(n)
 */
package RBR_DSA.Trees;
import java.util.*;
public class PopulateInorder {
    ArrayList<Node> l=new ArrayList<>();
    public  void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
           // System.out.println(root.data);
            l.add(root);
            inorder(root.right);
        }
    }
    public  void populateNext(Node root){
        //code here
        inorder(root);
        int i=0;

        for(i=0;i<l.size()-1;i++)
        {
            //System.out.println(l.get(i).data);
            l.get(i).next=l.get(i+1);
        }
        l.get(i).next=null;

    }
    public  void printInorderSucc(Node root)
    {
        while(root.next !=null)
        {
            //System.out.println(root.data +" -> "+ root.next.data);
            root=root.next;
        }
        System.out.println(root.data +" -> -1");
    }
    public static void main(String[] args)
    {
        Node r=new Node(10);
        r.left=new Node(8);
        r.right=new Node(12);
        r.left.left=new Node(3);
        PopulateInorder p=new PopulateInorder();
        p.populateNext(r);
       // System.out.println("Populate inorder"+temp.data);
        p.printInorderSucc(p.l.get(0));
        PopulateInorder p1=new PopulateInorder();
        Node r1=new Node(6);
        r1.left=new Node(5);
        r1.right=new Node(8);
        r1.left.left=new Node(2);
        p1.populateNext(r1);
        p1.printInorderSucc(p1.l.get(0));
    }
}
