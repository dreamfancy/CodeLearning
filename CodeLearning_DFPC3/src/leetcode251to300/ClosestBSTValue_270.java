package leetcode251to300;

public class ClosestBSTValue_270 
{
    public int closestValue(TreeNode root, double target) 
    {
        if(root==null) return Integer.MAX_VALUE;
        int res = root.val;
        return helper(root,target,res);
    }
    
    private int helper(TreeNode cur, double target, int res)
    {
        if(Math.abs(target-cur.val)==0) return cur.val;
        if(Math.abs(target-cur.val)<Math.abs(target-res)) res = cur.val;
        if(cur.val>target && cur.left!=null) return helper(cur.left,target,res);
        if(cur.val<target && cur.right!=null) return helper(cur.right,target,res);
        return res;
    }

}
