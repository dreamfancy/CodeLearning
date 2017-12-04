package leetcode201to250;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TheSkylinePAlindrome_2_Optimization_214 
{
	//Optimization 2: Instead of using the PriorityQueue with duplicates, can we use treeMap
	//TreeMap is the optimized priority queue when there are duplicates
    public List<int[]> getSkyline(int[][] buildings) 
    {
        List<int[]> result = new ArrayList<int[]>();
        if(buildings==null || buildings.length==0 || buildings[0].length==0)
            return result;
        
        List<Point> pointlist = new ArrayList<Point>();
        for(int[] building: buildings)
        {
        	Point p1 = new Point(building[0],building[2],true);
        	Point p2 = new Point(building[1],building[2],false);
        	pointlist.add(p1);
        	pointlist.add(p2);
        }
        
        Collections.sort(pointlist);
 
        TreeMap<Integer,Integer> treemap = new TreeMap<Integer,Integer>();
        treemap.put(0,1);  //Both TreeMap and PriorityQueue needs to be initialized properly
        
        int premaxheight = 0;
        int curmaxheight = 0;
        for(int i=0; i<pointlist.size(); i++)
        {
        	Point curpoint = pointlist.get(i);
        	if(curpoint.start)
        	{
        		if(treemap.containsKey(curpoint.val))
        		{
        			treemap.put(curpoint.val, treemap.get(curpoint.val)+1);
        		}
        		else
        		{
        			treemap.put(curpoint.val, 1);
        		}
        	}
        	else
        	{
        		if(treemap.get(curpoint.val)==1)
        		{
        			treemap.remove(new Integer(curpoint.val));
        		}
        		else
        		{
        			treemap.put(curpoint.val,treemap.get(curpoint.val)-1);
        		}
        	}
        	curmaxheight = treemap.lastKey();  //Should declare as TreeMap to use the following functions:
        	//treemap.firstKey() treemap.lastKey() treemap.lastEntry() treemap.firstEntry()
        	if(premaxheight!=curmaxheight)
        	{
        		result.add(new int[]{curpoint.x,curmaxheight});
        		premaxheight = curmaxheight;
        	}
        }
        return result;
    }
    
    class Point implements Comparable<Point>
    {
    	int x;
    	int val;
    	boolean start;
    	
    	public Point(int _x, int _val, boolean _start)
    	{
    		x = _x;
    		val = _val;
    		start = _start;
    	}
		@Override
		public int compareTo(Point p2)
		{
			if(this.x>p2.x) return 1;
			else if(this.x<p2.x) return -1;
			else
			{
				if(this.start==true && p2.start==true)
				{
					return -this.val + p2.val;
				}
				else if(this.start==false && p2.start==false)
				{
					return this.val-p2.val;
				}
				else if(this.start==true && p2.start==false)
				{
					return -1;
				}
				else if(this.start==false && p2.start==true)
				{
					return 1;
				}
			}
            return 0;
		}
    	
    }


}
