package treetraverse;

//Revisit!!!
public class RemoveTargetInBST {

	//solution 2: Zizuo lecture

	public TreeNode removeTargetInBST(TreeNode root, int target)
	{
		if(root==null) return null;
		if(root.val==target)
		{
			if(root.right!=null && root.left!=null)
			{
				root.val = findSmallest(root.right).val;
				root.right = removeTargetInBST(root.right,root.val);
			}
			else
			{
				root = (root.left!=null)? root.left : root.right;
			}
		}
		else if(root.val<target) root.right = removeTargetInBST(root.right,target);
		else if(root.val>target) root.left = removeTargetInBST(root.left,target);
		
		return root;
		
	}
	
	public void deleteSmallest(TreeNode root)
	{
		while(root.left.left!=null)
		{
			root = root.left;
		}
		root.left = null;
	}
	
	public TreeNode findSmallest(TreeNode root)
	{
		while(root.left!=null)
		{
			root = root.left;
		}
		return root;
	}
}
