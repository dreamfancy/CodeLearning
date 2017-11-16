package leetcode131to160;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        
        if(nums==null || nums.length==0) return -1;
        
        int sum = 0;
        
        for(int x: nums)
        {
            sum ^= x;
        }
        return sum;
    }
}
