package leetcode251to300;

import java.util.List;

public class ZigzagIterator_281 
{
	public class ZigzagIterator {

	    int size1,size2;
	    boolean point1;
	    int cur = -1;
	    List<Integer> v1;
	    List<Integer> v2;
	    public ZigzagIterator(List<Integer> _v1, List<Integer> _v2) 
	    {
	        v1 = _v1;
	        v2 = _v2;
	        
	        size1 = 0;
	        if(v1!=null) size1 = v1.size();
	        size2 = 0;
	        if(v2!=null) size2 = v2.size();
	        point1 = false;      
	    }

	    public int next() 
	    {
	        if(point1==true) return v1.get(cur);
	        else return v2.get(cur);
	    }

	    public boolean hasNext() 
	    {
	        if(point1==true)
	        {
	            if(cur<size2)
	            {
	                point1 = false;
	                return true;
	            }
	            else if((cur+1)<size1)
	            {
	                cur++;
	                return true;
	            }
	            return false;
	        }
	        else
	        {
	            if((cur+1)<size1)
	            {
	                point1 = true;
	                cur++;
	                return true;
	            }
	            else if((cur+1)<size2)
	            {
	                cur++;
	                return true;
	            }
	            return false;
	        }
	    }
	}	
	
	

}
