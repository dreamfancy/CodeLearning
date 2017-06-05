package tree;

public class SymmetricTree_101 
{
	//You should not change the tree
	//Use overloading
    public boolean isSymmetric(TreeNode root) 
    {
    	if(root==null) return true;
    	return isSymmetric(root.left,root.right);
    }
 
    //Revisit! How to judge symmetric
    private boolean isSymmetric(TreeNode left, TreeNode right)
    {
    	if(left==null && right==null) return true;//First consider true, then all others are false (more common)
    	if(left==null || right==null || left.val != right.val) return false;
    	return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }


	   

}
 