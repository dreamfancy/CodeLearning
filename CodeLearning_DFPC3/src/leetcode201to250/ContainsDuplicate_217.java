package leetcode201to250;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ContainsDuplicate_217 
{
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
        
        Collections.sort(pointlist, new Comparator<Point>()
        		{
        			@Override
        			public int compare(Point p1, Point p2)
        			{
        				if(p1.x>p2.x) return 1;
        				else if(p1.x<p2.x) return -1;
        				else
        				{
        					if(p1.start==true && p2.start==true)
        					{
        						return -p1.val + p2.val;
        					}
        					else if(p1.start==false && p2.start==false)
        					{
        						return p1.val-p2.val;
        					}
        					else if(p1.start==true && p2.start==false)
        					{
        						return 1;
        					}
        					else
        					{
        						return -1;
        					}
        				}
        			}
        		});
        /*
        PriorityQueue<Point> prioq = new PriorityQueue<Point>(new Comparator()
        		{
        			@Override
        			public int compare(Object p1, Object p2)
        			{
        				return ((Point)p2).val - ((Point)p1).val;
        			}
        		});
        */
        
        PriorityQueue<Integer> prioq = new PriorityQueue<Integer>(new Comparator()
		{
			@Override
			public int compare(Object p1, Object p2)
			{
				return (Integer)p2 - (Integer)p1;
			}
		});
        
        prioq.offer(0);
                
        for(int i=0; i<pointlist.size(); i++)
        {
        	Point curpoint = pointlist.get(i);
        	if(curpoint.start && curpoint.val>prioq.peek())
        	{
        		prioq.offer(curpoint.val);
        		int[] newpoint = new int[2];
        		newpoint[0] = curpoint.x;
        		newpoint[1] = prioq.peek();
                result.add(newpoint);
        	}
            else if (curpoint.start)
            {
                prioq.offer(curpoint.val);
            }
                
        	else if(!curpoint.start && curpoint.val== prioq.peek())
        	{
        		prioq.poll();
        		int next = prioq.peek();
        		int[] newpoint = new int[2];
        		newpoint[0] = curpoint.x;
        		newpoint[1] = prioq.peek();
                result.add(newpoint);
        	}
            else
            {
                prioq.remove(new Integer(curpoint.val));
            }
        }
        return result;
    }
    
    class Point
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
    }

}
