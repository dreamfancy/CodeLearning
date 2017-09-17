package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens_51 
{
	
	
	//My Solutions 1: Recursion All test cases passed
	//n==4 will pass, n==9 time exceed limit
	public List<List<String>> solveNQueens(int n)
	{
		List<List<String>> result = new ArrayList<List<String>>();
		if(n<=0) return result;
		int[] cursol = new int[n];
		helper(n,0,cursol,result);
        
        return result;
	}
	
	public void helper(int n, int curRow, int[] cursol,List<List<String>> result)
	{
		if(curRow==n)
		{
            System.out.println("Reached bottom");
			List<String> rowResult = new ArrayList<String>();
			for(int i=0; i<cursol.length; i++)
			{
				StringBuilder sb = new StringBuilder();
				int queen = cursol[i]-1;
				int p=0;
				while(p<queen)
				{
					sb.append('.');
                    p++;
				}
				sb.append('Q');
				p++;
				while(p<n)
				{
					sb.append('.');
                    p++;
				}
				rowResult.add(sb.toString());
			}

            result.add(rowResult);

            return;
		}
		
		for(int j=0; j<n; j++)
		{
			boolean flag = true;
			for(int k=0; k<n; k++)
			{
				if(cursol[k]!=0 && (cursol[k] == (j+1))) flag = false;
                if(Math.abs(cursol[k]-j-1)==Math.abs(k-curRow)) flag = false;
			}
			
			if(flag)
			{
				cursol[curRow] = j+1;
                System.out.println("Add Queen in row " + curRow + " column" + j);
				helper(n, curRow+1, cursol,result);
				cursol[curRow] = 0;
			}
		}
	}

	//Solution 2: From online
	public class Solution {
	    List<List<String>> ret=new ArrayList<List<String>>();
	    public List<List<String>> solveNQueens(int n) {
	        int[] ps=new int[n];
	        Arrays.fill(ps,Integer.MIN_VALUE);
	        solve(ps,n,n);
	        return ret;
	    }
	    
		
	    void solve(int[] ps,int n,int len)
	    {
	        if(n==0)
	        {
	            List<String> entry=new ArrayList<String>();
	            for(int i=0;i<len;i++)
	            {
	                char[] s=new char[len];
	                Arrays.fill(s,'.');
	                s[ps[i]]='Q';
	                entry.add(String.valueOf(s));               
	            }
	            ret.add(entry);
	        }
	        else
	            for(ps[n-1]=len-1;ps[n-1]>=0;ps[n-1]--)
	            {
	                int i=len;
	                while(--i>n-1)
	                    if(ps[i]==ps[n-1]||Math.abs(ps[i]-ps[n-1])==Math.abs(n-1-i))break;
	                if(i>n-1)continue;
	                else solve(ps,n-1,len);
	            }            

	    }
	}
}
