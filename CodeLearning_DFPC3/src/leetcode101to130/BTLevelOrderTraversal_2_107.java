package leetcode101to130;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal_2_107 
{
	//Sol 2: Use Queue
	
    public List<List<Integer>> levelOrderBottom_2(TreeNode root) 
    {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
    	if(root==null) return wrapList;
    	queue.offer(root);
    	while(!queue.isEmpty())
    	{
    		int levelNum = queue.size();
    		List<Integer> subList = new LinkedList<Integer>();
    		for(int i=0; i<levelNum; i++)
    		{
    			if(queue.peek().left!=null) queue.offer(queue.peek().left);
    			if(queue.peek().right!=null) queue.offer(queue.peek().right);
    			subList.add(queue.poll().val);
    		}
    		wrapList.add(0,subList);
    	}
    	return wrapList;
    }

	
	
	
	//Sol 1: My Sol: Use getDepth()
    public List<List<Integer>> levelOrderBottom_1(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        int depth = getDepthOfTree(root);
        
        for(int i=0; i<depth; i++)
        {
            result.add(new ArrayList<Integer>());
        }
        
        levelOrderBottom(root,depth-1,result);
        return result;
    }
    
    public void levelOrderBottom(TreeNode root, int level, List<List<Integer>> result)
    {
        if(level<0 || root==null) return;
        result.get(level).add(root.val);
        if(root.left!=null)
        {    
            levelOrderBottom(root.left,level-1,result);
        }
        if(root.right!=null)
        {
            levelOrderBottom(root.right,level-1,result);
        }
    }
    
    public int getDepthOfTree(TreeNode root)
    {
        if(root==null) return 0;
        else return (Math.max(getDepthOfTree(root.left),getDepthOfTree(root.right))+1);
    }
    
}
