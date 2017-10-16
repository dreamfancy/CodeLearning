package leetcode1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_2_47 
{
	
	//Solution 2!
	public List<List<Integer>> permute_2(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums==null || nums.length==0) return res;
        
        List<Integer> cursol = new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];   
        helper_2(nums,0,cursol,res,used);
        
        return res;
    }
    
    public void helper_2(int[] nums,int cur,List<Integer> cursol,List<List<Integer>> res,boolean[] used)
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
           if(used[i]==true) continue;
           if(i!=0 && nums[i]==nums[i-1] && used[i-1] == false) continue;  //Revisit !!! why
           cursol.add(nums[i]);
           used[i] = true;
           helper_2(nums,cur+1,cursol,res,used);
           cursol.remove(cursol.size()-1);
           used[i] = false;
        }
    }
	
	
	//Solution 1:
	//From 46 Solution 1 ! It is wrong!!!!!!
    //When there are continous same element, it needs used[] to check if you can select this one
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums==null || nums.length==0) return res;
        
        List<Integer> cursol = new ArrayList<Integer>();
        Arrays.sort(nums);
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
            if(i!=start && nums[i]==nums[i-1]) continue;
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
