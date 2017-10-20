package leetcode51to100;

public class SpiralMatrix_2_59 
{
    public int[][] generateMatrix(int n) {
        
        if(n<=0) return new int[0][0];
            
        int[][] matrix = new int[n][n];
        int count = 1;
        
        generateMatrix(n,matrix,0,0,1);
        return matrix;
    }
    
    public void generateMatrix(int n, int[][] matrix, int starty, int startx, int cur)
    {
        if(n==0) return;
        if(n==1)
        {
            matrix[starty][startx] = cur;
            return;
        }
        
        for(int i=0; i<(n-1); i++)
        {
            matrix[starty][startx+i] = cur++;
        }
        
        for(int i=0; i<(n-1); i++)
        {
            matrix[starty+i][startx+n-1] = cur++;
        }
        
        for(int i=0; i<(n-1); i++)
        {
            matrix[starty+n-1][startx+n-1-i] = cur++;
        }
        
        for(int i=0; i<(n-1); i++)
        {
            matrix[starty+n-1-i][startx] = cur++;
        }
        
        generateMatrix(n-2,matrix,starty+1,startx+1,cur);
    }
}
