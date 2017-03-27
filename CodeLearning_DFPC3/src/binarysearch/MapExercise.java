package binarysearch;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapExercise {

	public static void hashmapExercise()
	{
		Map hash = new HashMap();
		hash.put("c", "x");

		hash.put("b", "z");
 
		hash.put("a", "y");
		
		Iterator it = hash.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry pairs = (Entry) it.next();
			System.out.println(pairs.getKey() + "  " + pairs.getValue());
		}
		
	}
	
	public static void hashtableExercise()	
	{
		Hashtable<String,String> hash = new Hashtable<String,String>();
		hash.put("c", "x");

		hash.put("b", "z");
	
		hash.put("a", "y");
		
		Iterator it = hash.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry pairs = (Entry) it.next();
			System.out.println(pairs.getKey() + "  " + pairs.getValue());
		}
	}
	
	
	public static void treemapExercise()
	{
		Map hash = new TreeMap();
		hash.put("c", "x");

		hash.put("b", "z");

		hash.put("a", "y");
		
		Iterator it = hash.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry pairs = (Entry) it.next();
			System.out.println(pairs.getKey() + "  " + pairs.getValue());
		}
		
		
	}
	
	/*
	public static void main(String[] args)
	{
		hashmapExercise();
		System.out.println();
		//hashtableExercise();
		System.out.println();
		treemapExercise();  //Attention, When using iterator to traverse the entrySet of the treemap, it will output by 
							//Key value;
	}
	
	*/
	
}
