package dp;

public class JumpGame_55 
{
	// MySolution_Recursion solution, will exceed time limit
    public boolean canJump_Rec(int[] nums) 
    {
    	if(nums==null || nums.length<=1) return true;
    	return canJumpHelper(nums,0); 	
    }
    
    public boolean canJumpHelper(int[] nums, int cur)
    {
    	if(cur>=nums.length-1) return true;
    	
    	int jump = nums[cur];
    	
    	//for(int i=1; i<=jump; i++)
    	for(int i=jump; i>=1; i--)     //Recursion needs Greedy to optimize!!!
    	{
    		//boolean jumpRes = canJumpHelper(nums,cur+i);
    		//if(jumpRes==true) return true;
    		if(canJumpHelper(nums,cur+i)) return true;
    	}
    	return false;
    }
    
    //Sol 2: DP
    //Why DP: DAN ZHI problem
    //Still exceed the limit
    public boolean canJump_DP(int[] nums) 
    {
    	boolean[] dp = new boolean[nums.length];
    	dp[0] = true;
    	for(int i=0;i<nums.length;i++)
    	{
    		if(dp[i]==true)
    		{
    			int jump = nums[i];
    			for(int j=1;j<=nums[i];j++)
    			{
    				if((i+j)<nums.length)
    				{
    					dp[i+j]=true;
    				}
    			}
    		}
    	}
    	return dp[nums.length-1];
    }
    
    //Sol 3: DP
    //Think in an opposite way to resolve the problem, 
    //Recursion is from left to right so DP is from right to left
    public boolean canJump(int[] nums) 
    {
        if(nums==null || nums.length<=1) return true;
    	boolean[] dp = new boolean[nums.length];
    	dp[nums.length-1] = true;
    	
    	for(int i=nums.length-2; i>=0; i--)
    	{
    		if(i+nums[i]>=nums.length-1) dp[i]=true;
            else
            {
    		    for(int j=1; j<=nums[i];j++)
    		    {
    		    	if(dp[i+j]==true) dp[i] = true;
    		    }
            }
    	}
    	return dp[0];    	
    }
}
