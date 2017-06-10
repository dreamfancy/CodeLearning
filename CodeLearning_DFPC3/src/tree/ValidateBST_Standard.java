package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	
	
	//Solution 3 In Order Traverse using recursion
	private long lastVal = Long.MIN_VALUE;
	
	public boolean isValidBST_3(TreeNode root)
	{
		if(root == null) return true;
		boolean left = isValidBST_3(root.left);
		if(!left) return false;
		if(root.val<=lastVal) return false;
		lastVal = root.val;
		return isValidBST_3(root.right);
	}
	
	//Solution 4: In order traverse using iteration
	public boolean isValidBST_4(TreeNode root)
	{
		Stack<TreeNode> st = new Stack<TreeNode>();
		//st.push(root); Attention !!! No need to push at the beginning or there will be duplicates
		while(root!=null || !st.empty())
		{
			if(root==null)
			{
				root = st.pop();
				if(root.val<=lastVal) return false;
				lastVal = root.val;
				root = root.right;
			}
			else
			{
				st.push(root);
				root = root.left;
			}
		}
		
		return true;
	}
	
	//Solution 5: Treat each node with its stored boundaries as a part of a new node, 
	//instead of just using it as argument
	
	class BNode{
	    TreeNode n;
	    double left;
	    double right;
	    public BNode(TreeNode n, double left, double right){
	        this.n = n;
	        this.left = left;
	        this.right = right;
	    }
	}
	public boolean isValidBST_5(TreeNode root) {
        if(root == null)
            return true;
        Queue<BNode> q = new LinkedList<BNode>();
        q.offer(new BNode(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        
        while(!q.isEmpty())
        {
        	BNode cur = q.poll();
        	if(cur.n.val<=cur.left || cur.n.val>=cur.right)
        	{
        		return false;
        	}
        	if(cur.n.left!=null)
        	{
        		q.offer(new BNode(cur.n.left,cur.left,cur.n.val));
        	}
        	if(cur.n.right!=null)
        	{
        		q.offer(new BNode(cur.n.right,cur.n.val,cur.right));
        	}
        }
        
        return true;
	}
}
        

