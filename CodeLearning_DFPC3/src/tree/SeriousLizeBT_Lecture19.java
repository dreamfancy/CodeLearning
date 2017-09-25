package tree;

public class SeriousLizeBT_Lecture19 
{
	TreeNode head;
	
	
	//Solution 1:
	//In Order, do something connect the previous node and the current node
	public void inOrder(TreeNode root, TreeNode prev)
	{
		if(root==null) return;
		inOrder(root.left,prev);
		
		  //do something
		if(prev!=null) prev.right = root;
		else head = root;
		root.left = prev;
		prev = root;
		
		inOrder(root.right,prev);
	}
	
	//Solution 2: Divide And Conquer
	public TreeNode inOrder(TreeNode root)
	{
		if(root==null) return root;
		
		TreeNode r = inOrder(root.right);
		if(r!=null) r.left = root;
		root.right = r;
		TreeNode l = inOrder(root.left);
		return l;
	}

}
