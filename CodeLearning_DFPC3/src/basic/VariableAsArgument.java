package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VariableAsArgument {

	public static void stringAsVariable()
	{
		String str1 = new String("abc");
		
		tempMethod1(str1);
		
		System.out.println(str1);	
	}
	
	public static void tempMethod1(String strt1)
	{
		strt1.substring(2);
	}
	
	public static void ArrayAsVariable()   //in Java, The Array is also means an address
	{
		int[] arr = new int[4];
		arr[0] = 0; 
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		
		tempMethod2(arr);	
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	public static void tempMethod2(int[] arr)
	{
		arr[2]= 100;
	}
	
	public static void arrayListAsVariable()   //ArrayList can even remove the first element in sub method
	{
		List<Integer> arrl = new ArrayList<Integer>();
		arrl.add(0);
		arrl.add(1);
		arrl.add(2);
		arrl.add(3);
		
		tempMethod3(arrl);	
		for(int i=0; i<arrl.size(); i++)
		{
			System.out.println(arrl.get(i));
		}
	}
	public static void tempMethod3(List<Integer> arrl)
	{
		arrl.add(100);
		arrl.remove(0);
	}

	public static void linkedListListAsVariable()   //LinkedList can even remove first element in sub method
	{
		List<Integer> linkl = new LinkedList<Integer>();
		linkl.add(0);
		linkl.add(1);
		linkl.add(2);
		linkl.add(3);
		
		tempMethod4(linkl);	
		for(int i=0; i<linkl.size(); i++)
		{
			System.out.println(linkl.get(i));
		}
	}
	public static void tempMethod4(List<Integer> linkl)
	{
		linkl.remove(2);
		linkl.remove(0);
		linkl.add(100);
		//linkl.remove(7);
	}
	
	public static void main(String[] args)
	{
		//stringAsVariable();
		//ArrayAsVariable();
		//arrayListAsVariable();
		linkedListListAsVariable();
	}
}
