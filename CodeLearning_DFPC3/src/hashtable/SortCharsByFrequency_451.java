package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;


//This article should be read carefully:
//http://blog.csdn.net/liu826710/article/details/9001254

public class SortCharsByFrequency_451 {

	//Use treemap but get the opposite of the key to realise decending order 
	public static String frequencySort(String s) {

	int[]freq = new int[256];
	for(int i=0; i<s.length(); i++)
	{
		freq[s.charAt(i)]++;
	}
	
	TreeMap<Integer,String> tree= new TreeMap<Integer,String>();
	
	for(int j=0; j<256; j++)
	{
		if(freq[j] == 0) continue;
		if(!tree.containsKey(-freq[j]))
		{
			StringBuilder strb = new StringBuilder();
			for(int k=0; k<freq[j];k++)
			{
				strb.append((char)j);
			}
			tree.put(-freq[j], strb.toString());
		}
		else
		{
			StringBuilder strb2 = new StringBuilder(tree.get(-freq[j]));
			for(int m=0; m<freq[j];m++)
			{
				strb2.append((char)j);
			}
			tree.put(-freq[j],strb2.toString());
		}
	}
	
	Iterator<Map.Entry<Integer,String>> it = tree.entrySet().iterator();
	
	StringBuilder result = new StringBuilder();
	
	while(it.hasNext())
	{
		result.append(it.next().getValue());
	}
	
	return result.toString();
		
}
	//Solution_1:
	//Use two dimension array: The seconde dimension can have multiple elements...
	//to sort while the first dimention is used for comparator.
	//Revisit
	public static String frequencySort_2(String s) {
	
		if(s == null) return null;
		if(s.length()==0) return s;
	
		int[][] store = new int[33][1];
		
		for(int i=0; i<s.length(); i++)
		{
			char curchar = s.charAt(i);
			
			int curchartoint = curchar;
			store[curchartoint][0] = curchar;
			store[curchartoint][1]++;
		}
		
		Arrays.sort(store, 
				new Comparator<int[]>()
				{
					public int compare(int[] a, int[] b)
					{
						return a[1]==b[1] ? 0: (a[1]<b[1]? 1:-1);
					}
				}		
		);
			
		StringBuilder strb = new StringBuilder();
		for(int i=0; i<store.length; i++)
		{
			for(int j=0; j<store[i][1]; j++)
			{
				strb.append((char)store[i][0]);
			}
		}
		
		return strb.toString();
	}
	
	//Solution by myself: Use two HashMap and update concurrently
	public static String frequencySort_3(String s) {

		if(s == null) return null;
		if(s.length()==0) return s;
		
		TreeMap<Integer,ArrayList<Character>> h1 = new TreeMap<Integer,ArrayList<Character>>();
		TreeMap<Character,Integer> h2 = new TreeMap<Character,Integer>();
		
		for(int i=0; i<s.length(); i++)
		{
			char curchar = s.charAt(i);
			if(!h2.containsKey(curchar))
			{
				h2.put(curchar,1);
				List<Character> storeList;
				if(h1.containsKey(1))
				{
					storeList = h1.get(1);
				}
				else
				{
					storeList = new ArrayList<Character>();
				}
				storeList.add(curchar);
				h1.put(1,(ArrayList<Character>) storeList);
			}
			else
			{
				int curnum = h2.get(curchar);
				ArrayList<Character> arr1 = h1.get(curnum);	
				arr1.remove(Character.valueOf(curchar));
				h1.put(curnum,arr1);
				ArrayList<Character> arr2; 
				if(h1.containsKey(curnum+1))
				{
					arr2 = h1.get(curnum+1);
				}
				else
				{
					arr2 = new ArrayList<Character>();	
				}
				
				arr2.add(curchar);
				h1.put(curnum+1,arr2);
				h2.put(curchar,curnum+1);
			}	
		}
	   
	   StringBuilder sb1 = new StringBuilder();
	   Stack<Character> st = new Stack<Character>();
	   Iterator it = h1.keySet().iterator();
	   while(it.hasNext())
	   {
		   int number = (int) it.next();
		   ArrayList<Character> charsToShow = h1.get(number);
		   for(Character c: charsToShow)
		   {
			   for(int k=0; k<number; k++)
			   st.push(c);
		   }
	   }
	   while(!st.isEmpty())
	   {
		   sb1.append(st.pop());
	   }
	   return sb1.toString();
	}
	
	
	

}
