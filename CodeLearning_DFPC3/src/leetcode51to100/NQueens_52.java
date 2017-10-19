package leetcode51to100;

public class NQueens_52 {
    public int totalNQueens(int n) 
    {
        int[] result = new int[1];         
        if(n<=0) return 0;
        if(n==1)
        {
            return 1;
        }
        
        boolean[] vertical = new boolean[n];
        boolean[] youxie = new boolean[2*n-1];
        boolean[] zuoxie = new boolean[2*n-1];
        
        int[] res = new int[n];
        
        
        solvehelper(res,0,vertical,zuoxie,youxie,n,result);
        return result[0];
    }
    
    public void solvehelper(int[] res, int row, boolean[] vertical, boolean[] zuoxie, boolean[] youxie, int n, int[] result)
    {
        if(row==n)
        {
            result[0]++;
        }
        
        
        for(int col=0; col<n; col++)
        {
            if(vertical[col]==false && zuoxie[col+n-1-row]==false && youxie[col+row]==false)
            {
                res[row] = col;
                vertical[col] = true;
                zuoxie[col+n-1-row] = true;
                youxie[col+row] = true;
                solvehelper(res,row+1,vertical,zuoxie,youxie,n,result);
                vertical[col] = false;
                zuoxie[col+n-1-row] = false;
                youxie[col+row] = false;
            }
        }
    }
}
