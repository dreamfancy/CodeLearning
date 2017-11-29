package leetcode201to250;

public class MinimumSizSubArraySum_209 
{
	   public int minSubArrayLen(int s, int[] nums) 
	    {
	        if(nums==null || nums.length==0) return 0;
	        int n = nums.length;
	        if(nums[0]>=s) return 1;
	        int slow = 0;
	        int fast = 0;
	        int sum = 0;
	        int curmin = Integer.MAX_VALUE;
	        while(fast<n)
	        {
	            while(fast<n && sum<s)
	            {
	                sum += nums[fast];
	                fast++;
	            }
	            if(sum>=s) curmin = Math.min(curmin,fast-slow);
	       
	            while(slow<(fast-1) && sum>=s)
	            {
	                sum -= nums[slow];
	                ++slow;
	                if(sum>=s) curmin = Math.min(curmin,fast-slow);
	            }
	            if(curmin == 1) return 1;
	        }
	        return curmin==Integer.MAX_VALUE ? 0:curmin;  
	    }
}
