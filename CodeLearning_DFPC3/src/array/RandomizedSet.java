package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// O(1) operations: ArrayList can realize O(1) for add get operation, only the remove one needs O(n). 
// Easy solution: Keep a map for the location of element since HashMap get is also O(1). If deletion is needed,
//
public class RandomizedSet {
	
	List<Integer> nums;
	Map<Integer,Integer> locs;
	Random rand;
	
	public RandomizedSet()
	{
		nums = new ArrayList<Integer>();
		locs = new HashMap<Integer,Integer>();
		//Forget to initialize will cause null pointer error!
		rand = new Random();
	}
	
	public boolean insert(int val)
	{
		if(locs.containsKey(val))
		{	
			return false;
		}
		nums.add(val);
		locs.put(val, nums.size()-1);
		return true;
		
	}
	
	public boolean remove(int val)
	{
		if(locs == null || locs.get(val) != null)
		{
			int first = locs.get(val);
			int temp = nums.get(first);
			nums.set(first, nums.get(nums.size()-1));
			locs.put(nums.get(first), first);
			nums.remove(nums.size()-1);
			locs.remove(val);
			return true;
		}
		return false;
	}
	
	public int getRandom()
	{
		if(nums != null)
		{
			if(nums.size()!=0)
			{
				return nums.get(rand.nextInt(nums.size()));	
			}
		}
		return -1;
	}

}

