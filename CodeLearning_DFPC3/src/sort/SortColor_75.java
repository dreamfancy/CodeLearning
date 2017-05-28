package sort;

public class SortColor_75 {

	//Another solution is to just user three counters to count number of occurence of 0, 1 and 2.
	
	
	//If one method is referred more than one time. pleasee attention to parameter's initialization
	public static void sortColors(int[] nums)
	{
		int start=0, end=nums.length-1;
		int mid = quickSortColor(nums,start, end, 1);
		
		int first = 0;
		if(mid>=0 && mid<=nums.length-1) 
		{
			quickSortColor(nums,first, mid, 0);
		}
	}
	
	/*
	 * while(left<=right)
	 * {
	 * 	if(array[left]==0) left++;
	 *  else if(array[right]==1 right--;
	 *  else swap
	 *  }
	 */
	
	
	
	public static int quickSortColor(int[] nums,int start, int end, int i)
	{
	    if(start<0 || end>nums.length-1) return -1;
	   	if(start>=end) return start;
		while(start<=end)
		{
			while(start<=end && nums[start]<=i) start++;
			while(start<=end && nums[end]>i) end--;
			
			if(start<=end) 
			{
				swap(nums,start,end);
				start++;
				end--;
			}
		}
		return end;
	}
	
	//The solution of while loop is shown as above. But we can also use if else to resolve this problem
	// if nums[start]>i && nums[end]<=i{swap} else if(nums[start]<=i) start++; else end--;
	
	public static void swap(int[] nums, int first, int second)
	{
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}
}
