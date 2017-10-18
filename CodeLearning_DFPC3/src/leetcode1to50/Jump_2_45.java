package leetcode1to50;

public class Jump_2_45 {
    
	
	public int jump(int[] nums) 
    {
        if(nums==null || nums.length<=1) return 0;
        
        int last = nums.length-1;
        int count = 0;
        int start = 0;
        int end = 0;
        while(end<last)
        {
            int curmax = end;
            for(int i=start; i<=end; i++)
            {
                curmax = Math.max(curmax, nums[i]+i);
            }
            start = end+1;
            end = curmax;            
            count++;
        } 
        return count;
    }
}
