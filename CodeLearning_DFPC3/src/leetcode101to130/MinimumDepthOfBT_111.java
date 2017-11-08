package leetcode101to130;

public class MinimumDepthOfBT_111 {
    public int minDepth(TreeNode root) 
    {
        if(root==null) return 0;
        return getDepth(root,0);
    }
    
    public int getDepth(TreeNode root, int curHeight)
    {
        if(root==null) return curHeight;
        if(root.left!=null && root.right!=null)
        {
            return Math.min(getDepth(root.left,curHeight+1),getDepth(root.right,curHeight+1));
        }
        else if(root.left!=null)
        {
            return getDepth(root.left,curHeight+1);
        }
        
        return getDepth(root.right,curHeight+1);
    }
}
