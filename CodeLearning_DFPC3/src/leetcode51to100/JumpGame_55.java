package leetcode51to100;

public class JumpGame_55 
{
    public boolean canJump(int[] nums) 
    {
        if(nums==null || nums.length<=1) return true;
        int cur = 0;
        int curMax = 0;
        
        while(cur<=curMax)   //Greedy!!! curMax is changed in the whileloop
        {
            if(cur>=nums.length-1) return true;
            int val = nums[cur] + cur;
            curMax = Math.max(curMax,val);
            cur++;
        }
        
        if(curMax>=nums.length-1) return true;
        return false;
        
    }

}
