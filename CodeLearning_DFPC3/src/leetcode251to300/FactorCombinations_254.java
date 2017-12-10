package leetcode251to300;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations_254 
{

	
	
	
	
	// sol1 : dfs recursion, use min to sort the input to avoid duplicate
    public List<List<Integer>> getFactors(int n) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n<=3) return result;
        List<Integer> cursol = new ArrayList<Integer>();
        generateFactors(n,2,cursol,result);
        
        return result;
    }
    
    private void generateFactors(int n, int min, List<Integer> cursol, List<List<Integer>> result)
    {
        if(n==1)
        {
            if(cursol.size()!=1)
                result.add(new ArrayList<Integer>(cursol));
            return;
        }
        int cur = min;
        while(cur<=n)
        {
            if(n%cur!=0)
            {
                cur++;
                continue;
            }
            else
            {
                int next = n/cur;
                cursol.add(cur);
                generateFactors(next,cur,cursol,result);
                cursol.remove(cursol.size()-1);
            }
            cur++;
        }  
    }

}
