package leetcode1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 
{
	//Solution 2:
	//DFS based on which I start to consider now! Standard Resolution For Such questions with duplicates
	 public List<List<Integer>> combinationSum_General(int[] candidates, int target) {
	        
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if(candidates==null || candidates.length==0 || target<=0) return result;
	        
	        List<Integer> cursol = new ArrayList<Integer>();
	        Arrays.sort(candidates);  //Arrays.sort() is needed for this solution !!!
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
	        	int cur = candidates[i];
	        	sum += cur;
	        	cursol.add(cur);
	        	generalhelper(candidates,start,sum,cursol,result,target);
	        	cursol.remove(cursol.size()-1);
	        	sum -= cur;
	        }
	        
	  }
	//Solution 1:
	//Allow duplicates: So DFS based on Element
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0 || target<=0) return result;
        
        List<Integer> cursol = new ArrayList<Integer>();
        //Arrays.sort(candidates);
        helper(candidates,0,0,cursol,result,target);
        
        return result;
    }
    
    public void helper(int[] candidates, int start, int sum, List<Integer> cursol, List<List<Integer>> result, int target)
    {
        if(sum==target)
        {
            result.add(new ArrayList<Integer>(cursol));
            return;
        }
        if(sum>target || start>=candidates.length) return;
        
        
        helper(candidates,start+1,sum,cursol,result,target);
        int count = 0;
        while(sum<=target)
        {
            sum += candidates[start];
            cursol.add(candidates[start]);
            helper(candidates,start+1,sum,cursol,result,target);
            count++;
        }
        for(int i=0; i<count; i++)
        {
            cursol.remove(cursol.size()-1);
        }
        
    }

}
