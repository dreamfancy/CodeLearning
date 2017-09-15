package first100;

import java.util.HashSet;

public class ValidSudoku_36 {

	
	public boolean isValidSudoku(char[][] board) {
        int rows_l = board.length;
        int cols_l = board[0].length;
        
        if (rows_l != 9 || cols_l != 9)
            return false;
        
        for (int r = 0; r < rows_l; r++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> boxes = new HashSet<>();
            for (int c = 0; c < cols_l; c++){
                if (board[r][c] != '.'){
                    if(rows.contains(board[r][c]))
                        return false;
                    else 
                        rows.add(board[r][c]);
                }
                if (board[c][r] != '.'){
                    if(cols.contains(board[c][r]))
                        return false;
                    else 
                        cols.add(board[c][r]);
                }
                int box_row = (3*(r/3)) + (c/3);
                int box_col = (3*(r%3)) + (c%3);
                if (board[box_row][box_col] != '.'){
                    if(boxes.contains(board[box_row][box_col]))
                        return false;
                    else 
                        boxes.add(board[box_row][box_col]);
                }
            
            }
        }
        return true;
    }
}
