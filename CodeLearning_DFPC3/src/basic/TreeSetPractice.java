package basic;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetPractice {

	public static void main(String[] args)
	{
		TreeSet<Integer> treeset = new TreeSet<Integer>();
		
		System.out.println(treeset.ceiling(4));
		System.out.println("********");
		treeset.add(2);
		treeset.add(1);
		treeset.add(3);
		treeset.add(4);
		treeset.add(7);
		treeset.add(6);
		treeset.add(5);
		treeset.remove(4);

		/*
		for(int cur : treeset)
		{
			System.out.println(cur);
		}
		*/
		
		Iterator<Integer> setiter = treeset.iterator();
		for(int i=0; i<treeset.size(); i++)
		{
			System.out.println(setiter.next());

		}
	
	}
}
