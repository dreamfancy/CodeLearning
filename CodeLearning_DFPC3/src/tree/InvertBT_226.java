package tree;

public class InvertBT_226 {
	   public TreeNode invertTree(TreeNode root) 
	   {
		   if(root==null) return root;
		   TreeNode temp = root.left;
		   root.left = root.right;
		   root.right = temp;
		   root.left = invertTree(root.left);
		   root.right = invertTree(root.right);
		   
		   return root;
	   }
	   
	   //The promise of the solution above is that the return root does not change. A more generic solution is as above
	   
	   public TreeNode invertTree_standard(TreeNode root) 
	   {
		   if(root==null) return root;
		   TreeNode temp = root.left;
		   root.left = root.right;
		   root.right = temp;
		   TreeNode left = invertTree(root.left);
		   TreeNode right = invertTree(root.right);
		   root.left = right;
		   root.right = left;
		   
		   return root;
	       }
}
