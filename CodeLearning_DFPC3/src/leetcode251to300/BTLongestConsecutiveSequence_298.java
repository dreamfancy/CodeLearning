package leetcode251to300;

public class BTLongestConsecutiveSequence_298 
{
    public int longestConsecutive(TreeNode root) 
    {
        if(root==null) return 0;
        int[] res = new int[1];
        res[0] = 1;
        helper(root.left, root.val,1,res);
        helper(root.right, root.val,1,res);

        return res[0];    
    }
    
    private void helper(TreeNode cur, int prenum, int prelen, int[] res)
    {
        if(cur==null || cur.val!=(prenum+1))
        {
            res[0] = Math.max(res[0], prelen);
            prelen = 0;
        }
        if(cur!=null)
        {
            helper(cur.left,cur.val,prelen+1,res);
            helper(cur.right,cur.val,prelen+1,res);
        }
    }	

}
