package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle_2_119 
{
	//Solution 2: Find some relationship between different levels
	//Because the size of array is continously growing, we can 
	//use the reversed sequence to traverse
	
	
	
	
	
	// Solution 1: My solution: Consider using queue when index>=3
    public List<Integer> getRow(int rowIndex) 
    {
    	LinkedList<Integer> result = new LinkedList<Integer>();
    	//if(rowIndex<=0) return result;
    	//result.addLast(1);
    	result.addLast(1);
        if(rowIndex<=0) return result;
    	
        result.addLast(1);
    	if(rowIndex==1) return result;
        
   		result.removeLast();
   		result.addLast(2);
   		result.addLast(1);
   		if(rowIndex==2) return result;
    	
    	for(int i=3; i<=rowIndex; i++)
    	{
    		while(result.get(1)!=1)
    		{
    			result.addLast(result.getFirst()+result.get(1));
    			result.removeFirst();
    		}
			result.addLast(result.getFirst()+result.get(1));
			result.removeFirst();
			result.addLast(1);
    	}
    	return result;
    }
    
}
