package tree; 

public class BalancedBT_110 {
	
	//Optimize to reduce the same functions methods
	
	public boolean isBalanced_Optimized(TreeNode root) 
	{
		if(getHeightIfBalanced(root)==-1) return false;
		
		return true;
		
	}
	
    private  int getHeightIfBalanced(TreeNode root) {
	    if(root==null) return 0;
	    int leftHeight = getHeightIfBalanced(root.left);
	    int rightHeight = getHeightIfBalanced(root.right);
	    //The following 'if' is important
	    if(Math.abs(leftHeight-rightHeight)>1 || leftHeight==-1 ||rightHeight==-1) return -1;
	    
	    return Math.max(leftHeight,rightHeight)+1;
	    
	    
    }
    
	
	

	
	
	//Recursion 
    public boolean isBalanced(TreeNode root)
    {
    	if(root==null) return true;
    	int left = maxDepth(root.left);
    	int right = maxDepth(root.right);
    	
    	if(Math.abs(right-left)>1) return false;
    	if(isBalanced(root.left)==false || isBalanced(root.right)==false) return false;
    	return true;
    	
    	//or return (Math.abs(right-left)<=1 && isB alanced(root.left) && isBalanced(root.right)
    	
    	//Attention the sequence. How to be out of loop ASAP
    }
    
    
    //Time Complexity : nlog(n) !!!Attention for the reason
    
    public int maxDepth(TreeNode root) {
	    if(root==null) return 0;
	    if(root.left==null && root.right==null) return 1;
	    int cur = Math.max(maxDepth(root.left),maxDepth(root.right))+1;
	     return cur;
    }
}
