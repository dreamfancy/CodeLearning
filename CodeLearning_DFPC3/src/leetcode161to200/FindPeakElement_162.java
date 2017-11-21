package leetcode161to200;

public class FindPeakElement_162 
{
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        
        int len = nums.length;
        int start = nums[0];
        int end =   nums[len-1];
        
        while(start<end-1)
        {
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[mid-1])
                start = mid;
            else end = mid;
        }
        
        return Math.max(nums[start],nums[end]);
    }

}
