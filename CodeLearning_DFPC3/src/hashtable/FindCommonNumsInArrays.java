package hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindCommonNumsInArrays {

	
	public List<Integer> findCommonNumsInArrays(int[] arr1, int[] arr2)
	{
		if(arr1==null || arr1.length==0 || arr2==null || arr2.length==0 ) return new ArrayList<Integer>();
		if(arr1.length>arr2.length)  return findCommonNumsInArrays(arr2,arr1); //For Optimization Of Time Complexity!!!
		List<Integer> resultArray = new ArrayList<Integer>();
		HashSet<Integer> hash = new HashSet<Integer>();
		for(int i: arr1)
		{
			hash.add(i);
		}
		for(int j: arr2)
		{
			if(hash.contains(j))
				resultArray.add(j);
		}
		return resultArray;
	}
}
