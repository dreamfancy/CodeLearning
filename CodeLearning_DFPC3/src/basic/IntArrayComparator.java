package basic;

import java.util.Comparator;

public class IntArrayComparator implements Comparator{

	public int compare(int[] a, int[] b)
	{
		return (a[1]-b[1]>=0)? 1: -1;
	}

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int[] a = (int[])o1;
		int[] b = (int[])o2;
		return (a[1]-b[1]>=0)? 1: -1;	
	}


	
}
