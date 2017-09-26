package treetraverse;

import tree.TreeNode;

public class FlatternBTtoLinkedList_114 
{
	
	//Solution 1 : My Initial Solution : Wrong
    public void flatten_1(TreeNode root) {
        preOrder_1(root,null);
    }
    
    public void preOrder_1(TreeNode root, TreeNode pre)
    {
        if(root==null) return;
        if(pre!=null)
        {
            pre.right = root;
        }
        TreeNode n1 = root.left;
        TreeNode n2 = root.right;
        preOrder_1(n1,root);
        preOrder_1(n2,n1);        //Wrong !! Maybe it is not n1
        root.left = null;
    }
    
    //My solution try 2:
    //Wrong
    
   /*
    public void flatten_2(TreeNode root) {
        preOrder_2(root,null);
        
    }
    
    public void preOrder_2(TreeNode root, TreeNode pre)
    {
        if(root==null) return;
        System.out.println("Current root is " + root.val);
         
        if(pre!=null)
        {
            pre.right = root;
            pre.left = null;
        }
        pre = root;
        TreeNode right = null;
        boolean flag = false;
        if(root.right!=null)
        {
        	flag = true;
        	right = root.right;
        }
        preOrder_2(root.left,pre);
        if(flag == true)
        {
        	preOrder_2(right,pre);        //Wrong !! Maybe it is not n1
        }
        root.left = null;
    }
    */
    
    //Official Solution 1: LC Top rated
    //How to resolve the issue right has been modified during left process:
    //PROCESS right first
    public void flatten_3(TreeNode root) {
        // use a method to return root of after flatten node
        helper(root);
    }
    public TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right); 
        root.right = left;
        root.left = null;
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;
        return root;
    }
    
    
    //Zizuo Liu Lecture Solution
    public TreeNode flatten_4(TreeNode root)
    {
    	return flatten_4(root,null);
    }
    
    private TreeNode flatten_4(TreeNode root, TreeNode tail)
    {
    	if(root==null) return tail; 
    	root.right = flatten_4(root.left,flatten_4(root.right,tail));   //REVISIT!!!
    	root.left = null;
    	return root;
    	
    }
}
