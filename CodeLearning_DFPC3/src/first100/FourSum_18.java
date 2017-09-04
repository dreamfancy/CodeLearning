package first100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
	
	//Solution 1: Two loops + two pointers 
	//Attention it needs to deal with duplicate scenarios
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums==null || nums.length<4) return result;
    	Arrays.sort(nums);
    	for(int i=0; i<nums.length-3; i++)
    	{
    		if(nums[i]>target) break;
    		for(int j=i+1; j<nums.length-2;j++)
    		{
    			int cur = nums[i]+nums[j];
    			if(cur>target) break;
    			
    			int k=j+1;
    			int l = nums.length-1;
    			while(k<l)
    			{
    				if(cur+k+l==target)
    				{
    					List<Integer> newRes = new ArrayList<Integer>();
    					newRes.add(nums[i]);
    					newRes.add(nums[j]);
    					newRes.add(nums[k]);
    					newRes.add(nums[l]);
    					result.add(newRes);
    				}
    			}
    			
    		}
    	}
    	
    }

}
