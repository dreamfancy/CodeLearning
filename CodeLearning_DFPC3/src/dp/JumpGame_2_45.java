package dp;

public class JumpGame_2_45 {
	//solution 1:
	//greedy from left to right
    public int jump_1(int[] nums) 
    {
        if(nums==null || nums.length<=1) return 0;
    	//int[] dp = new int[nums.length];
    	int start = 0; int end = 0;
    	int count = 0;
    	while(start<=end)
    	{ 
    		int newEnd = end;
    		for(int i=start; i<=end; i++)
    		{
    			if(i+nums[i]>newEnd)
    			{
    				newEnd = i+nums[i];
    			}
    		}
    		if(newEnd>=nums.length-1) return count+1;
    		//if(newEnd==end) return false;
    		start = end+1;
    		end = newEnd;
    		count++;
    	}
    	
    	return 0;
    }
    
	//solution 2:
	//DP from right to left
    public int jump(int[] nums) 
    {
        if(nums==null || nums.length<=1) return 0;
    	int[] dp = new int[nums.length];
    	int len = nums.length;
    	//dp[len-1] = 1;
    	
    	for(int i=len-2; i>=0; i--)
    	{
    		int j = nums[i];
    		
    		for(int cur = i+j; cur>i; cur--)
    		{	
    			if(cur>=nums.length-1)
    			{
    				dp[i] = 1;
    			}
    			else if(nums[cur]!=0 && dp[i]==0)
    			{
    				dp[i] = nums[cur]+1;
    			}
    			else
    			{
    				dp[i] = Math.min(dp[i], nums[cur]+1);
    			}
    		}
    	}
    	return dp[0];
    }
}
