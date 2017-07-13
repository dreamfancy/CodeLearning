package tree;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 
{
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
       // StringBuilder sb = new StringBuilder();
        List<Integer> curList = new ArrayList<Integer>();
        helper(n,k,1,curList,res);
        
        return res;
    }

    //ArrayList Need Deep Copy then can be used in other places
    private List<Integer> helper(int n, int k, int cur, List<Integer> curList, List<List<Integer>> res)
    {
    	if(k<=0 || cur>n) return curList;
    	if(k==1)
    	{
    		curList.add(cur);
    		res.add(curList);
    		curList.remove(curList.size()-1);
    		return curList;
    	}
    	curList.add(cur);
    	curList = helper(n,k-1,cur+1,curList,res);
    	curList.remove(curList.size()-1);
    	curList = helper(n,k,cur+1,curList,res);
    	
    	return curList;
    }
}
