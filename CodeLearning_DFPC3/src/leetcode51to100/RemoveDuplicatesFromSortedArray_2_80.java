package leetcode51to100;

public class RemoveDuplicatesFromSortedArray_2_80 {
	
	//Solution 3: Revisit! If the number is k:
	
	public int removeDuplicates(int[] nums,int k) 
	{
		if(nums==null || nums.length==0) return 0;
		int n = nums.length;
		if(n<=k) return n;
		
		int slow = 1;
		int fast = 1;
		int count = 1;
		while(fast<n)
		{
			if(nums[fast]!=nums[fast-1])
			{
				count = 1;
				nums[slow++] = nums[fast];
			}
			else
			{
				if(count<k)
				{
					nums[slow++] = nums[fast];
					count++;
				}
			}
			fast++;
		}
		
		return slow;
	}

	
	
	
	//My Solution 2: Use the feature of sorted array
	public int removeDuplicates_2(int[] nums) {
		   int i = 0;
		   for (int n : nums)
		      if (i < 2 || n > nums[i - 2])
		         nums[i++] = n;
		   return i;
		}
	
	//My Solution 1:
    public int removeDuplicate_1(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length<3) return nums.length;
        int slow = 0;
        int fast = 0;
        
        int count = 0;
        while(fast<nums.length-2)
        {
            if(nums[fast]!=nums[fast+1] || nums[fast]!=nums[fast+2])
            {
                nums[slow++] = nums[fast++];
                count++;
            }
            else
            {
                fast++;
            }
        }
        
        nums[slow++] = nums[nums.length-2];
        nums[slow++] = nums[nums.length-1];
        count += 2;
        return count;        
    }
}
