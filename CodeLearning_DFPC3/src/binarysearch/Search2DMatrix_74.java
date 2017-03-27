package binarysearch;

public class Search2DMatrix_74 {
	
	//solution_4 provided by Zizuo:
	//Treat 2d array as 1d array
	//array[0]  = matrix[0][0];
	//array[rows*columns-1] = matrix[row-1][column-1];
	//array[mid] = matrix[mid/column][mid%column];
    public boolean searchMatrix_Sol_4(int[][] matrix, int target) {
    	
    	if(matrix == null||matrix.length == 0||matrix[0].length==0) return false;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	int first = 0, last = m*n-1;
    	int mid;
    	
    	while(first+1<last)
    	{
    		mid = first + (last-first)/2;
    		if(matrix[mid/n][mid%n]==target) return true;
    		else if(matrix[mid/n][mid%n]<target) first = mid;
    		else last = mid;
    	}
    	if(matrix[first/n][first%n] == target) return true;
    	else if (matrix[last/n][last%n] == target) return true;
    	
    	return false;
    }
	
	//Solution 3 for first level
	//Solution 3:
    public boolean searchMatrix_Sol_3(int[][] matrix, int target) {
        
    	if(matrix == null||matrix.length == 0||matrix[0] == null|| matrix[0].length==0) return false;
    	int m = matrix.length;
    	int n = matrix[0].length;
 
    	if(m==1)
    		return binarySearchRow(matrix,target,0);
    	
    	int first = 0, last =m-1;
    	int medium;
    	while(first<=last)  //Solution 1
    	{
    		medium = first + (last-first)/2;
    		
    		if(matrix[medium][n-1]==target) return true;
    		else if(matrix[medium][n-1]<target) first = medium+1;
    		else last =medium-1;
    	}  
    	
    	if(first>matrix.length-1) return false;
    	return binarySearchRow(matrix,target,first);
    	    
    }
	
	
	//Solution 3 for first level
    public boolean searchMatrix(int[][] matrix, int target) {
        
    	if(matrix == null||matrix.length == 0||matrix[0].length==0) return false;
    	int m = matrix.length;
    	int n = matrix[0].length;
 
    	if(m==1)
    		return binarySearchRow(matrix,target,0);
    	
    	int first = 0, last =m-1;
    	int medium;
    	while(first+1<last)  //Solution 1
    	{
    		medium = first + (last-first)/2;
    		
    		if(matrix[medium][n-1]==target) return true;
    		else if(matrix[medium][n-1]<target) first = medium;
    		else last =medium;
    	}  
    	
    	if(matrix[last][n-1]==target) return true;
    	else if(matrix[first][n-1] == target) return true;
    	else if(matrix[first][n-1]>target)
    	{
    	    return binarySearchRow(matrix,target,first);
    	    
    	}
    	else if(matrix[last][n-1]>target)
    	{
    	    System.out.println(first+" "+last);
    		return binarySearchRow(matrix,target,last);
    	}
    	
    	return false;
    }
    
    
    //Solution 1
    public boolean binarySearchRow_Sol_1(int[][] matrix, int target, int row)
    {
    	if(matrix[row].length == 0) return false;
    	if(matrix[row].length == 1) 
    	{
    		if(matrix[row][0]==target) return true;
    		else return false;
    	}
    	int start = 0,end = matrix[row].length-1;
    	int mid;
    	while(start+1<end)
    	{
    		mid = start +(end-start)/2;
    		if(matrix[row][mid]==target) return true;
    		else if(matrix[row][mid]<target)
    			start = mid;
    		else end = mid;
    	}
    	if(matrix[row][start]==target || matrix[row][end]==target) return true;
    	
    	return false;
    }
    //Solution 3
    public boolean binarySearchRow(int[][] matrix, int target, int row)
    {
    	if(matrix[row].length == 0) return false;
    	if(matrix[row].length == 1) 
    	{
    		if(matrix[row][0]==target) return true;
    		else return false;
    	}
    	int start = 0,end = matrix[row].length-1;
    	int mid;
    	while(start<=end)
    	{
    		mid = start +(end-start)/2;
    		if(matrix[row][mid]==target) return true;
    		else if(matrix[row][mid]<target)
    			start = mid+1;
    		else end = mid-1;
    	}
    	if(start>matrix[row].length-1) return false;
    	if(matrix[row][start] == target) return true;
    	return false;
    }
}
