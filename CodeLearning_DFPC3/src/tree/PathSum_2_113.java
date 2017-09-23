package tree;

import java.util.ArrayList;import java.util.Collections;
import java.util.List;

public class PathSum_2_113 {
	
	//Solution 1: My Solution 
    public List<List<Integer>> pathSum(TreeNode root, int sum) 
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root==null) return result;
    	
    	List<Integer> curSol = new ArrayList<Integer>();
    	pathSum(root,sum, curSol,result);
    	return result;
    }
    
    public void pathSum(TreeNode root, int leftVal, List<Integer> cursol, List<List<Integer>> result)
    {
    	if(root==null) return;
    	if(root.left==null && root.right==null && leftVal==root.val)
    	{
    		cursol.add(root.val);
    		//cursol.add(root.val);
    		result.add(new ArrayList<Integer>(cursol));
         	cursol.remove(cursol.size()-1);
    		return;
    	}
    	if(root.left==null && root.right==null) return;
    	
    	if(root.left!=null)
    	{
    		cursol.add(root.val);
    		pathSum(root.left,leftVal-root.val,cursol,result);
         	cursol.remove(cursol.size()-1);
    	}
    	
     	if(root.right!=null)
    	{
    		cursol.add(root.val);
    		pathSum(root.right,leftVal-root.val,cursol,result);
         	cursol.remove(cursol.size()-1);
    	}
    }
    
    
    //Solution 2: LC_TopRatedSolution
    
    public List<List<Integer>> pathSum_2(TreeNode root, int sum) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(root, list, sum, result);
        return result;
    }
    private void helper(TreeNode root, ArrayList<Integer> list, int target, ArrayList<List<Integer>> result) {
        if (root.val == target && root.left == null && root.right == null) {
            list.add(root.val);
            result.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        target -= root.val;
        if (root.left != null) {
            helper(root.left, list, target, result);
        }
        if (root.right != null) {
            helper(root.right, list, target, result);
        }
        list.remove(list.size() - 1);
    }

}
