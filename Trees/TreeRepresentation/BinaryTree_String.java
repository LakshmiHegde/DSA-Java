/*
Convert given tree to parenthesis / bracket representation
Right child, if not present,need not put any parenthesis,if left child not present, indicate it with empty parenthesis

Time - O(n)
Space - O(height)
 */
package RBR_DSA.Trees.TreeRepresentation;
class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class BinaryTree_String {
    public static String tree2str(TreeNode root) {

            if(root == null)
                return "";
            if(root.left ==null && root.right==null)
                return String.valueOf(root.val);
            String left_str=tree2str(root.left);
            String right_str=tree2str(root.right);
            if(right_str.length() == 0)
                return root.val+"("+left_str+")";
            else
                return root.val+"("+left_str+")"+"("+right_str+")";

    }
    public static void main(String[] args)
    {
        TreeNode r=new TreeNode(1,null,null);
        r.left=new TreeNode(2);
        r.right=new TreeNode(3);
        r.left.left=new TreeNode(4);
        System.out.println(tree2str(r));

        TreeNode r1=new TreeNode(1,null,null);
        r1.left=new TreeNode(2);
        r1.right=new TreeNode(3);
        r1.left.right=new TreeNode(4);
        System.out.println(tree2str(r1));
    }
}
