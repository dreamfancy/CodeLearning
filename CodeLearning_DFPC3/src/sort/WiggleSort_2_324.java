//Please visit this question a second time
//There is a second way of resolving the problem
//https://discuss.leetcode.com/topic/32929/o-n-o-1-after-median-virtual-indexing/2


package sort;

import java.util.Arrays;

public class WiggleSort_2_324 {

    public static void wiggleSort(int[] nums) {
    
    	if(nums.length==1 || nums.length==0) return;
    	
    	Arrays.sort(nums);
    	int[] res = new int[nums.length];
    	
    	int firstHalf = (nums.length-1)/2;
    	int secondHalf = nums.length-1;
   
    	for(int k=0; k<nums.length; k++)
    	{
    		res[k] = k%2 == 0? nums[firstHalf--]:nums[secondHalf--];
    	}
    	
    	for(int k=0; k<res.length; k++)
    	{
    		System.out.print(res[k]);
    	}
    }
	
    
    public static void main(String[] args)
    {
    	int[] nums = {1,5,1,1,6,4};
    	wiggleSort(nums);
    }
	
}





//1/2/3/3/3/4/5/6
//1
