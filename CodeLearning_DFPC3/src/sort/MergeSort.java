package sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeSort {

	//Scenario_2: Divide and Merge an Array
	
	//Scenario_1: Divide and Merge an ArrayList
	//Time Complexity: O(nlogn):(O(n)+O(nlogn)
	//Space Complexity:
	//IF using ArrayList as storage: O(nlogn)
	//IF using Array as storage: O(n)
	
	public ArrayList<Integer> divideAndMerge(ArrayList<Integer> list, int left, int right)
	{
		if(left>right || right>(list.size()-1) || left<0) return null;
		//!!!Wrong!!!if(left==right) return list;
		//You cannot return the same list or the next steps/functions may get influenced!
		//You should never change the original data provided by function
		ArrayList<Integer> listResult = new ArrayList<Integer>();
		if(left==right)
		{
			listResult.add(list.get(left));
		}
		int mid = left + (right-left)/2;
		ArrayList<Integer> listFront = divideAndMerge(list,left,mid);
		ArrayList<Integer> listBack = divideAndMerge(list,mid+1,right);
		
		return mergeList(listFront,listBack);

	}
	
	public ArrayList<Integer> mergeList(ArrayList<Integer> l1,ArrayList<Integer> l2)
	{
		if(l1==null ||l1.size()==0) return l2;
		if(l2==null ||l2.size()==0) return l1;
		
		int i=0,j=0;
		ArrayList<Integer> retList = new ArrayList<Integer>();
		while(i<l1.size() &&j<l2.size())
		{
			if(l1.get(i)<=l2.get(j))
			{
				retList.add(l1.get(i++));
			}
			else
			{
				retList.add(l2.get(j++));
			}
		}
		
		if(i<l1.size())
		{
			for(int c1=i; c1<l1.size(); c1++)
			{
				retList.add(l1.get(c1));
			}
		}
		
		if(j<l2.size())
		{
			for(int c2=j; c2<l2.size(); c2++)
			{
				retList.add(l2.get(c2));
			}
		}		
		return retList;
	}
	
}
