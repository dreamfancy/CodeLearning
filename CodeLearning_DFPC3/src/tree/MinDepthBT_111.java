package tree;

public class MinDepthBT_111 {
    public int minDepth(TreeNode root) {
	    if(root==null) return 0;
	    //if(root.left==null && root.right==null) return 1;
	    if(root.left==null) return minDepth(root.right)+1;
	    if(root.right==null) return minDepth(root.left)+1; 
	    int cur = Math.min(minDepth(root.left),minDepth(root.right))+1;
	    return cur;
	    
	    //!!!See how to make it easy
	    //return (leftHeight==0 || rightHeight==0) ? leftHeight+rightHeight+1 : Math.min(minDepth(root.left),minDepth(root.right))+1;
	    //return (root.left==null)?(minDepth(root,right)+1):((root.right==null)?(minDepth(root,right)+1):(Math.min(minDepth(root.left),minDepth(root.right))+1))
    }
}
