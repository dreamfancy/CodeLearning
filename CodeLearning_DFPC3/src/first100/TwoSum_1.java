package first100;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_1 {
    
	//Solution 2: Time O(n), Space O(n)
	public int[] twoSum_2(int[] nums, int target) 
	{
		int[] result = new int[2];
		if(nums==null || nums.length==0) return result;
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		for(int i=0; i<nums.length; i++)
		{
			int val = nums[i];
			if(hash.containsKey(val))
			{
				result[0] = hash.get(val);
				result[1] = i;
				return result;
			}
			else
			{
				hash.put(target-val,i);
			}
		}
		 return result;
	}
	
	
	//Solution 1: Double Pointer, no extra space
	public int[] twoSum_1(int[] nums, int target) 
    {
		int[] result = new int[2];
		
		for(int i=0; i<nums.length; i++)
		{
			for(int j=0; j<nums.length; j++)
			{
				if(nums[i]+nums[j]==target)
				{
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
    	
    }

}
