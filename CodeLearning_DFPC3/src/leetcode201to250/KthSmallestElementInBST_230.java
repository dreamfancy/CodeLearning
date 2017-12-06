package leetcode201to250;

import java.util.Stack;

import tree.TreeNode;

public class KthSmallestElementInBST_230 
{
	//Sol 3: BST:
	public int kthSmallest_BS(TreeNode root, int k)
	{
		int countleft = countNodes(root.left);
		if(k<=countleft) return kthSmallest_BS(root.left,k);
		else if(k>countleft+1) return kthSmallest_BS(root.right,k-countleft-1);
		return root.val;
	}
	
	
	public int countNodes(TreeNode root)
	{
		if(root==null) return 0;
		return 1+ countNodes(root.left)+countNodes(root.right);
	}
	
	
	//Sol 2: In order traverse Iterative
    public int kthSmallest_2(TreeNode root, int k) 
    {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(root!=null || !stack.isEmpty())
    	{
    		while(root!=null)
    		{
    			stack.push(root);
    			root = root.left;
    		}
    		k--;
    		root = stack.pop();
    		if(k==0) return root.val;
    		root = root.right;
    	}
    	return -1;
    }

	
	
	//Sol 1: In order traverse  recursive
    public int kthSmallest_1(TreeNode root, int k) 
    {
        if(root==null) return -1;
        int[] data = new int[2];
        data[0] = k;
        traverseBST(root,data);
        return data[1];
    }
    
    private boolean traverseBST(TreeNode root, int[] data)
    {
        if(root==null) return false;
        boolean left = traverseBST(root.left,data);
        if(left) return true;
        data[0] = data[0] - 1;
        if(data[0]==0)
        {
            data[1] = root.val;
            return true;

        }
        return traverseBST(root.right,data);
}
}