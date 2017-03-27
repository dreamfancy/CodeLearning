package binarysearch;


//When reviewing the binary search, please try to use while(first<=last) to resolve this issue(Solution 3)
public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) 
    {
    	if(nums==null || nums.length==0) return -1;
    	if(nums.length==1) return nums[0];
    	
    	int first = 0;
    	int last = nums.length-1;
    	
    	int mid;
    	
    	while(first+1<last)
    	{
    		mid = first + (last-first)/2;
    		if(nums[mid]>nums[mid-1])
    		{
    			first=mid;
    		}
    		else
    		{
    			last = mid;
    		}
    	}
    	if(nums[first]<nums[last] && last ==nums.length-1) return last;
    	else if (nums[first]<nums[last] && nums[last]>nums[last+1]) return last;
    	else if (nums[first]>nums[last] && first == 0) return first;
    	else if (nums[first]>nums[last] && nums[first]>nums[first-1]) return first;
    	
    	return -1;
    }

}
