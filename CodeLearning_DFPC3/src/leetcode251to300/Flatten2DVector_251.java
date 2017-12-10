package leetcode251to300;

import java.util.Iterator;
import java.util.List;

public class Flatten2DVector_251 
{
	//Sol 2: Keep all the ITERATOR in a queue to resolve empty level issue
    
	public class Vector2D_2 implements Iterator<Integer> {
	    
	    Iterator<List<Integer>> i;
	    Iterator<Integer> j;
	    public Vector2D_2(List<List<Integer>> vec2d) {
	        i = vec2d.iterator();
	    }

	    @Override
	    public Integer next() {
	        return j.next();
	    }

	    @Override
	    public boolean hasNext() {
	        while((j == null || !j.hasNext()) && i.hasNext())
	            j = i.next().iterator();
	        return j!=null && j.hasNext();
	    }
	}
	//sol 1: Revise.do not use totalcount
	
	
	//Sol 1: My solution.no change of data structure and keep the levels
	//Wrong cannot resolve if one or more levels are totally empty, such as
	//[[1],[],[]] so should not has the variable totallevel, totalinlist
	public class Vector2D_1 implements Iterator<Integer> 
	{
	       
	    int totallevel = 0;
	    int totalinlist = 0;
	    int curlevel = 0;
	    int curnum = 0;
	    List<List<Integer>> vec2d;
	    public Vector2D_1(List<List<Integer>> _vec2d) 
	    {
	        vec2d = _vec2d;
	        if(vec2d!=null && vec2d.size()>0)
	        {
	            totallevel = vec2d.size();
	            curlevel = 0;
	            totalinlist = vec2d.get(curlevel).size();
	            curnum = -1;
	        }
	    }

	    @Override
	    public Integer next() 
	    {
	        if(hasNext()==false) return -1;
	        
	        if(curnum<(totalinlist-1))
	        {
	            curnum++;
	        }
	        else
	        {
	            curlevel++;
	            if(curlevel>(totallevel-1))
	                return -1;
	            totalinlist = vec2d.get(curlevel).size();
	            if(totalinlist==0) return -1;
	            curnum = 0;
	        }
	        return vec2d.get(curlevel).get(curnum);

	    }

	    @Override
	    public boolean hasNext() 
	    {
	        if(vec2d==null || vec2d.size()==0) return false;
	        if(curlevel==(totallevel-1) && curnum==(totalinlist-1)) return false;
	        return true;
	        
	    }
	}

}
