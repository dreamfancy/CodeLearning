package dfs;

public class UniquePath_2_63 
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
    	/*
    	public int uniquePathsWithObstacles(int[][] obstacleGrid) 
        {
    		int n = obstacleGrid.length;
    		int m = obstacleGrid[0].length;
        	int[][] arr = new int [n][m];
        	
        	boolean flag = 1
        	for(int i=0; i<n; i++)
        	{
        		
        		arr[i][0] = 1;
        	}
        	
        	for(int j=0; j<m; j++)
        	{
        		arr[0][j] = 1;
        	}
        	
        	for(int k=1; k<n; k++)
        	{
        		for(int l=1; l<m; l++)
        		{
        			arr[k][l] = arr[k-1][l] + arr[k][l-1];
        		}
        	}
        	return arr[n-1][m-1];
        }
       
         */
    	
    	return -1;
        
    }

}
