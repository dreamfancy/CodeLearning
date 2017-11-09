package leetcode101to130;

public class PathSum_112 
{
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        //if(sum<0) return false;
        if(sum==root.val && root.left==null && root.right==null) return true;
        boolean left = false;
        boolean right = false;
        if(root.left!=null)
            left = hasPathSum(root.left,sum-root.val);
        if(root.right!=null)
            right = hasPathSum(root.right,sum-root.val);
        
        return left || right;
    }

}
