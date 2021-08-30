/*
Merge two binary trees, this uses extra space. Creating new tree as a resultant.
Time = O(n+m), m,n are length of binary trees
Space = O(m+n)+stack , tree
 */
package RBR_DSA.Trees.MergeBT;
class TreeNode
{
    int val;
    TreeNode left,right;
    TreeNode(){}
    TreeNode(int data)
    {
        val=data;
    }
    TreeNode(int data, TreeNode left, TreeNode right)
    {
        val=data;
        this.left=left;
        this.right=right;
    }
}

public class MergeBT {
    public TreeNode merge(TreeNode root1,TreeNode root2,TreeNode root3)
    {
        if(root1 == null && root2 == null)
            return null;
        if(root1 != null && root2 !=null)
        {
            root3=new TreeNode(root1.val+root2.val , null,null);
            root3.left=merge(root1.left,root2.left,root3.left);
            root3.right=merge(root1.right,root2.right,root3.right);
            return root3;
        }
        if(root1 !=null)
        {
            root3=new TreeNode(root1.val , null,null);
            root3.left=merge(root1.left,null,root3.left);
            root3.right=merge(root1.right,null,root3.right);
            return root3;
        }
        else if(root2!=null)
        {
            root3=new TreeNode(root2.val , null,null);
            root3.left=merge(null,root2.left,root3.left);
            root3.right=merge(null,root2.right,root3.right);
            return root3;
        }
        return root3;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2,null);
    }
}
