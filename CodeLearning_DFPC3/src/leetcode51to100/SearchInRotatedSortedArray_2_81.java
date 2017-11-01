package leetcode51to100;

public class SearchInRotatedSortedArray_2_81 {
	
	
	//Standard Solution
	public boolean search_2(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            //If we know for sure left side is sorted or right side is unsorted
            } 
            else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
                
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } 
            else
                end--;
        }
        
        return false;
    }
	
	
	
	//My Solution: Path
	//Attention when nums[start]==nums[mid]
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0) return false;
        
        return search(nums,target,0,nums.length-1);
    }
    
    public boolean search(int[] nums, int target, int start, int end)
    {
        if(start>end) return false;
        if(start==end) return nums[start]==target ? true : false;
        
        int mid = start + (end-start)/2;
        if(nums[mid]==target) return true;
        else if(nums[mid]>target)
        {
            if(nums[start]>nums[mid])
            {
                return search(nums,target,start,mid-1);
            }
            else
            {
                return search(nums,target,start,mid-1) || search(nums,target,mid+1,end);
            }
        }
        else
        {
            if(nums[start]>=nums[mid])
            {
                return search(nums,target,mid+1,end) || search(nums,target,start,mid-1);
            }
            else
            {
                return search(nums,target,mid+1,end);
            }
        }
        
    }
}
