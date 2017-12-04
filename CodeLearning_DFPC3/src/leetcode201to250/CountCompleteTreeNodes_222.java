package leetcode201to250;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class CountCompleteTreeNodes_222 
{
	//sol 5: Binary search for the midnode for recursion
	public int countNodes_5(TreeNode root)
	{
		if(root==null) return 0;
		if(root.left==null) return 1;
		int height = 0;
		int nodesSum = 0;
		TreeNode cur = root;
		while(cur.left!=null)
		{
			nodesSum += (1<<height);
			height++;
			cur = cur.left;
		}
		return nodesSum + countLastLevel(root,height);
	}
	
	private int countLastLevel(TreeNode root, int height)
	{
		if(height==1)
		{
			if(root.right!=null) return 2;
			else if(root.left!=null) return 1;
			else return 0;
		}
		TreeNode midnode = root.left;
		int curheight = 1;
		while(curheight<height)
		{
			midnode = midnode.right;
			curheight++;
		}
		
		if(midnode==null)
		{
			return countLastLevel(root.left,height-1);
		}
		else
		{
			return (1<<(height-1))+ countLastLevel(root.right,height-1);
		}
	}
	//sol 4:
    public int countNodes_4(TreeNode root) 
    {
    	if(root==null) return 0;
    	int left = leftdepth(root.left);
        int right = rightdepth(root.right);
        if(left==right)
            return 1<<(left+2)-1;
        else return (1+countNodes_4(root.left)+countNodes_4(root.right));
    }
    
    public int leftdepth(TreeNode root)
    {
        if(root==null) return -1;
        return 1 + leftdepth(root.left);
    }
    public int rightdepth(TreeNode root)
    {
        if(root==null) return -1;
        return 1 + rightdepth(root.right);
    }
	//sol 3:
	  public int countNodes_3(TreeNode root) {
	        int nodes = 0, h = height(root);
	        while (root != null) {
	            if (height(root.right) == h - 1) {
	                nodes += 1 << h;
	                root = root.right;
	            } else {
	                nodes += 1 << h-1;
	                root = root.left;
	            }
	            h--;
	        }
	        return nodes;
	    }
	
	
	//Sol 2: 
    public int countNodes_2(TreeNode root) 
    {
    	int h = height(root);
    	if(height(root.right)==h-1)
    	{
    		return countNodes_2(root.right) + 1<<h;
    	}
    	else
    	{
    		return countNodes_2(root.left) + 1<<(h-1);
    	}
    	
    }
    
    public int height(TreeNode root)
    {
    	if(root==null) return -1;
    	return 1+height(root.left);
    }
    
	
	
	//Sol 1: For any tree level order traverse time exceed limit
    public int countNodes_1(TreeNode root) 
    {
    	if(root==null) return 0;
    	if(root.left==null || root.right==null) return 1;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int count = 0;
    	while(!queue.isEmpty())
    	{
    		int curlevel = queue.size();
    		count += curlevel;
    		for(int i=0; i<curlevel; i++)
    		{
    			TreeNode cur = queue.poll();
    			if(cur.left!=null)
    			{
    				queue.offer(cur.left);
    			}
    			if(cur.right!=null)
    			{
    				queue.offer(cur.right);
    			}
    		}
    	}
    	return count;
    }
}
