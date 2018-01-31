package leetcode300to350;

public class BurstBalloons_312 
{
	/*
	 d[i][j] = max(dp[i][j], dp[i][x-1] + nums[i-1]*nums[x]*nums[j+1] + dp[x+1][j])
	*/
    public int maxCoins(int[] nums) 
    {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int len = nums.length;
        int[] arr = new int[len+2];
        arr[0] = arr[len+1] = 1;
        
        for(int i=0; i<len; i++)
        {
            arr[i+1] = nums[i];
        }
        
        int[][] dp = new int[len+2][len+2];
        /*
        for(int i=0; i<len+1; i++)
        {
            dp[i][i+1] = arr[i]*arr[i+1];
        }
        */
        //dp can also use recursion. Why DP: because we do not want to calculate a result previously we have calculated. just check if dp[i][j]==0 when recursions are there.
        
        return helper(arr,dp,1,len); 
    }
    
    private int helper(int[] arr, int[][] dp, int i, int j)
    {
        if((j-i)<0) return 0;
        if(dp[i][j]>0) return dp[i][j];

        for(int x=i; x<=j; x++)
        {
            dp[i][j] = Math.max(dp[i][j], helper(arr,dp,i,x-1) + arr[i-1]*arr[x] * arr[j+1] + helper(arr,dp,x+1,j));
        }
        return dp[i][j];
    }
	

}
