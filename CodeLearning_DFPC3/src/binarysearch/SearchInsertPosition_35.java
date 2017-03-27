package binarysearch;

public class SearchInsertPosition_35 {
    
	public int searchInsert_1(int[] nums, int target) 
	{
    
		if(nums==null || nums.length==0) return -1;
    
	    int start=0, end=nums.length-1;
	    int mid;
	    while(start<=end)
	    {
	    	mid=start + (end-start)/2;
	    	if(nums[mid]<target)
	    	{
	    		start = mid+1;
	    	}
	    	else if(nums[mid]>target)
	    	{
	    		end = mid-1;
	    	}
	    	else
	    		return mid-1;
	    }
	    
	   
	    return start;
	}
	
	
	public int searchInsert_2(int[] nums, int target) 
	{
    
		if(nums==null || nums.length==0) return -1;
		if(nums.length==1 && nums[0]<target) return 1;
		else if(nums.length==1 && nums[0]>=target) return 0;
		
	    int start=0, end=nums.length-1;
	    int mid;
	    while(start+1<end)
	    {
	    	mid=start + (end-start)/2;
	    	if(nums[mid]<target)
	    	{
	    		start = mid;
	    	}
	    	else if(nums[mid]>target)
	    	{
	    		end = mid;
	    	}
	    }
		if(nums[start]>=target) return start;
		else if(nums[end]>=target) return end;
		else return end+1;
		
	}

}
