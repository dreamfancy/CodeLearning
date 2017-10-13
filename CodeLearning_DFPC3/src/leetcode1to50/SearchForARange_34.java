package leetcode1to50;

public class SearchForARange_34 
{
	
	//Solution 2:
	//Combination of find first matching elment and find last matching element
	public int[] searchRange_2(int[] nums, int target) {
	    int[] result = new int[2];
	    result[0] = findFirst(nums, target);
	    result[1] = findLast(nums, target);
	    return result;
	}

	private int findFirst(int[] nums, int target){
	    int idx = -1;
	    int start = 0;
	    int end = nums.length - 1;
	    while(start <= end){
	        int mid = (start + end) / 2;
	        if(nums[mid] >= target){
	            end = mid - 1;
	        }else{
	            start = mid + 1;
	        }
	        if(nums[mid] == target) idx = mid;
	    }
	    return idx;
	}

	private int findLast(int[] nums, int target){
	    int idx = -1;
	    int start = 0;
	    int end = nums.length - 1;
	    while(start <= end){
	        int mid = (start + end) / 2;
	        if(nums[mid] <= target){
	            start = mid + 1;
	        }else{
	            end = mid - 1;
	        }
	        if(nums[mid] == target) idx = mid;
	    }
	    return idx;
	}
	
	
	//My solution 1: two direction expand after finding the first element
    public int[] searchRange_1(int[] nums, int target) 
    {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;
        
        if(nums==null || nums.length==0) return range;
        
        int start = 0;
        int end = nums.length-1;
        
        while(start<end-1)
        {
            int mid = start + (end-start)/2;
            
            if(nums[mid]==target)
            {
                System.out.println("I am here");
                findRange(nums,mid,range);
                return range;
            }
            else if(nums[mid]<target)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        
        if(nums[start]==target && nums[end]==target)
        {
            range[0] = start;
            range[1] = end;
        }
        else if(nums[start]!=target && nums[end]==target)
        {
            range[0] = end;
            range[1] = end;
        }
        else if(nums[start]==target && nums[end]!=target)
        {
            range[0] = start;
            range[1] = start;
        }
        
        return range;
    }
    
    public void findRange(int[] nums, int p, int[] range)
    {
        int left = p;
        int right = p;
                
        while(left>=0 && nums[left]==nums[p]) left--;
        left++;
        while(right<=(nums.length-1) && nums[right]==nums[p]) right++;
        right--;
        range[0] = left;
        range[1] = right;
            
    }

}
