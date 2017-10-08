package leetcode1to50;

import java.util.Arrays;

public class ThreeSumClosest_16 {
	
	//My solution: Better than LC official solution Thanks for the hard work!
    public int threeSumClosest(int[] nums, int target) 
    {
        if(nums==null || nums.length==0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length==2)
        {
            return nums[0] + nums[1];
        }
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        
        for(int i=0; i<nums.length-2; i++)
        {
            closest = closestOfTwo(nums,i+1,nums[i],closest,target);
            if(closest==target) return target;
        }
        
        return closest;
    }
    
    public int closestOfTwo(int[] nums, int left, int cur, int closest, int target)
    {
        int right = nums.length-1;
        
        while(left<right)
        {
            int sum = nums[left]+nums[right] + cur;
            if( sum == target) return target;
            else if(sum < target)
            {
                if(Math.abs(closest-target)>= (target-sum)) closest = sum;
                left++;
            }
            else
            {
                if(Math.abs(closest-target)>=(sum-target)) closest = sum;
                right--;   
            }
        }
        return closest;
    }
}
