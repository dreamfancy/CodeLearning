package leetcode131to160;

public class FindMinimumInRotatedSortedArray_153 
{
	//To find the change point! do not do mid+1 or mid-1s
    public int findMin(int[] nums) 
    {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int left=0, right=nums.length-1;
        if(nums[left]<nums[right]) return nums[left];

        
        while(left<right-1)
        {
            int mid = left + (right-left)/2;
            if(nums[mid]<nums[left])
            {
                right = mid;
            }
            else
            {
                left = mid;
            }
        }
        
        return Math.min(nums[left],nums[right]);
    }

}
