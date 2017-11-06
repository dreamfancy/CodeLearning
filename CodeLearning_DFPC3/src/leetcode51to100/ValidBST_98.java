package leetcode51to100;

import java.util.Stack;

import tree.TreeNode;

public class ValidBST_98 
{
	//sol 3: Traverse tree using iteration
	
	 public boolean isValidBST_3_Iteration(TreeNode root)
    {
        if(root==null) return true;
        Stack<TreeNode> st= new Stack<TreeNode>();
        TreeNode pre = null;
        
        while(!st.isEmpty() || root!=null)
        {
        	while(root!=null)
        	{
        		st.push(root);
        		root = root.left;
        	}
        	if(!st.isEmpty())
        	{
        		TreeNode cur = st.pop();
        		if(pre!=null && cur.val<=pre.val) return false;
        		pre = cur;
        		root = cur.right;
        	}
        }
        return true;
    }
	//Sol 2: Traverse tree using recursion
    long pre = Long.MIN_VALUE;
    public boolean isValidBST_2(TreeNode root) 
    {
        if(root==null) return true;
        return inorderTraverse(root);
    }
    
    public boolean inorderTraverse(TreeNode root)
    {
        if(root==null) return true;
        boolean left = inorderTraverse(root.left);
        if(left==false) return false;
        int val = root.val;
        if(val<=pre) return false;
        pre = root.val;
        return inorderTraverse(root.right);
    }
	
	//Sol 1: My Solution : Top to Bottom divide and conquer
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        int val = root.val;
        
        return isValidBST(root.left,Long.MIN_VALUE,val) && isValidBST(root.right,val,Long.MAX_VALUE);        
    }
    
    public boolean isValidBST(TreeNode root, long leftMin, long rightMax)
    {
        if(root==null) return true;
        int cur = root.val;
        if(cur<=leftMin || cur>=rightMax) return false;
        return isValidBST(root.left,leftMin,cur) && isValidBST(root.right,cur,rightMax);
    }

}
