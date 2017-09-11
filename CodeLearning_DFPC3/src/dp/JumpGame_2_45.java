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
	//DP from right to left My Solution
    //I do not know if it is right or wrong
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
    			else if(nums[cur]!=0) 
    			{
    				dp[i] = Math.min(dp[i], nums[cur]+1);
    			}
    		}
    	}
    	return dp[0];
    }
    
    //Solution 3: Lecture Solution 
    
    public int jumpGame_3(int[] arr)
    {
    	if(arr==null || arr.length==0) return 0;
    	int n = arr.length ,min;
    	int[] dp = new int[n];
    	dp[n-1] = 0;
    	
    	for(int i=n-2; i>=0; i--)
    	{
    		int minVal = Integer.MAX_VALUE;
    		for(int j=1; j<=arr[i]; j++)
    		{
    			if(i+j<n) minVal = Math.min(minVal, dp[i+j]);
    		}
    		if(minVal==Integer.MAX_VALUE) dp[i] = Integer.MAX_VALUE;
    		else dp[i] = minVal+1;
    	}
    	return dp[0];
    	
    }
    
    //Solution 4: Lecture
    //Another solution of greedy
    public int jumpGame_4(int[] nums)
    {
    	if(nums==null || nums.length<2) return 0;
    	int result = 0;
    	int pre = 0;
    	int cur = 0;
    	
    	for(int i=0; i<nums.length; i++)
    	{
    		if(i>pre)
    		{
    			pre = cur;
    			result++;
    		}
    		cur = Math.max(cur, i+nums[i]);
    	}
    	return result;
    }
    
}
