package first100;

public class RemoveElements_27 
{
    public int removeElement(int[] nums, int val) 
    {
    	if(nums==null || nums.length==0) return 0;
    	
    	int slow = 0;
    	int fast = 0;
    	
    	while(fast!=nums.length)
    	{
    		if(nums[fast]!=val)
    		{
    			nums[slow++] = nums[fast];
    		}
    		fast++;
    	}
    	//if(slow==0) return 0; this is removed as included in the final return
    	return slow;
    }

}
