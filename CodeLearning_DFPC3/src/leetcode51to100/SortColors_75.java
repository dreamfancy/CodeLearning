package leetcode51to100;

public class SortColors_75 
{
	//Official Solution 1:
	//0 as startpointer, 2 as endpointer. 1 is in middle
    public void sortColors_2(int[] nums) {
        if(nums==null || nums.length<=1) return;
        
        int left = 0;
        int right = nums.length-1;
	
        for(int i=0; i<right; i++)
        {
        	while(nums[i]==2 && i<right) swap(nums,i,right--);
        	while(nums[i]==0 && i>left) swap(nums,i,left++);
        }
	
    }
	
	
	//My Solution: Sort two times for three values
    public void sortColors_1(int[] nums) {
        if(nums==null || nums.length<=1) return;
        
        int left = 0;
        int right = nums.length-1;
        
        while(left<right)
        {
            if(nums[left]==0) left++;
            else if(nums[right]!=0)right--;
            else
            {
                swap(nums,left,right);
                left++;
                right--;
            }
        }  
        if(nums[left]==0) left = left+1;
        right = nums.length-1;
        
        while(left<right)
        {
            if(nums[left]==1) left++;
            else if(nums[right]==2)right--;
            else
            {
                swap(nums,left,right);
                left++;
                right--;
            }
        }
    }
    
    public void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
