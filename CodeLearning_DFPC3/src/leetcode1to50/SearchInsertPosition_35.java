package leetcode1to50;

public class SearchInsertPosition_35 
{
	//my solution 2" while start<end-1
	
    public int searchInsert_2(int[] nums, int target) 
    {
        if(nums==null || nums.length==0) return 0;
        
        int start = 0;
        int end = nums.length-1;
        
        while(start<end-1)
        {
            int mid = start+(end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        if(nums[start]>=target) return start;
        else if(nums[end]>=target) return end;
        
        return end+1;
    }
	
	//My solution 1: while start<=end
    public int searchInsert_1(int[] nums, int target) 
    {
        if(nums==null || nums.length==0) return 0;
        
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        
        return start;
        
    }

}
