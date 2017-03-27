/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

package tree;

public class DeleteNodeInBST_450 {
	
	//Solution_2: Recursive, User recursive then you can avoid discussing whether it is a left child
	//--or right child;
	public TreeNode deleteNode_2(TreeNode root, int key) {
		
		if(root == null) return root;
		if(root.val>key)
		{
			root.left = deleteNode_2(root.left,key);
		}
		else if(root.val<key)
		{
			root.right = deleteNode_2(root.right,key);
		}
		else
	    {
		    if(root.left == null)
		    {
		    	return root.right;
	    	}
	    	else if(root.right == null)
	    	{
	    	    return root.left;
	    	}
	    	else
	    	{
	    		findPositionForLeft(root.right).left = root.left;
	    		return root.right;
	    	}
	    }
	
		return root;
    }
	
	
	
	//Solution_1: No recursive but use two pointer: One is parent with the other child:
	public TreeNode deleteNode(TreeNode root, int key) {
    
		TreeNode cur = root;
		TreeNode parent = null;
		int flag = 0;
		if(root == null) return null;
		while(cur.val != key)
		{
			if(cur.val<key)
			{
				parent = cur;
				cur = cur.right; 
				flag = 2;
			}
			else if(cur.val>key)
			{
				parent = cur;
				cur = cur.left;
				flag = 1;
			}
			
			if(cur == null) return root;
		}
		
		if(parent == null)
		{
			if(root.left == null) return root.right;
			else if(root.right == null)  return root.left;
			else
			{
				findPositionForLeft(root.right).left = root.left;
				root = root.right;
			}
		}
		if(parent != null)
		{
			/*
			if(cur.left == null && flag == 1)
			{
				parent.left = cur.right;
			}
			else if(root.left == null && flag == 2) 
			{
				parent.right = cur.right;
			}
			else if(root.right == null && flag == 1)
			{
				parent.left = cur.left;
			}
			else if (root.right == null & flag == 2)
			{
				parent.right = cur.right;
			}
			else
			{
			*/
			    if(cur.right == null)
			    {
			        if(flag == 1) parent.left = cur.left;
			        else if(flag == 2) parent.right = cur.left;
			    }
			    else
			    {
				    findPositionForLeft(cur.right).left = cur.left;
			    	if(flag == 1)
			    	{
		    			parent.left = cur.right;
		    		}
		    		else
		    		{
		    			parent.right = cur.right;
		    		}
			    }
		}
		return root;
	}
	
	public static TreeNode findPositionForLeft(TreeNode pos)
	{
		if(pos == null) return null;
		while(pos.left != null)
		{
			pos = pos.left;
		}
		return pos;
	}
	
	
}
