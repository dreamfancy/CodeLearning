package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum_3_437 
{
	public int pathSum_1(TreeNode root, int sum) {

        if(root==null) return 0;
        int[] result = new int[1];
        List<Integer> curSum = new ArrayList<Integer>();
        pathSum(root,sum, curSum,result);
        return result[0];
    }
    
    public void pathSum(TreeNode root, int sum, List<Integer> curSum, int[] result)
    {
        if(root==null) return;
        int val = root.val;
        
        for(int i=0; i<curSum.size(); i++)
        {
        	curSum.set(i, curSum.get(i)+val);
        }
        curSum.add(val);
        
        //if(root.left==null && root.right==null && hasMatch(sum,curSum))
        //if(hasMatch(sum,curSum))
        //{
        result[0] += hasMatch(sum,curSum);
        //}
        
        pathSum(root.left,sum,curSum,result);
        pathSum(root.right,sum,curSum,result);
        
        for(int i=0; i<curSum.size(); i++)
        {
        	curSum.set(i, curSum.get(i)-val);
        }
        curSum.remove(curSum.size()-1);
        
        //if(root.left!=null) return hasPathSum(root.left,sum,curSum+root.val);
        //if(root.right!=null) return hasPathSum(root.right,sum,curSum+root.val);
        
        //return false;
    }

    public int hasMatch(int val,List<Integer> curSum)
    {
    	int count = 0;
    	for(int i : curSum)
    	{
    		if(val==i)
    			count++;
    	}
    	return count;
    }
    
    //Solution 2: Leetcode Discussion Solution: Two conception code for one node
    public int pathSum_2(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum_2(root.left, sum) + pathSum_2(root.right, sum);
    }
    
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) 
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
    
    //Solution 3: Leetcode toprated solution 
    public int pathSum_3(TreeNode root, int sum) {
        int pathsum = 0;
        if (root != null){
             pathsum = traverse(root, sum, 0);
             pathsum += pathSum_3(root.right,sum);
             pathsum += pathSum_3(root.left,sum);
        }
        return pathsum;
    }
    
    private int traverse(TreeNode node, int target, int current){
        int paths = 0;
        if (node != null){
            current += node.val;
            //System.out.println(current + "   " + node.val);
            if (current == target) {
                paths ++;
            }
            paths += traverse(node.left,target,current);
            paths += traverse(node.right,target,current);
        }
        return paths;
    }
}
