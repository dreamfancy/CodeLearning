package leetcode251to300;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 
{
	//Sol 2: O(nlogn)
	
	
	
	//Sol 1: O(n2)
    public int lengthOfLIS_1(int[] nums) 
    {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return 1;
        
        int len = nums.length;
        int[] dp = new int[len];
        
        Arrays.fill(dp,1);
        
        for(int i=1; i<len; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(nums[j]<nums[i])
                {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        
        int max = 0;
        for(int k=0; k<len; k++)
        {
            max = Math.max(max,dp[k]);
        }
        return max;
    }

}
