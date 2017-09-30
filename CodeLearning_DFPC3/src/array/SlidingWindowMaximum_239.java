package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum_239 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
    	if(k<=0) return null;
    	int n = nums.length;
    	if(nums==null || nums.length==0) return new int[0];
    	
    	int[] result = new int[n-k+1];
    	int ri = 0;
    	
    	Deque<Integer> deque = new ArrayDeque<Integer>();
    	
    	for(int i=0; i<n; i++)
    	{
    		while(!deque.isEmpty() && deque.peek()<i-k+1)
    		{
    			deque.poll();
    		}
    		
    		while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i])
    		{
    			deque.pollLast();
    		}
    		deque.offer(i);
    		if(i>=k-1)
    		{
    			result[ri++] = nums[deque.peek()];
    		}
    	}
    	
    	return result;
    	
    	
        
    }
}
