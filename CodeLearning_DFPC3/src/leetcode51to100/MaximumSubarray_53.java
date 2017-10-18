package leetcode51to100;

public class MaximumSubarray_53 
{
    public int maxSubArray(int[] nums) 
    {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        int n = nums.length;
        
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        int curMax = dp[0];
        
        for(int i=1; i<n; i++)
        {
            if(nums[i]>=0 && dp[i-1]>0) 
            {
                dp[i] = dp[i-1] + nums[i];
                curMax = Math.max(dp[i],curMax);
            }
            else if(nums[i]<0 && dp[i-1]>0)
            {
                dp[i] = dp[i-1] + nums[i];
            }
            //else if(dp[i-1]<=0)
            else
            {
                dp[i] = nums[i];
                curMax = Math.max(dp[i],curMax);
            }
        }
        return curMax;
    }
}
