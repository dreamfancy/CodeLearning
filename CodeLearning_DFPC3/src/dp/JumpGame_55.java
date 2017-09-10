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
    	for(int i=jump; i>=1; i--)     //Recursion needs Greedy to optimize !!!
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
    public boolean canJump_3(int[] nums) 
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
    
    public boolean canJump_3_optimize(int[] nums) 
    {
        if(nums==null || nums.length<=1) return true;
    	boolean[] dp = new boolean[nums.length];
    	dp[nums.length-1] = true;
    	
    	for(int i=nums.length-2; i>=0; i--)
    	{
		    for(int j=nums[i]; j>=1;j--)
		    {
		    	if(i+j>=nums.length-1 || dp[i+j])
		    	{
		    		dp[i] = true;
		    		break;
		    	}
		    }
    	}
    	return dp[0];    	
    }
    
    
    //Sol 4: Best : Greedy 
    public boolean canJump_4_greedy(int[] nums) 
    {
        if(nums==null || nums.length<=1) return true;
    	boolean[] dp = new boolean[nums.length];
    	int start = 0; int end = 0;
    	int cur;
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
    		if(newEnd>=nums.length-1) return true;
    		if(newEnd==end) return false;
    		start = end+1;
    		end = newEnd;
    	}
    	
    	return false;
    }
    
    //Sol 5: greedy optimized
   public boolean canJump_5(int[] nums) {
        
        if(nums == null || nums.length==0) {
            return false;
        }
        
        int maxLocation = nums[0];
        
        for(int i =0; i< nums.length; i++) {
            if(maxLocation<i) {
                return false;
            }           
            maxLocation = Math.max(maxLocation, i + nums[i]);
        }
        
        return true;
    }  
   
   //Sol 6: greedy optimized
   
   public boolean canJump_6(int[] nums)
   {
	   int maxRange = 0;
	   for(int i=0; i<=maxRange; i++)
	   {
		   maxRange = Math.max(maxRange, i+nums[i]);
		   if(maxRange>nums.length-1) return true;
	   }
	   return false;
   }
}
