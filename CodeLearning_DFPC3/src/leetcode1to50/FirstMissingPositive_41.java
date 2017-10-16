package leetcode1to50;

public class FirstMissingPositive_41 
{
    public int firstMissingPositive(int[] nums) 
    {
        if(nums==null || nums.length==0) return 1;

        int left = 0;
        int right = nums.length-1;
        
        while(left<=right)
        {
            while(left<=right && nums[left]>0) left++;
            while(left<=right && nums[right]<=0) right--;
            if(left<=right)
                swap(nums,left,right);
        }
        
        for(int i=0; i<=right; i++)
        {
            System.out.print(nums[i] +" ");
            System.out.println();
        }
        //Up to this step, all the positive number are from 0->right
        //Maximum positive number is right+2;
        
        System.out.println("current right is " + right);
       
        int p=0;
        while(p<=right)
        {
            int cur = nums[p];
            if(cur>=right+2) 
            {
                p++;
                continue;
            }
        
            if((p!=cur-1) && nums[p]!=nums[cur-1])
            {
                swap(nums,p,cur-1);
            }
            else p++;
        }
        for(int i=0; i<=right; i++)
        {
            System.out.print(nums[i] +" ");
            System.out.println();
        }
        //if(flag==false) return (right+2);
        for(int j=0; j<=right; j++)
        {
            if(nums[j]!=(j+1))
                return j+1;
        }
        return right+2;
    }
    
    public void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
