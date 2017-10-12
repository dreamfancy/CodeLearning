package leetcode1to50;

public class NextPermutation_31 
{
    public void nextPermutation(int[] nums) 
    {
        if(nums==null || nums.length<=1) return;
        int n = nums.length;
        
        int candidate=0; 
        for(int i=n-2; i>=0; i--)
        {
            if(nums[i]<nums[i+1])
            {
                candidate = i;
                break;
            }
        }
        if(candidate==0 && nums[0]>=nums[1])
        {
            reverse(nums,0,n-1);
            return;
        }
        
        int target=candidate+1;
        for(int j=n-1; j>=0; j--)
        {
            if(nums[j]>nums[candidate])
            {
                target = j;
                break;
            }
        }
        System.out.println(candidate);

        System.out.println(target);
        
        swap(nums,target,candidate);
        reverse(nums,candidate+1,n-1);
    }
    
    public void swap(int[] nums,int target,int candidate)
    {
        int temp = nums[target];  //!!!!! not int temp = target;
        nums[target] = nums[candidate];
        nums[candidate] = temp;
    }
    
    public void reverse(int[] nums,int left, int right)
    {
        System.out.println(left+"  "+right);
        while(left<right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
