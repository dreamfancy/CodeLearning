package leetcode300to350;

public class RangeSumQuery2D_304 
{
	class NumMatrix {

	    int[][] dp;
	    int m;
	    int n;
	    
	    public NumMatrix(int[][] matrix) 
	    {
	        if(matrix==null || matrix.length==0 || matrix[0].length==0) return;
	        
	        m = matrix.length;
	        n = matrix[0].length;
	        dp = new int[m][n];
	        dp[0][0] = matrix[0][0];
	        for(int a=1; a<matrix.length; a++)
	        {
	            dp[a][0] = dp[a-1][0] + matrix[a][0];
	        }
	        for(int b=1; b<matrix[0].length; b++)
	        {
	            dp[0][b] = dp[0][b-1] + matrix[0][b];
	        }
	        
	        for(int i=1; i<m; i++)
	        {
	            for(int j=1;j<n; j++)
	            {
	                dp[i][j] = matrix[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
	            }
	        }   
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) 
	    {
	        return dp[row2][col2] - (row1>0 ? dp[row1-1][col2] : 0) - (col1>0 ? dp[row2][col1-1] : 0)  + (row1>0 && col1>0 ? dp[row1-1][col1-1] : 0);
	        
	    }
	}

}
