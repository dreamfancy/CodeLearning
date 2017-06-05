package tree;

public class ValidateBST_98 {
	
    private int lastVal = Integer.MIN_VALUE;
    //Use global variable to avoid initial judgement for Integer.MINVALUE and Integer.MAXVALUE
    private boolean firstNode = true;
    
	
	//Every Node !!! 
    public boolean isValidBST(TreeNode root) 
    {
    	 return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    
    //Solution 2: From top to bottom
    private boolean isBST(TreeNode root, int lowerb, int upperb)
    {
    	if(root==null) return true;
    	//if(root.left==null && root.right==null && root.val>=lowerb && root.val<=upperb)
    	//	return true;
    	if(!firstNode &&(root.val>=upperb || root.val<=lowerb)) return false;
    	firstNode = true;
    	return isBST(root.left,lowerb,root.val) && isBST(root.right,root.val,upperb);
    	 
    } 

    //Solution 3: From bottom to top to decide the range TODO: Revisit and do it
    
    //Solution 4: Inorder
    

    public boolean isValidBST_InorderTraverse(TreeNode root) 
    {
    	if(root==null) return true;
    	if(!isValidBST(root.left)) return false;
    	if(!firstNode && lastVal>=root.val) return false;
    	firstNode = false;
    	lastVal = root.val;
    	if(!isValidBST(root.right))
    	{
    		return false;
    	}
    	
    	return true;
    } 
    private int inorderTraverse(TreeNode root)
    {
    	int left = inorderTraverse(root.left,root.val);
    	if(left>=root.val)
    }
 

}
