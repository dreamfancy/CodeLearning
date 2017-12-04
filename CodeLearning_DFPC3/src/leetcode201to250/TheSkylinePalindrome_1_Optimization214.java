package leetcode201to250;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import leetcode201to250.TheSkylineProblem_218.Point;

public class TheSkylinePalindrome_1_Optimization214 
{
	
	//Optization 1:
	//Make the Collections.sort comparation in the Point class itself
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
                System.out.println("add");
        	}
            else if (curpoint.start)
            {
                prioq.offer(curpoint.val);
            }
                
        	else if(!curpoint.start && curpoint.val== prioq.peek())
        	{
        		prioq.poll();
        		int next = prioq.peek();
                if(next<curpoint.val)
                {
                    int[] newpoint = new int[2];
                    newpoint[0] = curpoint.x;
                    newpoint[1] = prioq.peek();
                    result.add(newpoint);
                    System.out.println("remove");
                }
            }
            else
            {
                prioq.remove(new Integer(curpoint.val));  //How to remove an int from priority queue
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
