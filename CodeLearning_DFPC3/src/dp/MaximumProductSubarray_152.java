package dp;

public class MaximumProductSubarray_152 
{
	//My solution 1:
	//Two dp array. So one position has two values used for dp.
	//One for positive, one for negative.
    public int maxProduct(int[] nums) 
    {
    	if(nums==null || nums.length==0) return 0;
    	if(nums.length==1) return nums[0];

    	int[] dp1 = new int[nums.length];
    	int[] dp2 = new int[nums.length];
    	
    	if(nums[0]>=0)
    	{
    		dp1[0] = nums[0];
    		dp2[0] = 0;
    	}
    	else
    	{
    		dp1[0] = 0;
    		dp2[0] = -nums[0];
    	}
    	
    	for(int i=1; i<nums.length;i++)
    	{
    		if(nums[i]==0)
    		{
    			dp1[i] = 0;
    			dp2[i] = 0;
    		}
    		else if(nums[i]>0)
    		{
    			if(dp1[i-1]==0) dp1[i] = nums[i];
    			else dp1[i] = dp1[i-1]*nums[i];
    			if(dp2[i-1]==0)dp2[i] = 0;
    			else dp2[i] = dp2[i-1]*nums[i];
    		}
    		else
    		{
    			if(dp1[i-1]==0) dp2[i] = -nums[i];
    			else dp2[i] = dp1[i-1]*(-nums[i]);
    			if(dp2[i-1]==0)dp1[i] = 0;
    			else dp1[i] = dp2[i-1]*(-nums[i]);
    		}    		
    	}
    	int max = 0;
		for(int i=0; i<dp1.length;i++)
		{
			if(dp1[i]>max) max = dp1[i];
		}
		return max;
    }  

	
}
