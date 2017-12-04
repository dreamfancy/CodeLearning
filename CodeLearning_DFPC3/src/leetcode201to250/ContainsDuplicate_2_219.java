package leetcode201to250;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate_2_219 
{
	//sol 3:HashMap to keep records
	public boolean containsNearbyDuplicate(int[] nums, int k)
	{
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<nums.length; i++)
		{
			if(map.containsKey(nums[i]))
			{
				if(i-map.get(nums[i])<=k) return true;
			}
			map.put(nums[i],i);
		}
		return false;
	}
	
	
	//Sol 2: make the special parts inside one forloop
	public boolean containsNearbyDuplicate_2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
 }
	
	
	//Sol 1: My Solution
    public boolean containsNearbyDuplicate_1(int[] nums, int k) 
    {
        if(nums==null || nums.length==0) return false;
        if(k==0) return false;
        
        Set<Integer> hash = new HashSet<Integer>();
        
        for(int i=0; i<(k+1) && i<nums.length; i++)
        {
            if(!hash.add(nums[i])) return true;
        }
        
        for(int i=0; (i+k+1)<nums.length; i++)
        {
            hash.remove(new Integer(nums[i]));
            if(!hash.add(nums[i+k+1])) return true;        
        }
        return false;
    }
	
}
