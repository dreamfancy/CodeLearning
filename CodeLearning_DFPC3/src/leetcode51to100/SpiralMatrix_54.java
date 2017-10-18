package leetcode51to100;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 
{
	
	//My solution: Best
	//Recursion and consider the edge case separately
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> result = new ArrayList<Integer>();
    	if(matrix==null || matrix.length==0 || matrix[0].length==0) return result;
        
        int m = matrix.length;
        int n = matrix[0].length;
        traverseOneRound(matrix,0,0,n,m,result);
        return result;
        
    }
    
    public void traverseOneRound(int[][] matrix, int starty, int startx, int n, int m, List<Integer> result)
    {
        if(m<=0 || n<=0) return;
        
        for(int i=0; i<n-1; i++)
        {
            result.add(matrix[starty][startx+i]);
        }
        
        for(int j=0; j<m-1; j++)
        {
            result.add(matrix[starty+j][startx+n-1]);
        }
        
        
        if(m==1 && n==1)
        {
            result.add(matrix[starty][startx]);
        }
        else 
        {
            if(m!=1)
            {
                for(int k=0; k<n-1; k++)
                {
                    result.add(matrix[starty+m-1][startx+n-1-k]);
                }
            }
            else
            {
                result.add(matrix[starty][startx+n-1]);
            }

            if(n!=1)
            {    
                for(int l=0; l<m-1; l++)
                {
                    result.add(matrix[starty+m-1-l][startx]);
                }
            }
            else
            {
                result.add(matrix[starty+m-1][startx]);
            }
        }

        traverseOneRound(matrix,starty+1,startx+1,n-2,m-2,result);

        
    }


}
