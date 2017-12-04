package leetcode201to250;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicate_3_220 
{
	//Sol 3: A much more readable solution 2
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
	
	
	
	//sol 2: Bucket map Attention when nums[i] is negative 
    private long getID(long x, long w)
    {
    	if(x>=0) return x/w;
    	
    	return (x+1)/w-1;
    }
	
	
	public boolean containsNearbyAlmostDuplicate__2(int[] nums, int k, int t) 
    {
    	if(t<0) return false;
    	Map<Long,Long> hash = new HashMap<Long,Long>();
    	long w = (long)t + 1;
    	for(int i=0; i<nums.length; i++)
    	{
    		long m = getID(nums[i],w);
    		if(hash.containsKey(m)) return true;
    		if(hash.containsKey(m-1)&& Math.abs(hash.get(m-1)-nums[i])<w)
    			return true;
    		if(hash.containsKey(m+1)&& Math.abs(hash.get(m+1)-nums[i])<w)
    			return true;
    		hash.put(m, (long)nums[i]);
    		if(i>=k)  hash.remove(getID(nums[i-k],w));
    	}
    	return false;
    }
	
	//Sol 1: Use TreeSet ceiling floor to limit the diff
    public boolean containsNearbyAlmostDuplicate_1(int[] nums, int k, int t) 
    {
        if(nums==null || nums.length==0) return false;
        TreeSet<Integer> treeset = new TreeSet<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            Integer nearabove = treeset.ceiling(nums[i]);  //return can be null so please use integer here as declaration type!!!
            if(nearabove!=null && nums[i]+t>=nearabove) return true;
            
            Integer nearbelow = treeset.floor(nums[i]);
            if(nearbelow!=null && nearbelow+t>=nums[i]) return true;
        }
        return false;
    }

}
