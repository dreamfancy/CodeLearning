package leetcode131to160;

public class MaximumProductSubarray_152 
{
	//Sol 3: Min Max can only be got from premin, premax and cur value
	   public int maxProduct_official(int[] nums) {
	        if (nums.length == 0) return 0;
	        int n = nums.length;
	        int min = nums[0], max = nums[0];
	        int result = nums[0];
	        for (int i = 1; i < n; i++) {
	            int val = nums[i];
	            int max_bak = max;
	            max = Math.max(val, Math.max(max * val, min * val));
	            min = Math.min(val, Math.min(max_bak * val, min * val));
	            result = Math.max(result, max);
	        }
	        return result;
	    }
	
	
	//Sol 2: My Sol Correct
	//Keep both the max and min for each element;
	//the min value can be used to generate future max
    public int maxProduct(int[] nums) 
    {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        int[] minval = new int[nums.length];
        int[] maxval = new int[nums.length];
        
        minval[0] = nums[0];
        maxval[0] = nums[0]; 
        int max = nums[0];
        
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] == 0)
            {
                minval[i] = 0;
                maxval[i] = 0;
            }
            else if(nums[i]>0)
            {
                if(maxval[i-1]>1) 
                {
                    maxval[i] = maxval[i-1] * nums[i];
                }
                else
                {
                    maxval[i] = nums[i];
                }
                
                if(minval[i-1]<1)
                {
                    minval[i] = minval[i-1] * nums[i];
                }
                else
                {
                    minval[i] = nums[i];
                }   
            }
            else
            {
                if(minval[i-1]<1) 
                {
                    maxval[i] = minval[i-1] * nums[i];
                }
                else
                {
                    maxval[i] = nums[i];
                }
                
                if(maxval[i-1]>1)
                {
                    minval[i] = maxval[i-1] * nums[i];
                }
                else
                {
                    minval[i] = nums[i];
                }  
                
            }
            
            max = Math.max(max,maxval[i]);
        }
        return max;
    }
	
	
	
	//sol 1 wrong
	//dp[i] cannot only get from dp[i-1] because there can be 
	//more than 2 elments to create a bigger value
    public int maxProduct_wrong(int[] nums) 
    {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        int max = dp[0];
        
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] == 0) dp[i] = 0;
            else if(nums[i]>0)
            {
                if(dp[i-1]<=1) dp[i] = nums[i];
                else dp[i] = dp[i-1] * nums[i];
            }
            else
            {
                if(dp[i-1]<=1) dp[i] = nums[i] * dp[i-1];
                else dp[i] = nums[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
