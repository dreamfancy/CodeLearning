package leetcode51to100;

public class SearchA2DMatrix_74 {
	
	//My Solution : Good
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int y=m-1;
        int x=0;
        
        while(y>=0)
        {
            if(matrix[y][0]==target) return true;
            else if(matrix[y][0]>target) y--;
            else break;
        }
        if(y<0) return false;
        
        while(x<n)
        {
            if(matrix[y][x]==target) return true;
            else if(matrix[y][x]<target) x++;
            else return false;
        }
        
        return false;
    }
    
    //Official Solution 1:

    /*
    	int n = matrix.size();
        int m = matrix[0].size();
        int l = 0, r = m * n - 1;
        while (l != r){
            int mid = (l + r - 1) >> 1;
            if (matrix[mid / m][mid % m] < target)
                l = mid + 1;
            else 
                r = mid;
        }
        return matrix[r / m][r % m] == target;
    }
    */
    
    
}
