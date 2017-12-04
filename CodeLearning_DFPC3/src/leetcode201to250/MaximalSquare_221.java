package leetcode201to250;

public class MaximalSquare_221 
{
    public int maximalSquare(char[][] matrix) 
    {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int curmax = 0;
        for(int i=0; i<m; i++)
        {
            dp[i][0] = matrix[i][0]=='1' ? 1:0;
            curmax = Math.max(dp[i][0],curmax);
        }
                
        for(int j=0; j<n; j++)
        {
            dp[0][j] = matrix[0][j]=='1' ? 1:0;
            curmax = Math.max(dp[0][j],curmax);

        }
        
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                dp[i][j] = matrix[i][j]=='1'? (Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i][j-1]))+1) : 0;
                curmax = Math.max(dp[i][j],curmax);
            }
        }
        return curmax*curmax;
    }
}
