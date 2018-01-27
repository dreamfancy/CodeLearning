package leetcode251to300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint_296 
{
    public int minTotalDistance(int[][] grid) 
    {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        
        List<Integer> xlist = new ArrayList<Integer>();
        List<Integer> ylist = new ArrayList<Integer>();
        
        
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(grid[i][j]==1)
                {
                    xlist.add(i);
                    ylist.add(j);
                }
            }
        }
        
        Collections.sort(xlist);
        Collections.sort(ylist);
        
        int midx = xlist.get(xlist.size()/2);
        int midy = ylist.get(ylist.size()/2);
        
        int sum = 0;
        for(int x: xlist)
        {
            sum += Math.abs(x-midx);
        }
        
        for(int y: ylist)
        {
            sum += Math.abs(y-midy);
        }
        
        return sum;
    }

}
