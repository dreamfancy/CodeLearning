package leetcode201to250;

public class HouseRobber_2_213 
{
	//Sol 1: My solution
	//Whether to keep the first element cause two possibilities
    public int rob(int[] nums) 
    {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        int[] dp = new int[nums.length];
        
        //select the first
        dp[0] = nums[0];
        dp[1] = nums[0];
        for(int i=2; i<nums.length-1; i++)
        {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        int result1 = dp[nums.length-2];
        
        dp[0] = 0;
        dp[1] = nums[1];
        for(int i=2; i<nums.length; i++)
        {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        int result2 = dp[nums.length-1];
        
        return Math.max(result1,result2);
    }
    
    //Sol 2: Looks better
    public int rob_2(int[] nums) 
    {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }

}
