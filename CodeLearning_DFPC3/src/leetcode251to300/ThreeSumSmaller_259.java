package leetcode251to300;

import java.util.Arrays;

public class ThreeSumSmaller_259 
{
    public int threeSumSmaller(int[] nums, int target) 
    {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0]<target ? 1:0;
        
        Arrays.sort(nums);        
        int count = 0;
        for(int right=nums.length-1; right>=2; right--)
        {
            int left = 0, mid = right-1;
            while(left<mid)
            {
                if(nums[left]+nums[mid]+nums[right]<target)
                {
                    count += mid-left;
                    left++;
                }
                else
                {
                    mid--;
                }
            }
        }
        return count;
    }
}
