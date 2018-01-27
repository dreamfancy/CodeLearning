package leetcode251to300;

public class GameOfLife_289 
{
    public void gameOfLife(int[][] board) 
    {
        if(board==null || board.length==0 || board[0].length==0) return;
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                processunit(board,i,j);
            }
        }
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j] = 0;
                }
                else if(board[i][j]==-1)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private void processunit(int[][] board, int i, int j)
    {
        boolean curdead = board[i][j]==0 ? true : false;
        int m = board.length;
        int n = board[0].length;
        int live = 0;
        int dead = 0;
        
        if(i>0 && j>0 && board[i-1][j-1]>=1) live++;
        else dead++;
        if(i>0 && board[i-1][j]>=1) live++;
        else dead++;
        if(i>0 && (j<n-1) && board[i-1][j+1]>=1) live++;
        else dead++;
        
        if(j>0 && board[i][j-1]>=1) live++;
        else dead++;
        if((j<n-1) && board[i][j+1]>=1) live++;
        else dead++;
        
        if(i<(m-1) && j>0 && board[i+1][j-1]>=1) live++;
        else dead++;
        if(i<(m-1) && board[i+1][j]>=1) live++;
        else dead++;
        if(i<(m-1) && (j<n-1) && board[i+1][j+1]>=1) live++;
        else dead++;
        
        
        if(curdead && live==3) board[i][j] = -1;
        if(!curdead && live<2) board[i][j] = 2;
        if(!curdead && live>3) board[i][j] = 2;
    }	

}
