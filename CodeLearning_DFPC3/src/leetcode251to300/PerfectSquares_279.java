package leetcode251to300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares_279 
{
	//Sol 2: DP
    public int numSquares_2(int n) 
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=1; i<=n; i++)
        {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while((i-j*j)>=0)
            {
                min = Math.min(min,dp[i-j*j]+1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }	
	
	
	//Sol 1: Getting thoughts from Combinations
	//Time Exceed Limit After 400 test cases 
    public int numSquares_1(int n) 
    {
        if(n==1) return 1;
        List<Integer> sourcelist = new ArrayList<Integer>();
        for(int i=1; i<n; i++)
        {
            int cur = i*i;
            if(cur>n) break;
            sourcelist.add(cur);
        }
        
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        findPerfectSquares(sourcelist, n, 0, res, 0);
        return res[0];
    }
    
    private void findPerfectSquares(List<Integer> sourceList, int remain, int cur, int[] min, int level)
    {
        if(level>min[0] || remain<0) return;
        if(remain==0)
        {
            min[0] = Math.min(min[0],level);
            return;
        }
        
        for(int i=cur; i<sourceList.size(); i++)
        {
            findPerfectSquares(sourceList,remain-sourceList.get(i), i, min, level+1);
        }   
    }

}
