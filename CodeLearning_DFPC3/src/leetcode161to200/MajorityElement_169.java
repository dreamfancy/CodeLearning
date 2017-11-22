package leetcode161to200;

import java.util.Arrays;

public class MajorityElement_169 
{
	
	//Sol 3:http://blog.csdn.net/kimixuchen/article/details/52787307
	public int majorityElement_3(int[] nums)
	{
		int count = 0;
		Integer candidate = null;
		
		for(int num: nums)
		{
			if(count==0)
			{
				candidate = num;
			}
			count += (num==candidate)? 1: -1;
		}
		return candidate;
	}
	
	//Sol 1: Sort
    public int majorityElement(int[] nums) 
    {
        if(nums==null) return 0;    
        if(nums.length==1) return nums[0];
        Arrays.sort(nums);
        return nums[(nums.length-1)/2];
    }

    //Sol 2: Divide and Conquer
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement_2(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
}
