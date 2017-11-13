package leetcode101to130;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence_128 {
    
	//Sol 2: use treeset sequence
    public int longestConsecutive_2(int[] nums) 
    {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return 1;
    
        Set<Integer> treeset = new TreeSet<Integer>();
        for(int num: nums)
        {
            treeset.add(num);
        }
        
        Iterator<Integer> iter = treeset.iterator();
        int count = 1;
        int max = 0;
        int pre = Integer.MIN_VALUE;
        while(iter.hasNext())
        {
            int cur = iter.next();
            if(cur==pre+1)
            {
                count++;
            }
            else
            {
                max = Math.max(max,count);
                count = 1;
            }
            pre = cur;

        }
        max = Math.max(max,count);

        return max;
    }
	
	
	
	//Official Solution 1: use hashset.contains()
	public int longestConsecutive(int[] nums) 
    {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return 1;
    
        Set<Integer> hashset = new HashSet<Integer>();
        for(int num: nums)
        {
            hashset.add(num);
        }
        
        int longest = 0;
        
        for(int num: hashset)
        {
            if(!hashset.contains(num-1))
            {
                int current = num;
                int currentstreak = 1;
                
                while(hashset.contains(current+1))
                {
                    current += 1;
                    currentstreak += 1;
                }
                longest = Math.max(currentstreak,longest);
            }
        }
        return longest;
    }
}
