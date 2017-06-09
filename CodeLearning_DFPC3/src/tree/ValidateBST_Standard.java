package tree;

public class ValidateBST_Standard {
    
	//Solution 1: From top to bottom, Boundary as the argument of the function to go down
	//Use long because we need to consider Integer's boundary working as well.
	public boolean isValidBST(TreeNode root)
    {
		return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
	private boolean isValidBST(TreeNode root, long leftb, long rightb)
	{
		if(root==null) return true;
		if(root.val>=rightb || root.val<=leftb) return false;
		return isValidBST(root.left,leftb,Math.min(root.val,rightb)) && isValidBST(root.right,Math.max(root.val,leftb),rightb);
	}
	
	
	//Solution 2: From bottom to top, return type with boundary of the function to go up
	
	class ReturnType
	{
		boolean isBST;
		long leftb;
		long rightb;
		
		public ReturnType(boolean isBST_I, long leftb_I, long rightb_I)
		{
			isBST = isBST_I;
			leftb = leftb_I;
			rightb = rightb_I;
			
		}
	}
	
	public boolean isValidBST_2(TreeNode root)
	{
		if(root==null) return true;
	
		return helpIsValidBST(root).isBST;
	}
	
	public ReturnType helpIsValidBST(TreeNode root)
	{
		if(root==null) return new ReturnType(true,Long.MIN_VALUE,Long.MAX_VALUE);
		
		ReturnType rt1 = helpIsValidBST(root.left);
		if(!rt1.isBST) return new ReturnType(false,0,0);
		ReturnType rt2 = helpIsValidBST(root.right);
		if(!rt2.isBST) return new ReturnType(false,0,0);

		if(root.left!=null && rt1.rightb>=root.val || root.right!=null && rt2.leftb<=root.val) 
		return new ReturnType(false,0,0);
				
		return new ReturnType(true,Math.max(root.val,rt2.rightb),Math.min(root.val,rt1.leftb));
	}//???Not Understand here. it is a question needing to revisit
	
}
