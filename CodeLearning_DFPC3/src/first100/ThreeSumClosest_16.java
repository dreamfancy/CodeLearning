package first100;

import java.util.Arrays;

public class ThreeSumClosest_16 
{    
	public int threeSumClosest(int[] nums, int target) 
	{
		if(nums==null || nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		if(nums.length==2) return nums[0]+nums[1];
		
		Arrays.sort(nums);
		
		int min = Math.abs(nums[0]+nums[1]+nums[2]-target);
		
		for(int i=0; i<nums.length-2; i++)
		{
			int j=i+1;
			int k=nums.length-1;
			
			while(j<k)
			{
				int cur = nums[0]+nums[1]+nums[2]-target;
				if(Math.abs(cur)<min)
				{
					min =Math.abs(cur);
					if(min==0) return 0;
					else if(min<0) j++;
					else k--;
				}
				if (cur>0) k--;
				else j++;
			}
		}
		return min;
	}
}
