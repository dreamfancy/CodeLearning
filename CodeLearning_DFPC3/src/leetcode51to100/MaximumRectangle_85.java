package leetcode51to100;

public class MaximumRectangle_85 {
	
    public int maximalRectangle_2(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
           int m = matrix.length, n = matrix[0].length;
           int[] heights = new int[n+1];
           int res = 0;
           for(int row=0; row<m; row++) {
               updateHeights(matrix, row, heights);
               res = Math.max(res, maxArea(heights));
           }
           return res;
       }
       
       private void updateHeights(char[][] matrix, int row, int[] heights) {
           for(int col=0; col<matrix[0].length; col++) {
               if(matrix[row][col]=='1') {
                   heights[col]++;
               } else {
                   heights[col] = 0;
               }
           }
       }
       
       private int maxArea(int[] heights) {
           int n = heights.length;
           int[] stack = new int[n+1];
           int top = 0;
           stack[top] = -1;
           int res = 0;
           for(int i=0; i<n; i++) {
               while(top>0 && heights[i]<heights[stack[top]]) {
                   int h = heights[stack[top--]];
                   res = Math.max(res, h*(i-stack[top]-1));
               }
               stack[++top] = i;
           }
           return res;
       }
	
	
	//My Solution : Wrong
    public int maximalRectangle(char[][] matrix) 
    {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int max = 0;
        int count = 1;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        for(int i=0; i<matrix.length; i++)
        {
            if(matrix[i][0]==1)
            {
                dp[i][0] = count++;
                max = Math.max(max,dp[i][0]);
            }
            else count = 1;
        }
        count = 1;
        
        for(int j=0; j<matrix[0].length; j++)
        {
            if(matrix[0][j]==1)
            {
                dp[0][j] = count++;
                max = Math.max(max,dp[0][j]);
            }
            else count = 1;
        }
        
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j]==0) dp[i][j] = 0;
                else
                {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+1;
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }
}
