package tree;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

public class Combinations_77 
{
	//Solution 2: 
    public List<List<Integer>> combine_2(int n, int k) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
       // StringBuilder sb = new StringBuilder();
        int[] curList = new int[k];
        helper_2(n,0,1,0,curList,res);
        
        return res;
    }
    
    private void helper_2(int n, int k, int num,int cur, int[] curList, List<List<Integer>> res)
    {
    	if(num==k)
    	{
    		ArrayList<Integer> tt= new ArrayList<Integer>();
    		for(int i=0; i<k; i++)
    		{
    			tt.add(curList[k]);
    		}
    		res.add(tt);
    		return;
    	}
    	
    	for(int i=cur; i<n; i++)
    	{
    		curList[num] = i+1;
    		helper_2(n,k,num+1,i+1,curList,res); 
    	}
    }
	
	
	
	
	//Solution 1: My solution 
    public void combine_1(int n, int k) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
       // StringBuilder sb = new StringBuilder();
        List<Integer> curList = new ArrayList<Integer>();
        helper(n,k,1,curList,res);
        
        return;
    }

    //ArrayList Need Deep Copy then can be used in other places
    private void helper(int n, int k, int cur, List<Integer> curList, List<List<Integer>> res)
    {
    	if(k<=0 || cur>n) return;
    	if(k==1)
    	{
    		curList.add(cur);
    		res.add(new ArrayList<Integer>(curList));
    		curList.remove(curList.size()-1);
        	helper(n,k,cur+1,curList,res);
        	
    		return ;
    	}
    	curList.add(cur);
    	helper(n,k-1,cur+1,curList,res);
    	curList.remove(curList.size()-1);
    	helper(n,k,cur+1,curList,res);
    	
    	return;
    }
}
