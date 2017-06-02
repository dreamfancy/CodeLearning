package tree;

public class TreeBasic {

	
	public static void inOrder(TreeNode root)
	{
		if(root==null) return;
		//if(root.left!=null) 
		inOrder(root.left);
		System.out.println(root.val);
		//if(root.right!=null) 
		inOrder(root.right);
	}
	
	public static void preOrdeR(TreeNode root)
	{
		if(root==null) return;
		System.out.println(root.val);

		//if(root.left!=null) 
		inOrder(root.left);
		//if(root.right!=null) 
		inOrder(root.right);
	}
	
}
