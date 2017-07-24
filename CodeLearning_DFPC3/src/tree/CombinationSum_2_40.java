package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(candidates==null || candidates.length==0 || target<=0) return res;
    	List<Integer> curRes = new ArrayList<Integer>();
    	Arrays.sort(candidates);
    	
    	//helper_1(candidates,0,target,curRes,res);
    	helper_2(candidates,0,target,curRes,res);
		return res;	
    }
    
    //DFS_2
    //Please revisit this scenario.
    //For this questions, solution_1 is much better than solution_2
    private void helper_2(int[] candidates, int curIndex, int left,List< Integer> curRes, List<List<Integer>> res)
    {
    	if(left==0)
    	{
    		res.add(new ArrayList<Integer>(curRes));
    		return;
    	}
    	if(left<0 || curIndex<0 || curIndex>candidates.length) return;
    	if( curIndex>0 && candidates[curIndex] == candidates[curIndex-1] && !curRes.isEmpty() && curRes.get(curRes.size()-1)==candidates[curIndex])
        {
    		 int curNum = candidates[curIndex];
    	    left =  left - curNum;
    		curRes.add(curNum);
    		helper_2(candidates,curIndex+1,left,curRes,res);
    		curRes.remove(curRes.size()-1);
    		left =  left + curNum;	
            
    		return;
        } 
    	
    	int curNum = candidates[curIndex];
    	left =  left - curNum;
		curRes.add(curNum);
		helper_2(candidates,curIndex+1,left,curRes,res);
		curRes.remove(curRes.size()-1);
		left =  left + curNum;		
		helper_2(candidates,curIndex+1,left,curRes,res);
		
		return;
    }
    
    
    
    
    //DFS 1
    private void helper_1(int[] candidates, int curIndex, int left,List<Integer> curRes, List<List<Integer>> res)
    {
    	if(left==0)
    	{
    		res.add(new ArrayList<Integer>(curRes));
    		return;
    	}
    	if(left<0 || curIndex<0 || curIndex>candidates.length) return;
		
    	for(int i=curIndex; i<candidates.length; i++)
    	{
            if( i>curIndex && candidates[i] == candidates[i-1])
            {
                continue;
            }
            
                
        	int curNum = candidates[i];
    		left =  left - curNum;
    		curRes.add(curNum);
    		helper_1(candidates,i+1,left,curRes,res);
    		curRes.remove(curRes.size()-1);
    		left =  left + curNum;
            
    	}	
    	return;
    }
    

	
	
}
