package bitoperation;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {

    public boolean containsDuplicate(int[] nums) 
    {
    	if(nums==null || nums.length<=1) return false;
    	
    	Set<Integer> hash = new HashSet<Integer>();
    	
    	for(int i: nums)
    	{
    		if(hash.contains(i)) return true;
    		hash.add(i);
    	}
    	return false;
    }
 
}
