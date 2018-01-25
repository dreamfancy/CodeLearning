package leetcode251to300;

public class InorderSuccessorInBST_285 
{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) 
    {
        return helper(root,p);
    }
    
    private TreeNode helper(TreeNode root, TreeNode p)
    {
        if(root==null) return null;
        if(root.val<=p.val) return helper(root.right,p);
        TreeNode left = helper(root.left,p);
        return left==null ? root: left;
    }

}
