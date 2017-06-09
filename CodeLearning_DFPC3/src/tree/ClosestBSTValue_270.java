package tree;

public class ClosestBSTValue_270 
{

	public int closestValue(TreeNode root, int target)
	{
		if(root==null) return -1;
		int closest = root.val;
		TreeNode cur = root;
		while(cur!=null)
		{
			if(cur.val==target) return target;
			if(Math.abs(target-closest)>Math.abs(root.val-closest))
			{
				closest = cur.val;
			}
			if(closest>target)		
			{	
				cur = cur.left;	
			}
			else
			{
				cur = cur.right;
			}
		}
		return closest;
	}
}
