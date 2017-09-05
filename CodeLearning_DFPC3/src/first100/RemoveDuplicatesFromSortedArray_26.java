package first100;

public class RemoveDuplicatesFromSortedArray_26 
{
    public int removeDuplicates(int[] nums) 
    {
    	if(nums==null || nums.length==0) return 0;
    	if(nums.length==1) return 1;
    	int slow=1, fast=1;
    	while(fast!=nums.length)
    	{
    		if(nums[fast]!=nums[fast-1])
    		{
    			nums[slow++] = nums[fast];
    		}
    		fast++;
    	}
    	return slow;
    }


}
