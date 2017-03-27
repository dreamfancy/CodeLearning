package binarysearch;

import java.util.Comparator;

public abstract class IntArrayComparator implements Comparator{

	
	public int compare(int[] a, int[] b)
	{
		return a[0]-b[0];
	}

	

}
