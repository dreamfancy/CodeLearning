package first100;

import java.util.Arrays;

public class ThreeSumClosest_16 
{    
	
	//Solution 1: My Solution: 3 pointers based on two pointers in reverse
	//direction + another for loop
	public int threeSumClosest_MySolution(int[] nums, int target) 
	{
		if(nums==null || nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		if(nums.length==2) return nums[0]+nums[1];
		//or  throw new IllegalArgumentException();

		Arrays.sort(nums);
		
        int val = nums[0]+nums[1]+nums[2];
		int min = Math.abs(val-target);
		
		for(int i=0; i<nums.length-2; i++)
		{
			int j=i+1;
			int k=nums.length-1;
			
			while(j<k)
			{
				int cur = nums[i]+nums[j]+nums[k]-target;
				if(Math.abs(cur)<min)
				{
                    val = nums[i]+nums[j]+nums[k];
					min =Math.abs(cur);
					if(min==0) return val;
					//else if(cur<0) j++;
					//else k--;
				}
				if (cur>0) k--;
				else j++;
			}
		}
		return val;
	}
}
