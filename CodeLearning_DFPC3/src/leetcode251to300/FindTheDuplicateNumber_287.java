package leetcode251to300;

public class FindTheDuplicateNumber_287 
{
	//Sol 2: LinkedList with Ring 
    public int findDuplicate_2(int[] nums) 
    {
	if (nums.length > 1)
	{
		int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast)
		{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;
		while (fast != slow)
		{
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
	}
	return -1;
    }
	
	//Sol 1: Use +- of the array element to represent index-number relations
    public int findDuplicate_1(int[] nums) 
    {
        if(nums==null || nums.length<=1) return -1;
        int n = nums.length-1;
        
        int result = -1;
        for(int i=0; i<=n; i++)
        {
            if(nums[Math.abs(nums[i])-1]<0)
            {
                result = Math.abs(nums[i]);
                break;
            }    
            nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
        }
        
        for(int j=0; j<=n; j++)
        {
            if(nums[j]<0)
            {
                nums[j] = -nums[j];
            }
        }
        return result;
    }	

}
