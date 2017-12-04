package leetcode201to250;

import tree.TreeNode;

public class KthSmallestElementInBST_230 
{
    public int kthSmallest(TreeNode root, int k) 
    {
        if(root==null) return -1;
        int[] data = new int[2];
        data[0] = k;
        traverseBST(root,data);
        return data[1];
    }
    
    private boolean traverseBST(TreeNode root, int[] data)
    {
        if(root==null) return false;
        boolean left = traverseBST(root.left,data);
        if(left) return true;
        data[0] = data[0] - 1;
        if(data[0]==0)
        {
            data[1] = root.val;
            return true;

        }
        return traverseBST(root.right,data);
}
}