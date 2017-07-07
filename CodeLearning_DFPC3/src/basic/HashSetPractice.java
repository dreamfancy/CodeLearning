package basic;

import java.util.HashSet;

public class HashSetPractice {

	public static void main(String[] args)
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
