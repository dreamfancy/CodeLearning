package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle_118 
{
    public List<List<Integer>> generate(int numRows) 
    {
    	if(numRows<=0) return new LinkedList<List<Integer>>();
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	List<Integer> first = new ArrayList<Integer>();
    	first.add(1);
    	result.add(first);
    	if(numRows==1) return result;
    	List<Integer> second = new ArrayList<Integer>();
    	second.add(1);
    	second.add(1);
    	result.add(second);
    	
    	List<Integer> pre = second;
    	
    	for(int i=2; i<numRows; i++)
    	{
    		List<Integer> cur = new ArrayList<Integer>();
    		cur.add(1);
    		for(int j=0; j<pre.size()-1; j++)
    		{
    			cur.add(pre.get(j)+pre.get(j+1));
    		}
    		cur.add(1);
    		result.add(cur);
    		pre = cur;
    	}
    	return result;
    }

}
