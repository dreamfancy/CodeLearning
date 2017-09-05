package first100;

public class RemoveDuplicatesFromSortedArray_26 
{
	//My Solution:
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
    
    //Similar To My Solution but treat i=0 as one condition of if
    public int removeDuplicates_2(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (right == 0 || nums[right] != nums[right-1]) {
                nums[left++] = nums[right];
            }
            right++;
        }
        return left;
    }


}
