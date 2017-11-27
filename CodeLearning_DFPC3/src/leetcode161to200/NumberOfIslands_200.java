package leetcode161to200;

public class NumberOfIslands_200 {
	
	//Sol 2: Union Find
	public int numIslands_2(char[][] grid) {
	    if(grid==null || grid.length==0 || grid[0].length==0)
	        return 0;
	 
	    int m = grid.length;
	    int n = grid[0].length;
	 
	    int[] dx={-1, 1, 0, 0};
	    int[] dy={0, 0, -1, 1};
	 
	    int[] root = new int[m*n];
	 
	    int count=0;
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            if(grid[i][j]=='1'){
	                root[i*n+j] = i*n+j;            
	                count++;
	            }
	        }
	    }
	 
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            if(grid[i][j]=='1'){
	                for(int k=0; k<4; k++){
	                    int x = i+dx[k];
	                    int y = j+dy[k];
	 
	                    if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]=='1'){
	                        int cRoot = getRoot(root, i*n+j);
	                        int nRoot = getRoot(root, x*n+y);
	                        if(nRoot!=cRoot){
	                            root[cRoot]=nRoot; //update previous node's root to be current
	                            count--;
	                        }
	 
	                    }
	                }
	            }
	        }
	    }
	 
	    return count;
	}
	 
	public int getRoot(int[] arr , int i){
	    while(arr[i]!=i){
	        i = arr[arr[i]];
	    }
	 
	    return i;
	}
	
	
	
	
	
	//Sol 1: DFS
    public int numIslands(char[][] grid) 
    {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        /*
        if(m==1)
        {
            int cur = 0;
            while(cur!=n)
            {
                if(grid[0][cur]=='1' && (cur==0 || grid[0][cur-1]==0))
                    count++;
                cur++;
            }
            return count;
        }
        if(n==1)
        {
            int cur = 0;
            while(cur!=m)
            {
                if(grid[cur][0]=='1' && (cur==0 || grid[cur-1][0]==0))
                    count++;
                cur++;
            }
            return count;
        }
        */
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j)
    {
        if(grid[i][j]=='1')
        {
            grid[i][j] = '0';
            if(i>0) dfs(grid,i-1,j);
            if(i<grid.length-1) dfs(grid,i+1,j);
            if(j>0) dfs(grid,i,j-1);
            if(j<grid[0].length-1) dfs(grid,i,j+1);
        }
    }
        
        
}
