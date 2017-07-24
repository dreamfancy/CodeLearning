package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum4_377 
{
    public int combinationSum4(int[] candidates, int target) 
    {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(candidates==null || candidates.length==0 || target<=0) return 0;
    	List<Integer> curRes = new ArrayList<Integer>();
    	Arrays.sort(candidates);
    	
    	//helper_1(candidates,0,target,curRes,res);	
    	//target is a limited number and there is no restrictions on adding number. It is a full recursion so we can use DP
        
    	//Solution 1: DP with Array
    	/*
    	int[] sum = new int[target + 1];  
        for (int i = 1; i <= target; i++) {
            for (int num : candidates) {  
                if (i == num) sum[i] += 1;  
                if (i > num) sum[i] += sum[i - num];  
                if (i < num) break;  
            }  
        }  
        return sum[target]; 
    	 */
        //Solution 2:
        
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1; i<=target; i++)  //dp: from small to bigger
        {
        	for(int k: candidates)
        	{
        		if(k<=i) dp[i] += dp[i-k];
        	}
        }
        return dp[target];
    }
    
    
    
    //Helper 1 is wrong because it regards 1 1 2 , 2 1 1 and 1 2 1 as one solution
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
        	int curNum = candidates[i];
    		curRes.add(curNum);
    		helper_1(candidates,i,left - curNum,curRes,res);
    		curRes.remove(curRes.size()-1);
            
    	}	
    	return;
    }

}
