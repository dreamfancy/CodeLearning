package leetcode51to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_2_90 {

	//solution 2: When there are duplicates, use forloop
    public List<List<Integer>> subsetsWithDup_2(int[] nums) 
    {    
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        List<Integer> cursol = new ArrayList<Integer>();
        subsetsWithDup_2(nums,0,cursol,res);
        
        return res;
    }
    
    private void subsetsWithDup_2(int[] nums, int start, List<Integer> cursol, List<List<Integer>> res)
    {
        if(start>nums.length) return;
        res.add(new ArrayList<Integer>(cursol));
        
        for(int i=start; i<nums.length; i++)
        {
        	if(i!=start && nums[i]==nums[i-1]) continue;
            cursol.add(nums[i]);
            subsetsWithDup_2(nums,i+1,cursol,res);
            cursol.remove(cursol.size()-1);
        }
    }
	
	
	
	
	//My Solution : Pass -> add a variable of preselected
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {    
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        List<Integer> cursol = new ArrayList<Integer>();
        subsetsWithDup(nums,0,cursol,res,false);
        
        return res;
    }
    
    private void subsetsWithDup(int[] nums, int start, List<Integer> cursol, List<List<Integer>> res,boolean preselected)
    {
        if(start>nums.length) return;
        if(start==nums.length)
        {
            res.add(new ArrayList<Integer>(cursol));
            return;
        }
        if(!(start>0 && nums[start]==nums[start-1] && preselected))
        {
            subsetsWithDup(nums,start+1,cursol,res,false);
        }
        cursol.add(nums[start]);
        subsetsWithDup(nums,start+1,cursol,res,true);
        cursol.remove(cursol.size()-1);
    }
	
	
}
