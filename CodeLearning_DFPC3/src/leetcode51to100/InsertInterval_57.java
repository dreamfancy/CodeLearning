package leetcode51to100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval_57 
{
	//My Solution:
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) 
    {
           if(newInterval==null) return intervals;
           List<Interval> result = new ArrayList<Interval>();
           if(intervals==null || intervals.size()==0) 
           {
               result.add(newInterval);
               return result;
           }
            
            Collections.sort(intervals, new Comparator<Interval>()
            {
                @Override
                public int compare(Interval i1, Interval i2)
                {
                    return i1.start-i2.start;
                }
                                 
            });
            
            int curstart = newInterval.start;
            int curend = newInterval.end;
            boolean flag = false;
            
            if(curend<intervals.get(0).start)
            {
                result.add(newInterval);
                result.addAll(intervals);
                return result;
            }
            
            if(curstart>intervals.get(intervals.size()-1).end)
            {
                result.addAll(intervals);
                result.add(newInterval);
                return result;
            }
        
            for(int i=0; i<intervals.size(); i++)
            {
                if(curstart>intervals.get(i).end)
                {
                    result.add(intervals.get(i));
                    continue;
                }
                else if(curend>=intervals.get(i).start)
                {
                    curstart = Math.min(intervals.get(i).start,curstart);
                    curend = Math.max(intervals.get(i).end,curend);
                }
                else
                {
                    if(flag==false)
                    {
                        result.add(new Interval(curstart,curend));
                        flag = true;
                    }
                    result.add(intervals.get(i));
                }
            }
            if(flag==false)
            {
                result.add(new Interval(curstart,curend));
                flag = true;
            } 
        return result;
    }
}
