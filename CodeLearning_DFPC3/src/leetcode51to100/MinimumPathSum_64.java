package leetcode51to100;

public class MinimumPathSum_64 
{
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        int m = grid.length;
        int n= grid[0].length;
        
        if(m==0 || n==0) return 0;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==0 && j==0)  dp[0][0] = grid[0][0];
                else if(i==0 && j!=0)  dp[0][j] = dp[0][j-1]+grid[0][j];
                else if(i!=0 && j==0)  dp[i][j] = dp[i-1][0]+grid[i][0];
                else
                {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        
        return dp[m-1][n-1];
    }

}
