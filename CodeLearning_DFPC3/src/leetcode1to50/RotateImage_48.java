package leetcode1to50;

public class RotateImage_48 
{
	//My Solution
    public void rotate(int[][] matrix) 
    {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return;
        
        if(matrix.length!=matrix[0].length) return;
        
        int n = matrix.length;
        
        rotateround(matrix,0,0,n);
    }
    
    public void rotateround(int[][] matrix, int starty, int startx, int n)
    {
        if(n<=1) return;
        
        int[] temp = new int[n-1];
        
        for(int i=0; i<n-1; i++)
        {
            temp[i] = matrix[starty][startx+i];      
        }
        
        for(int i=0; i<n-1; i++)
        {
            matrix[starty][startx+i] = matrix[starty+n-1-i][startx];
        
        }
        
        for(int i=0; i<n-1; i++)
        {
            matrix[starty+n-1-i][startx] = matrix[starty+n-1][startx+n-1-i];
        }
        
        for(int i=0; i<n-1; i++)
        {
            matrix[starty+n-1][startx+n-1-i]= matrix[starty+i][startx+n-1];
        }
        
        for(int i=0; i<n-1; i++)
        {
            matrix[starty+i][startx+n-1] = temp[i];
        }
        
        rotateround(matrix,starty+1,startx+1,n-2);
    }

}
