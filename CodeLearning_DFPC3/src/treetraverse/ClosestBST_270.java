package treetraverse;
 
public class ClosestBST_270 
{
	//Follow up:
	/* If the question is find the largest smaller than target
	 * 1 change the initialization of result to Integer.Min_Value 
	 * 2 Before return ,you need to make sure the result is valid as
	 * it is possible that none of the tree node satisfy the requirement
	 */
	
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
