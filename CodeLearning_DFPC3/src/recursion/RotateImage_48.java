package recursion;

public class RotateImage_48 
{    
	public void rotate(int[][] matrix) 
	{
		//As per the discription of the question, the h_length and v_length of the matrix is always same as n.
		if(matrix==null || matrix.length==0) return;
		int n = matrix.length;
		rotate(matrix,0,n);
		
	}
	
	//public void rotate(int[][] matrix, int start, int h_length, int v_length)
	//Control for loop as 0->n-2 without change!!!
	public void rotate(int[][] matrix, int start, int n)
	{
		if(n==0 || n==1) return;
		int[] temp = new int[n];
		for(int i=0; i<n-1; i++)
		{
			temp[i] = matrix[start][start+i];
		}
		for(int i=0; i<n-1; i++)
		{
			matrix[start][start+i] = matrix[start+n-1-i][start];
		}
		for(int i=0; i<n-1; i++)
		{
			matrix[start+n-1-i][start] = matrix[start+n-1][start+n-1-i];
		}
		for(int i=0; i<n-1; i++)
		{
			matrix[start+n-1][start+n-1-i] = matrix[start+i][start+n-1];
		}
		for(int i=0; i<n-1; i++)
		{
			matrix[start+i][start+n-1] = temp[i];
		}
		rotate(matrix,start+1,n-2);
	}

}
