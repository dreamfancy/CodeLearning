package leetcode131to160;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine_149 
{
    public int maxPoints(Point[] points) {

        if(points==null || points.length==0) return 0;
        if(points.length==1) return 1;
        if(points.length==2) return 2;
        int max = 0;
        
        for(int i=0; i<points.length; i++)
        {
            Map<Double,Integer> hash = new HashMap<Double, Integer>();
            int vertical = 1;
            int duplicate = 0;
            for(int j=i+1;j<points.length; j++)
            {
                if(points[i].x == points[j].x)
                {
                    if(points[i].y == points[j].y) duplicate++;
                    else vertical++;
                }
                else
                {
            
                    double slope = 1.00 * (points[j].y - points[i].y) / (points[j].x - points[i].x);
                    if(points[j].y == points[i].y) slope = 0.0;
                    System.out.println(slope);
                    if(hash.get(slope)!=null)
                    {
                        hash.put(slope,hash.get(slope)+1);
                    }
                    else
                    {
                        hash.put(slope,2);
                    }   
                }
            }
            
            for(int count: hash.values())
            {
                if((count+duplicate) >max)
                {
                    max = count + duplicate;
                }
            }
            max = Math.max(vertical + duplicate, max);
        }
        
     return max;   
    }
}
