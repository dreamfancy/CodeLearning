package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndArrayList {
/*
    public static void main(String[] args)
    {
        ArrayList<Integer> arrList1 = new ArrayList<Integer>();
        arrList1.add(5);
        arrList1.add(4);
        arrList1.add(3);
        arrList1.add(2);
       
       
    }
  */ 
	
	public String getArrayToString(int[] array,int start, int end)
	{
		return new String(array,start,end-1); 
	}
    public static int[] castArrayListToArray(List<Integer> list)
    {
    	int[] ret = new int[list.size()];
    	
    	for(int i=0; i<list.size(); i++)
    	{
			ret[i] = list.get(i);
    	}
    	return ret;
    }
    
    public static Integer[] castArrayListToArray_2(List<Integer> list)
    {
    	Integer[] integerArray = list.toArray(new Integer[list.size()]);
    	
    	return integerArray;
    }
    
    public static String[] castStringArrayList(List<String> list2)
    {
    	String[] res = list2.toArray(new String[list2.size()]);
    	return res;    	
    }
    
    
    public static ArrayList<Integer> castArrayToArrayList(Integer[] intArray)
    {
    	return new ArrayList<Integer>(Arrays.asList(intArray));
    	
    }
    
    public static void main(String[] args)
    {
    	/*
    	List<Integer> list = new ArrayList<Integer>();
    	//System.out.println(list.get(3));
    	list.add(3);
    	list.add(new Integer(2));
    	list.add(new Integer(1));
    	
    	Integer[] arr = castArrayListToArray_2(list);
    	
    	for(int i=0; i<arr.length; i++)
    	{
    		System.out.println(arr[i]);
    	}
    	
    	List<String> list2 = new ArrayList<String>();
    	list2.add("I am a good guy");
    	list2.add(null);
    	list2.add("Thanks");
    	
    	String[] res = castStringArrayList(list2);
    	for(int i=0; i<res.length; i++)
    	{
    		System.out.println(res[i]);
    	}
    	*/
    	List<Integer> list = new ArrayList<Integer>();
    	//System.out.println(list.get(3));
    	list.add(3);
    	list.add(new Integer(2));
    	list.add(new Integer(1));
    	
    	for(int i: list)
    	{
    		i = i+1;
    	}
    	
    	for(int i: list)
    	{
    		System.out.println(i);
    	}
    }
}

 
