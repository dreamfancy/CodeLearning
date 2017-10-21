package leetcode51to100;

public class UniquePaths_2_63 
{
   public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        if(obstacleGrid==null) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(m==0 ||n==0) return 0;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;
        
        int[][] data = new int[m][n];
        data[0][0] = 1;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(obstacleGrid[i][j]==1)
                {
                    data[i][j] = 0;
                }
                else if(i==0 && j!=0)
                {
                    data[i][j] = data[i][j-1];
                }
                else if(i!=0 && j==0)
                {
                    data[i][j] = data[i-1][j];
                }
                else if(i!=0 && j!=0)
                {
                    data[i][j] = data[i-1][j] + data[i][j-1];
                }
                    
            }
        }
        
        return data[m-1][n-1];
        
    }	

}
