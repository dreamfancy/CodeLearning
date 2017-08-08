package string;

import java.util.ArrayList;
import java.util.List;

public class PermulationWithDuplicates {

	public List<String> permuteUnique(String s)
	{
		List<String> result = new ArrayList<String>();
		
		if(s==null || s.length()==0) return result;
		
		char[] array = s.toCharArray();
		permulate(array,result,0);
		return result;
	}
	
	private void permulate(char[] array, List<String> result, int index)
	{
		if(index==array.length) 
		{
			result.add(new String(array,0,array.length));
			return;
		}
		//set<Character> hash = new HashSet();
		for(int i=index; i<array.length; i++)
		{
			if(i>1 && array[i] == array[i-1]) continue; //check duplicates 
			//or use hashSet
			//if(hash.add(array[i]))
			swap(array,index,i);
			permulate(array,result,index+1);
			swap(array,index,i);
		}
	}
		
	private void swap(char[] array, int i, int j)
	{
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
