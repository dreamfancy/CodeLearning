package dfs;

public class UniquePaths_61 
{
	
	
	
	//My Solution 1: DFS with int[] to carry the value
    public int uniquePaths_1(int m, int n) 
    {
    	if(m==1 || n==1) return 1;
    	int x = 1;
    	int y = 1;
    	int[] count = new int[1];
    	dfs(1,1,m,n,count);
    	return count[0];
    }
    
    public void dfs(int x, int y, int m, int n, int[] count)
    {
    	if(x==m && y==n) count[0]++;
    	if(x==(m+1) || y==(n+1)) return;
    	
    	dfs(x+1,y,m,n,count);
    	dfs(x,y+1,m,n,count);
    }

    //Solution 2:
    //dfs exceed time limit -> dp: use space to time
    
    public int uniquePaths_2(int m, int n) 
    {
    	int[][] arr = new int [n][m];
    	
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
}
