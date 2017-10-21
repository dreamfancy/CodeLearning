package leetcode51to100;

public class UniquePaths_62 
{
	//My Solution 2: DP
    public int uniquePaths_2(int m, int n) 
    {
        if(m==0 ||n==0) return 0;
        if(m==1 ||n==1) return 1;
        
        int[][] data = new int[m][n];
        
        for(int a=0; a<m; a++)
        {
            data[a][0] = 1;
        }
        
        for(int b=1; b<n; b++)
        {
            data[0][b] = 1;
        }
        
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                data[i][j] = data[i-1][j] + data[i][j-1];
            }
        }
        
        return data[m-1][n-1];
        
    }
	
	
	//My Solution 1: Recursive : Time exceeding limit
    public int uniquePaths_1(int m, int n) 
    {
        if(m==0 ||n==0) return 0;
        if(m==1 ||n==1) return 1;
        
        int[] count = new int[1];
        
        uniquePaths(0,0,m,n,count);
        
        return count[0];
    }
    
    private void uniquePaths(int starty, int startx, int m, int n, int[] count)
    {
        if(starty==(m-1) && startx==(n-1))
            count[0]++;
        //if(starty==m || startx==n) return;
        if(starty<m-1)
        {
            uniquePaths(starty+1,startx,m,n,count);
        }
        
        if(startx<n-1)
        {
            uniquePaths(starty,startx+1,m,n,count);
        }
    }

}
