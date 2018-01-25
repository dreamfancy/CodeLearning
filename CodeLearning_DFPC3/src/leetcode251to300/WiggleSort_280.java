package leetcode251to300;

public class WiggleSort_280 
{
    public void wiggleSort(int[] nums) 
    {
        if(nums==null || nums.length<=1) return;
     
        for(int i=0; i<nums.length-1; i++)
        {
            if(i%2==0 && nums[i]>nums[i+1])
            {
                swap(nums,i,i+1);
            }
            else if(i%2==1 && nums[i]<nums[i+1])
            {
                swap(nums,i,i+1);
            }
        }
    }
    
    private void swap(int[] nums, int first, int second)
    {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

}
