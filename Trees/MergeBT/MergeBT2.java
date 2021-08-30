/*
Merge two binary trees, this uses no extra space,if you are  allowed to modify one of the trees, you can go for this approach
Time = O(n+m), m,n are length of binary trees
Space = O(min(m,n)) , stack space
 */
package RBR_DSA.Trees.MergeBT;

public class MergeBT2 {
    static public void inorder(TreeNode root1)
    {
        if(root1!=null)
        {
            inorder(root1.left);
            System.out.print(root1.val+"   ");
            inorder(root1.right);
        }
    }
    static public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        if(root1 != null && root2 !=null)
        {
            //System.out.println("Entered "+root1.val+"  "+root2.val);
            root1.val=root1.val+root2.val;
            //System.out.println("Entered "+root1.val);
            root1.left=mergeTrees(root1.left,root2.left);
            root1.right=mergeTrees(root1.right,root2.right);
            return root1;
        }
        if(root1 !=null)
        {
            //System.out.println("entered");
            return root1;
        }
        else
        {
            return root2;
        }

    }
    public static void main(String[] args)
    {
        TreeNode r1=new TreeNode(1);
        r1.left=new TreeNode(3);
        r1.right=new TreeNode(2);
        r1.left.left=new TreeNode(5);


        TreeNode r2=new TreeNode(2);
        r2.left=new TreeNode(1);
        r2.right=new TreeNode(3);
        r1.left.right=new TreeNode(4);
        r1.right.right=new TreeNode(7);

        mergeTrees(r1,r2);
        inorder(r1);

    }
}

