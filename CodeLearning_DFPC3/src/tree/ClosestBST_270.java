package tree;

public class ClosestBST_270 {

	//Solution 1: Iteration
	public int closestValue(TreeNode root, int target)
	{
		if(root == null) return -1; //Here should throw an exception
		int curCloset = root.val;
		while(root!=null)
		{
			if(root.val==target) return target;
			if(Math.abs(curCloset-target)>Math.abs(root.val-target))
			{
				curCloset = root.val;
			}
			if(root.val>target)
			{
				root = root.left;
			}
			else
			{
				root = root.right;
			}
		}
		
		return curCloset;
	}
	
	
	//Solution 2: Recursion
	public int closestValue_Recursive(TreeNode root, int target)
	{
		if(root == null) return -1; //Here should throw an exception

		if(root.val==target) return target;
		int cur = root.val;
		TreeNode kid = (root.val>target) ? (root.left):(root.right);
		
		if(kid==null) return root.val;
		
		int closest_pre = closestValue_Recursive(kid,target);
		
		return Math.abs(closest_pre-target)<Math.abs(cur-target)? closest_pre : cur;
	}
}
