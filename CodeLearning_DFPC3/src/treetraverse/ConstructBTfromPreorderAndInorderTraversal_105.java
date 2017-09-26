package treetraverse;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTfromPreorderAndInorderTraversal_105 
{
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
    	if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0 || preorder.length!=inorder.length) return null;
    	Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
    	
    	for(int i=0; i<inorder.length; i++)
    	{
    		hash.put(inorder[i], i);
    	}
    	
    	TreeNode root = new TreeNode(preorder[0]);
    	
    	
    	
    	return root;
    }
	
    //Solution 1: LC Top Rated
    public TreeNode buildTree_1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        return recoverTree(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode recoverTree(int[] preorder, int r, int[] inorder, int lo, int hi) {
        if (r >= preorder.length || lo > hi) return null;
        
        TreeNode root = new TreeNode(preorder[r]);
        
        for (int mid = lo; mid <= hi; mid++) {
            if (inorder[mid] == preorder[r]) {
                root.left  = recoverTree(preorder, r + 1, inorder, lo, mid - 1);
                root.right = recoverTree(preorder, r + 1 + mid - lo, inorder, mid + 1, hi);
                break;
            }
        }
        
        return root;
    }
}
