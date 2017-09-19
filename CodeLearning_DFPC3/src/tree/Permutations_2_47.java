package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Use Array itself as the current solution by swapping
public class Permutations_2_47 {
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums==null || nums.length==0) return result;
    	//List<Integer> curSol = new ArrayList<Integer>();
    	Arrays.sort(nums);
    	helper(nums,0,result);
    	return result;
    }
    
    public void helper(int[] nums,int cur, List<List<Integer>> result)
    {
    	if(cur==nums.length-1)
    	{
    		List<Integer> newSol = new ArrayList<Integer>();
    		for(int i=0; i<nums.length;i++)
    		{
    			newSol.add(nums[i]);
    		}
    		result.add(newSol);
    		return;
    	}
    	
    	for(int i= cur; i<nums.length; i++)
    	{
    		//if(i!=cur && nums[i]==nums[i-1]) continue;
    		if(NotContainDuplicates(nums,cur,i)==true)
    		{
    			swap(nums,i,cur);
    			helper(nums,cur+1,result);
    			swap(nums,i,cur);
    		}
    	}
    }

    //Please understand why!
    public boolean NotContainDuplicates(int[] nums, int start, int cur)
    {
    	for(int i=start; i<cur; i++)
    	{
    		if(nums[i]==nums[cur]) return false;
    	}
    	return true;
    }
    
    public void swap(int[] nums, int pos1, int pos2)
    {
    	int temp = nums[pos1];
    	nums[pos1] = nums[pos2];
    	nums[pos2] = temp;
    }
    
    
    //Solution 2: User HashSet to make sure that every result is unique
    //Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
    //returnList = new ArrayList<ArrayList<Integer>>(currentSet);
    //PLease revisit!!!
    public static ArrayList<ArrayList<Integer>> permuteUnique_UsingSet(int[] num) 
    {
    	ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
    	returnList.add(new ArrayList<Integer>());
    	
    	for(int i=0; i<num.length; i++)
    	{
    		Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
    		//Check whether ArrayList<Integer> is unique!!
    		for(List<Integer> l : returnList)
    		{
    			for(int j=0; j<l.size()+1; j++)
    			{
    				l.add(j,num[j]);
    				ArrayList<Integer> t = new ArrayList<Integer>(l);
    				l.remove(j);
    				currentSet.add(t);
    			}
    		}
    		returnList = new ArrayList<ArrayList<Integer>>(currentSet);
    	}
		return returnList;
    }
}
