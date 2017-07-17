package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_3_216 
{

    
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
		
    	while(curSum<target)
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
