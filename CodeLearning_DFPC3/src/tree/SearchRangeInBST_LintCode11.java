package tree;

import java.util.ArrayList;

public class SearchRangeInBST_LintCode11 
{

	//Print in order traverse
	
	public void searchRange(TreeNode root, int k1, int k2, ArrayList<TreeNode> result)
	{
		if (root==null) return;
		if(root.val>k1) searchRange(root.left,k1,k2,result);
		if(root.val>k1 && root.val<k2) result.add(root);
		if(root.val<k2) searchRange(root.right,k1,k2,result);

		
	}
}
