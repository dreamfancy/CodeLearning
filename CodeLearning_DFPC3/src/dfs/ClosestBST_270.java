package dfs;

public class ClosestBST_270 
{
	public int closestBSTValue(TreeNode root, int target) throws Exception
	{
		if(root==null) throw new Exception();
		int[] closest = new int[1];
		closest[0] = root.val;
		
		if(root.val == target) return root.val;
		else if(root.val<target)
		{
			closestBSTValue(root.right,target,closest);
		}
		else if(root.val>target)
		{
			closestBSTValue(root.left,target,closest);
		}
		return closest[0];
	}
	
	public void closestBSTValue(TreeNode root,int target, int[] closest)
	{
		if(root==null) return;
		if(root.val==target) 
		{
			closest[0] = target;
			return;
		}
		else if(root.val>target)
		{
			if(Math.abs(closest[0]-target)>Math.abs(root.val-target))
			{
				closest[0] = root.val;
			}
			closestBSTValue(root.left,target,closest);
		}
		else if(root.val<target)
		{
			if(Math.abs(closest[0]-target)>Math.abs(root.val-target))
			{
				closest[0] = root.val;
			}
			closestBSTValue(root.right,target,closest);
		}
		
	}

}
