package leetcode201to250;

public class MinimumSizSubArraySum_209 
{
	
	//Sol 2: Binary Search
    public int minSubArrayLen_2(int s, int[] nums) {
        return solveNLogN(s, nums);
    }
    /*
    //two pointer
    private int solveN(int s, int[] nums) {
        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (end < nums.length) {
            while (end < nums.length && sum < s) sum += nums[end++];
            if (sum < s) break;
            while (start < end && sum >= s) sum -= nums[start++];
            if (end - start + 1 < minLen) minLen = end - start + 1;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
     */
    
    //binary search
    private int solveNLogN(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    private int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
           int mid = (lo + hi) / 2;
           if (sums[mid] >= key){
               hi = mid - 1;
           } else {
               lo = mid + 1;
           }
        }
        return lo;
    }
	
	
	
	
   // Sol 1: My Sol: Binary Search 	
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
