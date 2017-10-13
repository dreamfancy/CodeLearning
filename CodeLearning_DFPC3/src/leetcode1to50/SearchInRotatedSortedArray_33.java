package leetcode1to50;

public class SearchInRotatedSortedArray_33 
{
	//official soltuion
	//"Combine" the binary search
	public int search_2(int[] A, int target) {
	    int lo = 0;
	    int hi = A.length - 1;
	    while (lo < hi) {
	        int mid = (lo + hi) / 2;
	        if (A[mid] == target) return mid;
	        
	        if (A[lo] <= A[mid]) {
	            if (target >= A[lo] && target < A[mid]) {
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        } else {
	            if (target > A[mid] && target <= A[hi]) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	    }
	    return A[lo] == target ? lo : -1;
	}
	
	//My solution: Formalized solution!
	//good
    public int search(int[] nums, int target)
    {
        if(nums==null || nums.length==0) return -1;
        return search(nums,0,nums.length-1,target);
    }
    
    public int search(int[] nums, int start, int end, int target)
    {
        if(start==end)
        {
            return nums[start]==target ? start:-1;
        }
        if(nums[start]<nums[end])
        {
            return binarysearch(nums,start,end,target);
        }
        
        int mid = start + (end-start)/2;
        
        if(nums[mid]==target) return mid;
        
        if(nums[mid]>=nums[start])
        {
            if(target>=nums[start] && target<=nums[mid])
            {
                return binarysearch(nums,start,mid,target);
            }
            else
            {
                return search(nums,mid+1,end,target);
            }
        }
        else
        {
            if(target<nums[start] && target>nums[mid])
            {
                return binarysearch(nums,mid,end,target);
            }
            else
            {
                return search(nums,start,mid,target);
            }
        }
    }
    
    public int binarysearch(int[] nums, int start, int end, int target)
    {
        while(start<end-1)
        {
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target)
            {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        if(nums[start]==target) return start;
        else if(nums[end]==target) return end;
        
        return -1;
    }

}
