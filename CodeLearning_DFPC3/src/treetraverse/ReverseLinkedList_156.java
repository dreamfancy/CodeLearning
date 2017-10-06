package treetraverse;

import java.util.Arrays;

public class ReverseLinkedList_156 
{ 
    public TreeNode upsideDownBinaryTree(TreeNode root) 
    {  
    	if(root==null || root.left==null) return root;  	
    	TreeNode finalRoot = upsideDownBinaryTree(root.left);
    	
    	root.left.left = root.right;
    	root.left.right = root;
    	root.left = null;
    	root.right = null; 
    	  
    	/*
    	TreeNode newRoot = root.left;
    	newRoot.left = root.right;
    	newRoot.right = root;
    	root.left = null;
    	root.right = null;
    	*/
    	return finalRoot;
    	
    }


}
