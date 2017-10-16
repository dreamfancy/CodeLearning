package leetcode1to50;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 
{
	//Solution 2: 
	//Since the result is by List, so without swap, directly choose for the new list
	public List<List<Integer>> permute_2(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums==null || nums.length==0) return res;
        
        List<Integer> cursol = new ArrayList<Integer>();
            
        helper_2(nums,0,cursol,res);
        
        return res;
    }
    
    public void helper_2(int[] nums,int cur,List<Integer> cursol,List<List<Integer>> res)
    {
        if(cur==nums.length)
        {
            //cursol.add(nums[cur]);
            res.add(new ArrayList<Integer>(cursol));
            //cursol.remove(cur);
            return;
        }
        
        for(int i=0; i<nums.length; i++)
        {
           if(cursol.contains(nums[i])) continue;
           cursol.add(nums[i]);
           helper_2(nums,cur+1,cursol,res);
           cursol.remove(cursol.size()-1);
        }
    }
	
	
	
	
	//My solution! Using swap because it is in array
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums==null || nums.length==0) return res;
        
        List<Integer> cursol = new ArrayList<Integer>();
            
        helper(nums,0,cursol,res);
        
        return res;
    }
    
    public void helper(int[] nums,int start,List<Integer> cursol,List<List<Integer>> res)
    {
        if(start==nums.length-1)
        {
            cursol.add(nums[start]);
            res.add(new ArrayList<Integer>(cursol));
            cursol.remove(start);
            return;
        }
        
        for(int i=start; i<nums.length; i++)
        {
            swap(nums,i,start);
            cursol.add(nums[start]);
            helper(nums,start+1,cursol,res);
            cursol.remove(start);
            swap(nums,i,start);

        }
    }
    
    public void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
