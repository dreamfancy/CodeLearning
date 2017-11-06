package leetcode51to100;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class UniqueBST_96 {

	//DP: Decide how many solutions there are
    public int numTrees_2(int n) 
    {
        if(n<=0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++)
        {
            for(int j=1; j<=i; j++)
            {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
	
	
	
	
	//My Solution, getting from question 95, not DP
    public int numTrees_1(int n) {
        if(n<=0) return 0;
        return generateTrees(1,n);
    }
    
    public int generateTrees(int start, int end)
    {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start>=end) return 1;
        
        int count = 0;
        
        for(int i=start; i<=end; i++)
        {
            int left = generateTrees(start,i-1);
            int right = generateTrees(i+1,end);
            count += left*right;
        }
        return count;  
    }
}
