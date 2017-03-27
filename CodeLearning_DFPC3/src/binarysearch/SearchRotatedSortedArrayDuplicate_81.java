package binarysearch;

public class SearchRotatedSortedArrayDuplicate_81 {

	//Attention the scenario that A Lot of values are same except one is not, which is target.
	//At this time you cannot use mid, you can only delete one value from first or last to shrink gradually
    public boolean search(int[] nums, int target) {
        
    	if(nums==null || nums.length==0) return false;
    	if(nums.length==1) return (nums[0]==target)?true:false;
    	
    	int first=0,last=nums.length-1;
    	
    	if(nums[first]<nums[last]) return binarySearch(nums,first,last,target);
    	int mid;
    	if(target>=nums[first])
    	{
    		while(first+1<last)
    		{
    			mid = first + (last-first)/2;
    			if(nums[mid] == nums[first]) first = first+1;
    			else if(nums[mid]>=target) 
    				return binarySearch(nums,first,mid,target);
    			else if (nums[mid]<target && nums[mid]>nums[first])
    				first = mid;
    			else if(nums[mid]<=nums[last])
    				last = mid;
    			else if(nums[mid]<nums[first] && nums[mid]>nums[last]) 
    			    return false;
    		}
    		if(nums[first]==target) return true;
    		else if(nums[last]==target) return true;
    	}
    	
    	if(target<=nums[last])
    	{    	

    		while(first+1<last)
    		{
    			mid = first + (last-first)/2;
    			
    			if(nums[mid] == nums[last]) last = last-1;
    			else if(nums[mid]<=target) 
    				return binarySearch(nums,mid,last,target);
    			else if (nums[mid]>target && nums[mid]<nums[last])
    				last = mid;
    			else if(nums[mid]>=nums[first])
    				first = mid;
    			else if(nums[mid]<nums[first] && nums[mid]>nums[last]) return false;
    		}
    		if(nums[first]==target) return true;
    		else if(nums[last]==target) return true;
    	}
    	
    	
    	return false;
    }
	
    public boolean binarySearch(int[] nums,int start,int end,int value)
    {
    	int mid;
    	while(start+1<end)
    	{
    		mid = start + (end-start)/2;
    		if(nums[mid]==value) return true;
    		else if(nums[mid]<value) start = mid;
    		else if(nums[mid]>value) end = mid;
    	}
    	
    	if(nums[start] == value) return true;
    	if(nums[end] == value) return true;
    	
    	return false;
    }
}
