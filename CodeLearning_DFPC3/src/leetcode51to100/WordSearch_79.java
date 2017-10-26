package leetcode51to100;

public class WordSearch_79 
{
	//My Solution: Consider one node can only be visited for one time only!
    public boolean exist(char[][] board, String word) 
    {
        if(word==null || word.length()==0) return true;
        if(board==null || board.length==0 || board[0].length==0) return false;
        
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                boolean[][] visited = new boolean[m][n]; 
                if(checkMatching(board,i,j,word,0,visited))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkMatching(char[][] board, int i, int j, String word, int cur, boolean[][] visited)
    {
        if(board[i][j]!=word.charAt(cur)) return false;
        if(cur==word.length()-1) return true;
        
        visited[i][j] = true;
        
        if(i>0 && !visited[i-1][j] && checkMatching(board,i-1,j,word,cur+1,visited))
        {
            return true;
        }
        if(i<(board.length-1) && !visited[i+1][j] && checkMatching(board,i+1,j,word,cur+1, visited))
        {
            return true;
        }
        if(j>0 && !visited[i][j-1] && checkMatching(board,i,j-1,word,cur+1,visited))
        {
            return true;
        }
        if(j<(board[0].length-1) && !visited[i][j+1] && checkMatching(board,i,j+1,word,cur+1,visited))
        {
            return true;
        }
        
        //!!!Important!
        visited[i][j] = false;
        return false;
    }
    
    
    //Fancy solution
    // Use yihuo to save information in matrix
    public boolean exist_2(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
        	for (int x=0; x<board[y].length; x++) {
        		if (exist(board, y, x, w, 0)) return true;
        	}
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
    	if (i == word.length) return true;
    	if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
    	if (board[y][x] != word[i]) return false;
    	board[y][x] ^= 256;
    	boolean exist = exist(board, y, x+1, word, i+1)
    		|| exist(board, y, x-1, word, i+1)
    		|| exist(board, y+1, x, word, i+1)
    		|| exist(board, y-1, x, word, i+1);
    	board[y][x] ^= 256;
    	return exist;
    }

}
