package binarysearch;

public class SearchRotatedSortedArray_33 {

	//Attention Difference:
	//first<last !!!Wrong! It should be nums[first]<nums[last];
    public int search(int[] nums, int target) {
        
    	if(nums==null || nums.length==0) return -1;
    	if(nums.length==1) return (nums[0]==target)?0:-1;
    	
    	int first=0,last=nums.length-1;
    	
    	if(nums[first]<nums[last]) return binarySearch(nums,first,last,target);
    	int mid;
    	if(target>=nums[first])
    	{
    		while(first+1<last)
    		{
    			mid = first + (last-first)/2;
    			if(nums[mid]>=target) 
    				return binarySearch(nums,first,mid,target);
    			else if (nums[mid]<target && nums[mid]>=nums[first])
    				first = mid;
    			else if(nums[mid]<=nums[first])
    				last = mid-1;
    		}
    		if(nums[first]==target) return first;
    		else if(nums[last]==target) return last;
    	}
    	
    	if(target<=nums[last])
    	{    	

    		while(first+1<last)
    		{
    			mid = first + (last-first)/2;
    			if(nums[mid]<=target) 
    				return binarySearch(nums,mid,last,target);
    			else if (nums[mid]>target && nums[mid]<=nums[last])
    				last = mid;
    			else if(nums[mid]>=nums[first])
    				first = mid;
    		}
    		if(nums[first]==target) return first;
    		else if(nums[last]==target) return last;
    	}
    	
    	
    	return -1;
    }
	
    public int binarySearch(int[] nums,int start,int end,int value)
    {
    	int mid;
    	while(start+1<end)
    	{
    		mid = start + (end-start)/2;
    		if(nums[mid]==value) return mid;
    		else if(nums[mid]<value) start = mid;
    		else if(nums[mid]>value) end = mid;
    	}
    	
    	if(nums[start] == value) return start;
    	if(nums[end] == value) return end;
    	
    	return -1;
    }
	
}
