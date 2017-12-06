package leetcode201to250;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class SlidingWindowMaximum_239 
{
	//Sol 2: Can we move more steps one time that will speed up the process
    public int[] maxSlidingWindow_2(int[] nums, int k) 
    {
        if(nums==null || nums.length<=0) return new int[0];
        int len = nums.length;
        int[] result = new int[len-k+1]; 
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
    	
        for(int i=0; i<len; i++)
        {
        	if(!q.isEmpty() &&  q.peek()<i-k+1)
        		q.poll();
        	while(!q.isEmpty() && nums[q.peekLast()]<nums[i])
        		q.pollLast();
        	q.offer(i);
        	if(i>=k-1)
        	{
        		result[ri++] = nums[q.peek()];
        	}
        }
        return result;
    }
	
	//Sol 1: Move one step each time
    public int[] maxSlidingWindow_1(int[] nums, int k) 
    {
        if(nums==null || nums.length==0) return new int[0];
        int len = nums.length;
        int[] result = new int[len-k+1];
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for(int i=0; i<k; i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
            {
                map.put(nums[i],1);
            }
            result[0] = map.lastKey();
        }
        for(int j=k; j<len; j++)
        {
            map.put(nums[j-k],map.get(nums[j-k])-1);
            if(map.get(nums[j-k])==0) map.remove(nums[j-k]);
            if(map.containsKey(nums[j]))
            {
                map.put(nums[j],map.get(nums[j])+1);
            }
            else
            {
                map.put(nums[j],1);
            }
            result[j-k+1] = map.lastKey();
        }
        return result;
    }
}
