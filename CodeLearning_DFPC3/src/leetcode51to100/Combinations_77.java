package leetcode51to100;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

	//My Solution 2: tree level: Total k element, for the current element, choose which
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n<=0 || k<=0 || k>n) return result;
        List<Integer> sol = new ArrayList<Integer>();
        combine(1,n,k,sol,result);
        return result;
        
    }
    
    private void combine(int cur,int n, int k, List<Integer> sol, List<List<Integer>> result)
    {
        if(sol.size()==k)
        {
            result.add (new ArrayList<Integer>(sol));
            return;
        }
        if(cur>n) return;
        for(int i=cur;i<=n; i++)
        {
        	sol.add(i);
        	combine(i+1,n,k,sol,result);
        	sol.remove(sol.size()-1);
        }
    }
	
	
	
	//My Solution 1: tree level: choose or not choose each element
    public List<List<Integer>> combine_1(int n, int k) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n<=0 || k<=0 || k>n) return result;
        List<Integer> sol = new ArrayList<Integer>();
        combine(1,n,k,sol,result);
        return result;
        
    }
    
    private void combine_1(int cur,int n, int k, List<Integer> sol, List<List<Integer>> result)
    {
        if(sol.size()==k)
        {
            result.add (new ArrayList<Integer>(sol));
            return;
        }
        if(cur>n) return;
        combine(cur+1,n,k,sol,result);
        sol.add(cur);
        combine(cur+1,n,k,sol,result);
        sol.remove(sol.size()-1);   
    }
}
