package first100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 
{

    	//Three value, how to use two pointer??? :  One element use for look, other two
    	//elemnts use two pointer in reverse direction from two side
    	//Remember to Arrays.sort() at the beginning if duplicate should be avoided
    public List<List<Integer>> threeSum(int[] nums) 
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums==null || nums.length<3) return result;
    	
    	Arrays.sort(nums);
    	
    	for(int i=0; i<nums.length-2; i++)
    	{
    		if(i!=0 && nums[i]==nums[i-1]) continue;
    		int j = i+1;
    		int k = nums.length-1;
    		while(j<k)
    		{
    			if(nums[i] + nums[j] + nums[k]==0)
    			{
    				List<Integer> cur = new ArrayList<Integer>();
    				cur.add(nums[i]);
    				cur.add(nums[j]);
    				cur.add(nums[k]);
    				result.add(cur);
    				j++;
    				k--;
    				while(j<k && nums[j]==nums[j-1]) j++;
    				while(j<k && nums[k]==nums[k+1]) k--;
    			}
  
    			else if((nums[i] + nums[j] + nums[k])<0) j++;
    			else k--;
    		}
    	}
    	return result;
    }	
}
