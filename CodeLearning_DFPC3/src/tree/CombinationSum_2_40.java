package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_2_40 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(candidates==null || candidates.length==0 || target<=0) return res;
    	List<Integer> curRes = new ArrayList<Integer>();
    	Arrays.sort(candidates);
    	
    	helper(candidates,0,0,target,curRes,res);
		return res;	
    }
    
    
    //DFS 2
    private void helper_2(int[] candidates, int curIndex, int curSum, int target,List<Integer> curRes, List<List<Integer>> res)
    {
    	if(curSum==target)
    	{
    		res.add(new ArrayList<Integer>(curRes));
    		return;
    	}
    	if(curSum>target || curIndex<0 || curIndex>=candidates.length) return;
		helper(candidates,curIndex+1,curSum,target,curRes,res);
    	for(int i=curIndex; i<candidates.length-1; i++)
    	{
        	int curNum = candidates[i];
    		curSum += curNum;
    		curRes.add(curNum);
    		helper(candidates,i,curSum,target,curRes,res);
    		curSum -= curNum;
    		curRes.remove(curRes.size()-1);
    	}
    	
    	
    	return;
    }
    
    
    
    //DFS 1: Add or not add one group of elements as one level
    private void helper(int[] candidates, int curIndex, int curSum, int target,List<Integer> curRes, List<List<Integer>> res)
    {
    	if(curSum==target)
    	{
    		res.add(new ArrayList<Integer>(curRes));
    		return;
    	}
    	if(curSum>target || curIndex<0 || curIndex>=candidates.length) return;
    	int curNum = candidates[curIndex];
		helper(candidates,curIndex+1,curSum,target,curRes,res);
    	for(int i=1; curNum<=(target-curSum); i++)
    	{
    		curSum += curNum;
    		curRes.add(curNum);
    		helper(candidates,curIndex+1,curSum,target,curRes,res);
    	
    	}
    	int i = 0;
    	while(i<curRes.size())
    	{
    		if(curRes.get(i)==curNum)
    		{	curRes.remove(i);
    			curSum -= curNum;
    		}
    		else
    		{
    			i++;
    		}
    	}
    	
    	return;
    }
	
	
	
}
