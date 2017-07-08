package stackqueueheap;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 
{
    public List<List<Integer>> subsets(int[] nums) 
    {
    	//List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<List<Integer>> curSol = new ArrayList<List<Integer>>();

    	curSol.add(new ArrayList<Integer>());
    	//return dfs(nums,0,curSol,result);
    	return dfs(nums,0,curSol);
    }

    public List<List<Integer>> dfs(int[] arr, int index,List<List<Integer>> curSol)
    {
    	int curElement = arr[index];
    	int curSize = curSol.size();
    	
    	for(int i=0; i<curSize; i++)
    	{
    		List<Integer> curList = curSol.get(i);
            List<Integer> newList = new ArrayList<Integer>();
    		newList.addAll(curList);
            newList.add(curElement);
    		curSol.add(newList);
    	}
    	index++;
    	
    	if(index<arr.length)
    	{
    		return  dfs(arr,index,curSol);
    	}
    	
    	return curSol;
    	
    }
}
