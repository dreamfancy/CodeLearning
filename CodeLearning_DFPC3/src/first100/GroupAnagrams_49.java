package first100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
	
	//To use the containsKey() in hashMap, equal method should be implemented.
	// So instead of Array int[] ...  we can use API such as List<Integer>...
	//It does implement the equals method for compare
	
	//To sort the list, we can use Collections.sort(List<T> list)  Collecitons.reverse(List<T> list)
	
	//Two ways to convert char array to String
	// String text = String.valueOf(data);
	// String text = new String 
	
    public List<List<String>> groupAnagrams(String[] strs) 
    {
    	List<List<String>> result = new ArrayList<List<String>>();
    	if(strs==null || strs.length==0) return result;
    	Map<String, List<String>> hash = new HashMap<String, List<String>>();
    	
    	for(String c: strs)
    	{
    		char[] cArray = c.toCharArray();
    		Arrays.sort(cArray);
    		String pattern = new String(cArray);
    		System.out.println("pattern 1 : " + pattern);
    		
    		String pattern2 = String.valueOf(cArray);
    		System.out.println("pattern 2 : " + pattern2);
    				
    		if(hash.containsKey(pattern))
    		{
    			hash.get(pattern).add(c);
    		}
    		else
    		{
    			List<String> newList = new ArrayList<String>();
    			newList.add(c);
    			hash.put(pattern, newList);
    		}
    	}
    	
    	Iterator<String> iter = hash.keySet().iterator();
    	while(iter.hasNext())
    	{
    		String key = iter.next();
    		List<String> list = hash.get(key);
    		result.add(list);
    	}
    	
    	return result;
    }

}
