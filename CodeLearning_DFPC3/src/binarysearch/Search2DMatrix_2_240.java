package binarysearch;

public class Search2DMatrix_2_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
     
    	if(matrix == null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) 
    		return false;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	int startx = m-1;
    	int starty = 0;
    	
    	while(startx>=0 && starty<n)
    	{
    		if(matrix[startx][starty]==target) return true;
    		else if(matrix[startx][starty]<target) starty++;
    		else startx--;
    	}
    	return false;
    }
	
	
}
