package leetcode51to100;

import java.util.ArrayList;
import java.util.List;

public class NQueens_51 
{
	
	//My Solution !!! Perfect !!! revisit
    public List<List<String>> solveNQueens(int n) 
    {
        List<List<String>> result = new ArrayList<List<String>>();
        
        if(n<=0) return result;
        if(n==1)
        {
            List<String> n1 = new ArrayList<String>();
            n1.add("Q");
            result.add(n1);
            return result;
        }
        
        boolean[] vertical = new boolean[n];
        boolean[] youxie = new boolean[2*n-1];
        boolean[] zuoxie = new boolean[2*n-1];
        
        int[] res = new int[n];
        
        
        solvehelper(res,0,vertical,zuoxie,youxie,n,result);
        return result;
    }
    
    public void solvehelper(int[] res, int row, boolean[] vertical, boolean[] zuoxie, boolean[] youxie, int n, List<List<String>> result)
    {
        if(row==n)
        {
            List<String> sol = new ArrayList<String>();
            for(int i=0; i<res.length; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<res[i];j++)
                {
                    sb.append('.');
                }
                sb.append("Q");
                for(int k=res[i]+1; k<n; k++)
                {
                    sb.append('.');
                }
                sol.add(sb.toString());
            }
            result.add(sol);
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
