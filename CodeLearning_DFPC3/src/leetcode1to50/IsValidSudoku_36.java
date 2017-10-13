package leetcode1to50;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku_36 
{
	//LC High rated solution 1: Because number is only from 1-9 (limited), and there
	//are only two states: visited / non-visited ---> boolean[] array
    public boolean isValidSudoku_2(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
		return false;
	// check each column
	for (int i = 0; i < 9; i++) {
		boolean[] m = new boolean[9];
		for (int j = 0; j < 9; j++) {
			if (board[i][j] != '.') {
				if (m[(int) (board[i][j] - '1')]) {
					return false;
				}
				m[(int) (board[i][j] - '1')] = true;
			}
		}
	}
 
	//check each row
	for (int j = 0; j < 9; j++) {
		boolean[] m = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if (board[i][j] != '.') {
				if (m[(int) (board[i][j] - '1')]) {
					return false;
				}
				m[(int) (board[i][j] - '1')] = true;
			}
		}
	}
 
	//check each 3*3 matrix
	for (int block = 0; block < 9; block++) {
		boolean[] m = new boolean[9];
		for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
			for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
				if (board[i][j] != '.') {
					if (m[(int) (board[i][j] - '1')]) {
						return false;
					}
					m[(int) (board[i][j] - '1')] = true;
				}
			}
		}
	}
 
	return true;
    }
	
	//My Solution 1: for loop traverse matrix example
	// make sure phisical meaning of value is clear
    public boolean isValidSudoku_1(char[][] board) 
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
