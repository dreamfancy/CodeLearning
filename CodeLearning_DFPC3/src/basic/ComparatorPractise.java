package basic;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorPractise {

	//public static void main(String[] args)
	{
		IntArrayComparator	c = new IntArrayComparator();
		
		int[] a = new int[3];
		a[0] = 0; a[1] = 1; a[2] = 2;
		
		int[] b = new int[3];
		a[0] = 0; a[1] = 5; a[2] = 0;
		
		
		System.out.println(c.compare(a,b));
		
		
		
	}
	
	
}
