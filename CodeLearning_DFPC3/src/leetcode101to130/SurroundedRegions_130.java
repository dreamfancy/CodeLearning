package leetcode101to130;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions_130 
{	
	//Sol 2: BFS
    public void solve_2(char[][] board) 
    {
    	if(board==null || board.length<=1 || board[0].length<=1) return;
    	
    	int m = board.length;
    	int n = board[0].length;
    	
    	for(int i=0; i<m; i++)
    	{
    		if(board[i][0]=='O')
    		{
    			bfs(board,i,0);
    		}
    		if(board[i][n-1]=='O')
    		{
    			bfs(board,i,n-1);
    		}
    	}
    	for(int j=0; j<n; j++)
    	{
    		if(board[0][j]=='O')
    		{
    			bfs(board,0,j);
    		}
    		if(board[m-1][j]=='O')
    		{
    			bfs(board,m-1,j);
    		}
    	}
    	
    	for(int i=0; i<board.length; i++)
    	{
    		for(int j=0; j<board[0].length; j++)
    		{
    			if(board[i][j]=='*') board[i][j] = 'O';
    			else if(board[i][j]=='O') board[i][j] = 'X'; //The else here is very important!!!
    		}
    		
    	}
    }
    
    public void bfs(char[][] board, int y, int x)
    {
    	Queue<Integer> q = new LinkedList<Integer>();
    	int m = board.length;
    	int n = board[0].length;
    	
        board[y][x] = '*';
    	int index = y*n+x;
    	q.offer(index);
    	
    	while(!q.isEmpty())
    	{
    		int cur = q.poll();
    		int cury = cur/n;
    		int curx = cur%n;
    		if(cury>0 && board[cury-1][curx]=='O')
    		{
    			board[cury-1][curx] = '*';
    			int next = (cury-1)*n+curx;
    			q.offer(next);
    		}
    		if(cury<(m-1) && board[cury+1][curx]=='O')
    		{
    			board[cury+1][curx] = '*';
    			int next = (cury+1)*n+curx;
    			q.offer(next);
    		}
    		if(curx>0 && board[cury][curx-1]=='O')
    		{
    			board[cury][curx-1] = '*';
    			int next = cury*n+curx-1;
    			q.offer(next);
    		}
    		if(curx<(n-1) && board[cury][curx+1]=='O')
    		{
    			board[cury][curx+1] = '*';
    			int next = cury*n+curx+1;
    			q.offer(next);
    		}
    	}
    }
	
	
	
	//Sol 1: My Sol: DFS
    public void solve(char[][] board) 
    {
    	if(board==null || board.length<=1 || board[0].length<=1) return;
    	
    	int m = board.length;
    	int n = board[0].length;
    	
    	for(int i=0; i<m; i++)
    	{
    		if(board[i][0]=='O')
    		{
    			dfs(board,i,0);
    		}
    		if(board[i][n-1]=='O')
    		{
    			dfs(board,i,n-1);
    		}
    	}
    	
    	for(int j=0; j<n; j++)
    	{
    		if(board[0][j]=='O')
    		{
    			dfs(board,0,j);
    		}
    		if(board[m-1][j]=='O')
    		{
    			dfs(board,m-1,j);
    		}
    	}
    	
    	for(int i=0; i<board.length; i++)
    	{
    		for(int j=0; j<board[0].length; j++)
    		{
    			if(board[i][j]=='*') board[i][j] = 'O';
    			else if(board[i][j]=='O') board[i][j] = 'X';
    		}
    		
    	}
    }
    
    public void dfs(char[][] board, int y, int x)
    {
    	if(board[y][x]=='O')
    	{
    		board[y][x] = '*';
    		if(y>1) dfs(board,y-1,x);
    		if(y<(board.length-1)) dfs(board,y+1,x);
    		if(x>1) dfs(board,y,x-1);
    		if(x<(board[0].length-1)) dfs(board,y,x+1);
    	}
    }
}
