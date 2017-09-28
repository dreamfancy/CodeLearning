package dp;

public class MinPathSum_64 
{
    public int minPathSum(int[][] grid) 
    {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        int m = grid[0].length;
        int n = grid.length;
        int[][] dp = new int[n][m];
        int pre = 0;
        for(int i=0; i<n;i++)
        {
            dp[i][0] = pre + grid[i][0];
            pre = dp[i][0];
        }
        if(m==1) return dp[n-1][0];
        pre = 0;
        for(int j=0; j<m; j++)
        {
            dp[0][j] = pre + grid[0][j];
            pre = dp[0][j];
        }
        if(n==1) return dp[0][m-1];

        
        for(int k=1; k<n; k++)
        {
            for(int l=1; l<m; l++)
            {
                dp[k][l] = Math.min(dp[k-1][l], dp[k][l-1]) + grid[k][l];
            }
        }
        
        return dp[n-1][m-1];
    }

}
