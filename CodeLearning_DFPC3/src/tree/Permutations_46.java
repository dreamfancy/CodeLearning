 package tree;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 
{
	//distinct is the key word of this question  
	//int[] array use swap to recursion
    public List<List<Integer>> permute(int[] nums) 
    {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums==null || nums.length==0) return res;
    	//int[] sol = new int[nums.length];
    	helper(nums,0,res); 	
        return res;
    }
    
	//nums array itself is changing through swap, it is also the sol
    public void helper(int[]  nums, int cur,List<List<Integer>> res)
    {
    	if(cur==nums.length-1)
    	{
    		List<Integer> newSol = new ArrayList<Integer>();
    		for(int i=0; i<nums.length; i++)
    		{
    			newSol.add(nums[i]);
    		}
    		res.add(newSol);
    		return;
    	}
    	
    	for(int j=cur; j<nums.length; j++)
    	{
    		swap(nums,j,cur);
    		helper(nums,cur+1,res);
    		swap(nums,j,cur);
    	}
    }
    
    public void swap(int[] nums, int first, int second)
    {
    	if(first==second) return;
    	int temp = nums[first];
    	nums[first] = nums[second];
    	nums[second] = temp;
    }

}
