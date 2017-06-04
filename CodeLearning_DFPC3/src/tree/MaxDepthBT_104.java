package tree;

public class MaxDepthBT_104 {
    public int maxDepth(TreeNode root) {
	    if(root==null) return 0;
	    if(root.left==null && root.right==null) return 1;
	    int cur = Math.max(maxDepth(root.left),maxDepth(root.right))+1;
	     return cur;
    }
    
}
