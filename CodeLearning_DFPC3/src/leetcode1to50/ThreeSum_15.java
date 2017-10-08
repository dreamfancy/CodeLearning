package leetcode1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum_15 
{
	
	
	//Official 1
    public List<List<Integer>> threeSum_1(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums==null || nums.length==0) return res;
        List<Integer> sol = new ArrayList<Integer>();
        Arrays.sort(nums);

        
        for(int i=0; i<nums.length-2; i++)
        {
           	if(i!=0 && nums[i]==nums[i-1]) continue;
            int target = -nums[i];
            //sol.add(nums[i]);
            twoSum_1(nums,i+1,target,res);
            //sol.remove(sol.size()-1);
        }
        
        return res;
    }
	
    public void twoSum_1(int[] nums, int start, int target, List<List<Integer>> res)
    {
        //Set<Integer> hash = new HashSet<Integer>();
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
    
        int left = start;
        int right = nums.length-1;
        
        while(left<right)
        {
        	if(nums[left]+nums[right]==target)
        	{
        		res.add(Arrays.asList(nums[left],nums[right], -target));
        	
        		while(left<right && nums[left]==nums[left+1]) left++;
        		while(left<right && nums[right] == nums[right-1]) right--;
        		left++;
        		right--;
        	}
        	else if (nums[left]+nums[right]<target) left++;
        	else right--;
        }
    }
	
	
	
	//My soltuion: Time exceeds limit
    public List<List<Integer>> threeSum_My(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums==null || nums.length==0) return res;
        List<Integer> sol = new ArrayList<Integer>();
        Arrays.sort(nums);

        
        for(int i=0; i<nums.length-2; i++)
        {
           	if(i!=0 && nums[i]==nums[i-1]) continue;
            int target = -nums[i];
            sol.add(nums[i]);
            twoSum(nums,i+1,target,sol,res);
            sol.remove(sol.size()-1);
        }
        
        return res;
    }
    
    public void twoSum(int[] nums, int start, int target, List<Integer> sol, List<List<Integer>> res)
    {
        //Set<Integer> hash = new HashSet<Integer>();
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        while(start<=(nums.length-1))
        {
            if(!hash.containsKey(nums[start]))
            {
                //System.out.println(nums[start]);
                hash.put(target-nums[start],1);
            }
            else
            {
                if(hash.get(nums[start])==1)
                {
                    System.out.println(nums[start] + "  " + (target-nums[start]));
                    sol.add(target-nums[start]);
                    sol.add(nums[start]);
                    res.add(new ArrayList<Integer>(sol));
                    sol.remove(sol.size()-1);
                    sol.remove(sol.size()-1);
                    hash.put(nums[start],2);
                }
            }
            start++;    
        }
        
    }


	
	
	// Wrong solution. Why it is wrong think about it
    public List<List<Integer>> threeSum_Wrong(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums==null || nums.length==0) return res;
        List<Integer> sol = new ArrayList<Integer>();
        Arrays.sort(nums);
        List<Integer> data = removeDuplicate(nums);
        
        for(int i=0; i<data.size()-2; i++)
        {
        	if(i!=0 && nums[i]==nums[i-1]) continue;
            int target = -data.get(i);
            sol.add(data.get(i));
            twoSum(data,i+1,target,sol,res);
            sol.remove(sol.size()-1);
        }
        
        return res;
    }
    
    public List<Integer> removeDuplicate(int[] nums)
    {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            if(i==0 || nums[i]!=nums[i-1])
                list.add(nums[i]);
        }
        return list;
    }
    
    public void twoSum(List<Integer> data, int start, int target, List<Integer> sol, List<List<Integer>> res)
    {
        Set<Integer> hash = new HashSet<Integer>();
        while(start<(data.size()-1))
        {
            if(!hash.contains(data.get(start)))
            {
                hash.add(target-data.get(start));
            }
            else
            {
                sol.add(data.get(start));
                sol.add(target-data.get(start));
                res.add(new ArrayList<Integer>(sol));
                sol.remove(sol.size()-1);
                sol.remove(sol.size()-1);
            }
            start++;    
        }
        
    }
}
