package leetcode1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_2_40 
{	 
	
	//Solution 2 here is correct one
	//Always use target remain and check if remain ==0
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if(candidates==null || candidates.length==0 || target<=0) return result;
	        
	        List<Integer> cursol = new ArrayList<Integer>();
	        Arrays.sort(candidates);
	        generalhelper(candidates,0,target,cursol,result);
	        
	        return result;
	 }
	 public void generalhelper(int[] candidates, int start, int remain, List<Integer> cursol, List<List<Integer>> result)
 {
	        if(remain==0)
	        {
	            result.add(new ArrayList<Integer>(cursol));
	            return;
	        }
	        if(remain<0 || start>=candidates.length) return;
	        
	        for(int i=start; i<candidates.length; i++)
	        {
	        	int cur = candidates[i];
	        	cursol.add(cur);
	        	generalhelper(candidates,i,remain-cur,cursol,result);
	        	cursol.remove(cursol.size()-1);
	        }
	        
	  }

	
	
	//The solution below is wrong!!!
	public List<List<Integer>> combinationSum_General(int[] candidates, int target) {
    
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(candidates==null || candidates.length==0 || target<=0) return result;
	    
	    List<Integer> cursol = new ArrayList<Integer>();
	    Arrays.sort(candidates);
	    generalhelper(candidates,0,0,cursol,result,target);
	    
	    return result;
	}
	public void generalhelper(int[] candidates, int start, int sum, List<Integer> cursol, List<List<Integer>> result, int target)
	{
	    if(sum==target)
	    {
	        result.add(new ArrayList<Integer>(cursol));
	        return;
	    }
	    if(sum>target || start>=candidates.length) return;
	    
	    for(int i=start; i<candidates.length; i++)
	    {
            if( i>start && candidates[i] == candidates[i-1])
            {
                continue;
            }
	    	int cur = candidates[i];
	    	cursol.add(cur);
	    	generalhelper(candidates,start+1,sum+cur,cursol,result,target);
	    	cursol.remove(cursol.size()-1);
	    }
	    
	}

}
