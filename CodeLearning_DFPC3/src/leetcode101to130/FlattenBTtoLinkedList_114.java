package leetcode101to130;

import java.util.Stack;

public class FlattenBTtoLinkedList_114 
{
	//Sol 2:Iterative
	public void flatten_iter(TreeNode root)
	{
		if(root==null) return;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while(!st.isEmpty())
		{
			TreeNode cur = st.pop();
			if(cur.right!=null) st.push(cur.right);
			if(cur.left!=null) st.push(cur.right);
			if(!st.isEmpty())
			{
				cur.right = st.peek();
			}
			cur.left = null;
		}
	}
	
	
	
	//Sol 1: Recursion based on graph 
    public void flatten_Rec(TreeNode root)
    {
    	if(root==null) return;
    	
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	flatten_Rec(left);
    	flatten_Rec(right);

    	root.left = null;
    	root.right = left;
    	TreeNode cur = root;
    	while(cur.right!=null)
    	{
    		cur = cur.right;
    	}
    	cur.right = right;

    }


}
