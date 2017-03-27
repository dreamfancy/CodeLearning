package binarysearch;

public class SearchForARange_34 {

    public static int[] searchRange(int[] nums, int target) 
    {
    	
    	if(nums==null ||nums.length==0) return new int[]{-1,-1};;
    	int start = 0, end = nums.length-1;
    	int mid=0;
    	while(start<=end)
    	{
    		mid = start + (end-start)/2;
    		if(nums[mid]<target)
    		{
    			start = mid+1;
    		}
    		else if(nums[mid]>target)
    		{
    			end = mid-1;
    		}
    		else if(nums[mid]==target)
    		{
    			break;
    		}
    	}
    	if(start>end) return new int[]{-1,-1};
    
    	int first,second;
    	int mid1=mid,mid2=mid;
    	while(start<=mid1)
    	{
    		int cp = start+(mid1-start)/2;
    		if(nums[cp]==nums[mid]) mid1 = cp-1;
    		else if(nums[cp]<nums[mid]) start = cp+1;
    	}
    
    	while(mid2<=end)
    	{
    		int cp = mid2+(end-mid2)/2;
    		if(nums[cp]==nums[mid]) mid2 = cp+1;
    		else if(nums[cp]>nums[mid]) end = cp-1;
    	}
    	
    	return new int[]{start,end};
    }
} 
