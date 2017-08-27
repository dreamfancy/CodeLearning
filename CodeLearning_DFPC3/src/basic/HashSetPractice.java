package basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HashSetPractice {

	public static void main(String[] args)
	{ 
		useTreeSetForEquals_Integer();
	}
	
	
	
	public static void useTreeSetForEquals_Integer()
	{
		Set<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(3);
		treeSet.add(2);
		treeSet.add(4);
		treeSet.add(1);
		
		Set<Integer> treeSet2 = new TreeSet<Integer>();
		treeSet2.add(2);
		treeSet2.add(4);
		treeSet2.add(3);
		treeSet2.add(1);
		
		Set<Integer> treeSet3 = treeSet;
		
		Set<Integer> treeSet4 = new TreeSet<Integer>();
		treeSet4.add(2);
		treeSet4.add(4);
		treeSet4.add(3);
		treeSet4.add(1);
		treeSet4.add(5);

		System.out.println(treeSet4.containsAll(treeSet));

		/*
		Iterator<Integer> iter = treeSet.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println(treeSet.equals(treeSet2));
		System.out.println(treeSet.equals(treeSet3));
		*/
	}
	
	
	public void hashSetEquals()
	{
		Point p1 = new Point(1,1,2);
		Point p2 = new Point(1,1,2);
		Point p3 = new Point(1,1,3);
		

		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println("*************");

		HashSet<Point> hash = new HashSet<Point>();
		hash.add(p1);
		System.out.println(hash.contains(p1));
		System.out.println(hash.contains(p2));
		System.out.println(hash.contains(p3));
	}
}
