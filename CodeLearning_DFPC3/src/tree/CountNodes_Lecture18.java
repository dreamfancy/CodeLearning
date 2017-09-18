package tree;

public class CountNodes_Lecture18 
{
	public int countNodes(TreeNode root)
	{
		int[] global_max = new int[1];
		global_max[0] = root.val;
		TreeNode[] max_node = new TreeNode[1];
		max_node[0] = root;
		return countNodes(root,global_max, max_node);
	}

	
	public int countNodes(TreeNode root, int[] global_max, TreeNode[] max_node)
	{
		if(root==null) return 0;
		
		int left = countNodes(root.left); 
		int right = countNodes(root.right);
		
		if(Math.abs(left-right)>global_max[0])
		{
			global_max[0] = Math.abs(left-right);
			max_node[0] = root;		 
		}
		
		return (left+right+1);
	}
}
