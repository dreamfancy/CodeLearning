package bitoperation;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicate_3_220 {
    
	
	//Solution : How to use subSet of treeSet
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
    {
    	if(k<1 || t<0 || nums==null || nums.length<2) return false;
    
    	SortedSet<Long> set = new TreeSet<Long>();
    	
    	for(int i=0; i<nums.length; i++)
    	{
    		//Check the difference ! Why the comment below is wrong
    		//SortedSet<Long> subSet = set.subSet((long)(nums[i]-t), (long)(nums[i]+t));
    		SortedSet<Long> subSet = set.subSet((long)nums[i]-t, (long)nums[i]+t);
    		if(!subSet.isEmpty()) return true;
    		if(i>=k)
    		{
    			set.remove((long)nums[i-k]);
    		}
    		set.add((long)nums[i]);
    	}
    	
    	return false;
    }

}
