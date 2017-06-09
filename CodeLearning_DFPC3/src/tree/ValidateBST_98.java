package tree;

import java.util.LinkedList;
import java.util.Stack;

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
    
    //Solution 4: InorderTraverse
    

    public boolean isValidBST_InorderTraverse(TreeNode root) 
    {
    	if(root==null) return true;
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	boolean firsttime = true;
    	while(root!=null ||!st.isEmpty())
    	{
    		if(root==null)
    		{
    			root = st.pop();
    			if(!firsttime && root.val<=lastVal) return false;
    			firsttime =false;
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

    //Solution 5: Make a BNode to keep record of left and right boundary of a node.
    
    public class BNode
    {
    	TreeNode n;
    	double left;
    	double right;
    	
    	public BNode(TreeNode n, double left, double right)
    	{
    		this.n = n;
    		this.left = left;
    		this.right = right;
    	}
    }
    
    public boolean isValidBST_ReconstructTreeNode(TreeNode root) 
    {
        if(root == null)
        {
            return true;
        }
        
        LinkedList<BNode> q = new LinkedList<BNode>();
        q.offer(new BNode(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        
        while(!q.isEmpty())
        {
        	BNode b = q.poll();
        	if(b.n.val <= b.left || b.n.val >=b.right)
        	{
        		return false;
        	}
        	if(b.n.left!=null)
        	{
        		q.offer(new BNode(b.n.left,b.left,b.n.val));
        	}
        	
        	if(b.n.right!=null)
        	{
        		q.offer(new BNode(b.n.right,b.n.val,b.right));
        	}
        }
        
        return true;
    }
    
    //Solution 6: TreeNode 
    
    public boolean isValidBST_RecursiveInOrderTraverse(TreeNode root) 
    {
    	if(root==null) return true;
    	if(!isValidBST_RecursiveInOrderTraverse(root.left)) return false;
    	if(!firstNode && root.val<=lastVal) return false;
    	lastVal = root.val;
    	firstNode = false;
    	if(!isValidBST_RecursiveInOrderTraverse(root.right)) return false;
    	
    	return true;
    }
    
    //Solution 7: Divide and Conquer for the result type
    
    class ResultType {
        boolean is_bst;
        int maxValue, minValue;
        
        ResultType(boolean is_bst, int maxValue, int minValue) {
            this.is_bst = is_bst;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
    
    
    public boolean isValidBST_divideandconquer(TreeNode root) {
        ResultType r = validateHelper(root);
        return r.is_bst;
    }
    
    private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);
        
        if (!left.is_bst || !right.is_bst) {
            // if is_bst is false then minValue and maxValue are useless
            return new ResultType(false, 0, 0);
        }
        
        if (root.left != null && left.maxValue >= root.val || 
              root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }
        
        return new ResultType(true,
                              Math.max(root.val, right.maxValue),
                              Math.min(root.val, left.minValue));
    }
    
    //Solution 8: Divide and Conquer from bottom to top
    public boolean isValidBST_DivideAndConquer(TreeNode root) {
        // write your code here
        return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean divConq(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        return divConq(root.left, min, Math.min(max, root.val)) && 
                divConq(root.right, Math.max(min, root.val), max);
    }
    
}









