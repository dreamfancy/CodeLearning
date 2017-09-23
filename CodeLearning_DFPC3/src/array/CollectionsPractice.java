package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsPractice 
{
	
	public static void main(String[] args)
	{
		collectionsOperations();
	}
	
	
	public static void collectionsOperations()
	{
		List<String> list2 = new ArrayList<String>();
    	list2.add("I am a good guy");
    	list2.add(null);
    	list2.add("Thanks");
    	
    	//Reverse by collections
    	printStringList(list2);
    	Collections.reverse(list2);
    	printStringList(list2);

    	
    	List<String> list1 = new ArrayList<String>(list2);  //One solution for copy method!!!
    	printStringList(list1);

    	List<String> list3 = new ArrayList<String>();
    	list3.addAll(list2);
    	printStringList(list3);

    	
    	//Collections.copy(list1, list2);
		
	}
	
	public static void printStringList(List<String> list)
	{
    	for(String s: list)
    	{
    		System.out.println(s);
    	}
		System.out.println("***********");
		System.out.println("***********");
	}
	

}
