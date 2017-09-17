package recursion;

public class SpiralMatrix_2_59 
{
    public int[][] generateMatrix(int n) 
    {
    	if(n==0) return new int[0][0];
    	if(n==1)
    	{
    		int[][] arr = new int[1][1];
    		arr[0][0] = 1;
    		return arr;
    	}
    	
    	int[][] arr = new int[n][n];
    	
    	int start = 0;
    	int size = n;
    	
    	return print(start,size,arr,1);	
    }
    
    private int[][] print(int start, int size, int[][] arr, int cur)
    {
    	if(size==0) return arr;
    	if(size==1)
    	{
    		arr[start][start] = cur;
    		return arr;
    	}
    	
    	for(int i=0; i<size-1; i++)
    	{
    		arr[start][start+i] = cur++;
    	}
    	for(int i=0; i<size-1; i++)
    	{
    		arr[start+i][start+size-1] = cur++;

    	}
    	for(int i=0; i<size-1; i++)
    	{
    		arr[start+size-1][start+size-1-i] = cur++;
    	}
    	for(int i=0; i<size-1; i++)
    	{
    		arr[start+size-1-i][start] = cur++;
    	}
    	
    	return print(start+1,size-2,arr,cur);
    }


}
