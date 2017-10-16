package leetcode1to50;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver_37 {
	
	//My Solution 2: Jianzhi for the solution 1 below
    public void solveSudoku_2(char[][] board) 
    {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }   
    
    public boolean solve_2(char[][] board)
    {
    	for(int i=0; i<board.length; i++)
    	{
    		for(int j=0; j<board.length; j++)
    		{
    			if(board[i][j]=='.')
    			{
    				for(char c='1'; c<='9'; c++)  //!!!REvisit
    				{
    					board[i][j] = c;
    					if(isValidSudoku_1(board,i,j) && solve(board))
    					{
    						return true;
    					}
    					else board[i][j]='.';
 
    				}
    				return false;
    			}
    		}
    	}
    	return true;
    }
     
	
		
    public boolean isValidSudoku_1(char[][] board, int i, int j)
    {
        boolean[] horizontal = new boolean[9];
        boolean[] vertical = new boolean[9];
        boolean[] square = new boolean[9];

        for(int a=0; a<9; a++)
        {
            if(board[i][a]!='.')
            {
                if(horizontal[board[i][a]-'1']==false)
                {
                    horizontal[board[i][a]-'1'] = true;
                }
                else return false;
            }
        }
        for(int b=0; b<9; b++)
        {
            if(board[b][j]!='.')
            {

                if(vertical[board[b][j]-'1']==false)
                {
                    vertical[board[b][j]-'1'] = true;
                }
                else return false;
            }
        }
        for(int c=0; c<9; c++)
        {
            if(board[i/3*3+c/3][j/3*3 + c%3]!='.')
            {
                if(square[board[(i/3)*3+c/3][(j/3)*3 + c%3]-'1']==false)
                {
                   square[board[(i/3)*3+c/3][(j/3)*3 + c%3]-'1'] = true;
                }
                else return false;
            }
        }
        return true;   
    }
	
	
	
	
	//My solution 1: Use Question Valid_Sudoku_36, 5 out of 6 cases passed with time limit exceed for the last one
    public void solveSudoku_1(char[][] board) 
    {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }   
    
    public boolean solve(char[][] board)
    {
    	for(int i=0; i<board.length; i++)
    	{
    		for(int j=0; j<board.length; j++)
    		{
    			if(board[i][j]=='.')
    			{
    				for(char c='1'; c<='9'; c++)  //!!!REvisit
    				{
    					board[i][j] = c;
    					if(isValidSudoku(board) && solve(board))
    					{
    						return true;
    					}
    					else board[i][j]='.';
 
    				}
    				return false;
    			}
    		}
    	}
    	return true;
    }
     
	
	
	
	
    public boolean isValidSudoku(char[][] board) 
    {
        if(board==null || board.length!=9 || board[0].length!=9) return false;
        
        Set<Integer> matchSet = new HashSet<Integer>();
        
        for(int i=1; i<=9; i++) matchSet.add(i);
        for(int row=0; row<9; row++)
        {
            Set<Integer> curSet = new HashSet<Integer>(matchSet);
            //Set<Integer> curSet = matchSet.clone();
            for(int c=0; c<9; c++)
            {
                int num = board[row][c]-'0';
                if(num>=1 && num<=9)
                {
                    if(curSet.remove(num)==false) return false;
                }
                else if (board[row][c]!='.')
                    return false;
            }
        }
        
        for(int col=0; col<9; col++)
        {
            Set<Integer> curSet = new HashSet<Integer>(matchSet);
            //Set<Integer> curSet = matchSet.clone();
            for(int c=0; c<9; c++)
            {
                int num = board[c][col]-'0';
                if(num>=1 && num<=9)
                {
                    if(curSet.remove(num)==false) return false;
                }
                else if (board[c][col]!='.')
                    return false;
            }   
        }
        for(int x=0; x<9; x=x+3)
        {
            for(int y=0; y<9; y=y+3)
            {
                Set<Integer> curSet = new HashSet<Integer>(matchSet);
                if(checkSquare(board,x,y,curSet)==false) return false;
            }
        }
        
        
        return true;   
    }
    
    public boolean checkSquare(char[][] board, int startx, int starty, Set<Integer> curSet)
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                int num = board[startx+i][starty+j]-'0';
                if(num>=1 && num<=9)
                {
                    if(curSet.remove(num)==false) return false;
                }
                else if (board[startx+i][starty+j]!='.')
                    return false;
            }
        }
        return true;
    }
}
