package bitoperation;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate_2_219 {

	  //My Solution 1: No extra space but time complexity O( )
	  public boolean containsNearbyDuplicate(int[] nums, int k) 
	  {
		  if(nums==null || nums.length<2) return false;
		  for(int i=1; i<=k; i++)
		  {
		  	for(int j=0; j+i<nums.length;j++)
		    {
		    	if(nums[j]==nums[j+i]) return true;
		    }
		  }
		  return false;
	  }
	  
	  //My Solution 2:
	  public boolean containsNearbyDuplicate_2(int[] nums, int k) 
	  {
		  if(nums==null || nums.length<=1) return false;
		  Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
		  
		  for(int i=0; i<nums.length; i++)
		  {
			  if(hash.containsKey(nums[i]) && (i-hash.get(nums[i]))<=k) return true;
			  hash.put(nums[i], i); 		  
		  }
		  return false;
	  }

}
