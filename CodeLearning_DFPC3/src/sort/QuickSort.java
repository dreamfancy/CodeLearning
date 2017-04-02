package sort;

import java.util.ArrayList;

public class QuickSort {

	/*
	//Standard Solution from web
	public int[] quickSort(int[] arr, int left, int right)
	{
		
	}
	
	
	//My Solution
	public int[] quickSort(int[] arr, int left, int right)
	{
		if(arr==null ||arr.length==0) return arr;
		if(right<left) return null;
		if(left==right) return arr;
		//Always choose the medium one
		int mid = left + (right-left)/2;
		swap(arr,mid,right);
			
		int p1 = left;
		int p2 = right-1;
		int tar = arr[right];
		
		while(p1<=p2)
		{
			if(arr[p1]<=tar) p1++;
			if(arr[p2]>tar) p2--;
			
			if(p1<p2)
				swap(arr,p1,p2);
		}
		
		if(p1==(right+1)) return arr;
		if(p2==(left-1)) 
		{
			if(p2>=0) swap(arr,left,right);
		}
		if(arr[p1]>tar) 
		{
			swap(arr,p1,right);
			quickSort(arr,left,p1-1);
			quickSort(arr,p1+1,right);
		}
		else
		{
			swap(arr,p2,right);
			quickSort(arr,left,p2-1);
			quickSort(arr,p2+1,right);
		}
		
		return arr;
	}

	public void swap(int[] arr, int first, int second)
	{
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	*/
}
