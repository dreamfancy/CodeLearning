package recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
	
	
	//Solution 1: My Solution, not finished
	//m,n <=2 scenarios should be considered independently
    public List<Integer> spiralOrder_NonRec(int[][] matrix) 
    {
    	List<Integer> result = new ArrayList<Integer>();
    	if(matrix==null || matrix.length==0 || matrix[0].length==0) return result;
        int m=0, n=0;
        int mostRight = matrix[0].length-1;
        int mostBottom = matrix.length-1;
        
        int round = 0;
        
        //TODO: Add scenarios when m,n,<=2
        //while()
        while(2*round<=mostRight && 2*round<=mostBottom)
        {
        	while(m<mostRight-round)
        	{
        		result.add(matrix[n][m++]);
        	}
        	//m--;
        	while(n<mostBottom-round)
        	{
        		result.add(matrix[n++][m]);
        	}
        	//n--;
        	while(m>round)
        	{
        		result.add(matrix[n][m--]);
        	}
        	while(n>round)
        	{
        		result.add(matrix[n--][m]);
        	}
        	round++;
        } 
    	return result;
    }
    
    
    //Solution 2: Recursion
    
    //Overload the method
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0) 
            return new ArrayList<Integer>();
 
        return spiralOrder(matrix,0,0,matrix.length,matrix[0].length);
    }
 
 
    public ArrayList<Integer> spiralOrder(int [][] matrix, int x, int y, int m, int n){
        ArrayList<Integer> result = new ArrayList<Integer>();
 
        if(m<=0||n<=0) 
            return result;
 
        //only one element left
        if(m==1&&n==1) {
            result.add(matrix[x][y]);
            return result;
        }
 
        //top - move right
        for(int i=0;i<n-1;i++){
            result.add(matrix[x][y++]);
        }
 
        //right - move down
        for(int i=0;i<m-1;i++){
            result.add(matrix[x++][y]);
        }
 
        //bottom - move left
        if(m>1){    
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }
        }
 
        //left - move up
        if(n>1){
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }
        }
 
        if(m==1||n==1)
            result.addAll(spiralOrder(matrix, x, y, 1, 1));
        else    
            result.addAll(spiralOrder(matrix, x+1, y+1, m-2, n-2));
 
        return result;
    }

    //Solution 3: 
    public ArrayList<Integer> spiralOrder_Iter(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
 
        if(matrix == null || matrix.length == 0) return result;
 
        int m = matrix.length;
        int n = matrix[0].length;
 
        int x=0; 
        int y=0;
 
        while(m>0 && n>0){
 
            //if one row/column left, no circle can be formed
            if(m==1){
                for(int i=0; i<n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }
 
            //below, process a circle
 
            //top - move right
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y++]);
            }
 
            //right - move down
            for(int i=0;i<m-1;i++){
                result.add(matrix[x++][y]);
            }
 
            //bottom - move left
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }
 
            //left - move up
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }
 
            x++;
            y++;
            m=m-2;
            n=n-2;
        }
 
        return result;
    }
}
