package leetcode251to300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms_2_253 
{
	//Sol 1:
    public int minMeetingRooms_1(Interval[] intervals) 
    {
    	int[] start = new int[intervals.length];
    	int[] end = new int[intervals.length];
    	
    	for(int i=0; i<intervals.length; i++)
    	{
    		start[i] = intervals[i].start;
    		end[i] = intervals[i].end;
    	}
    	Arrays.sort(start);
    	Arrays.sort(end);
    	int res = 1;
    	int endi = 0;
    	for(int i=1; i<intervals.length; i++)
    	{
    		if(start[i]<end[endi])
    		{
    			res++;
    		}
    		else endi++; 
    	}
    	return res;	
    }
	
	
    public int minMeetingRooms_2(Interval[] intervals) 
    {
        if(intervals==null || intervals.length==0) return 0;
        if(intervals.length==1) return 1;
        Arrays.sort(intervals, new Comparator<Interval>()
                    {
                        @Override
                        public int compare(Interval i1, Interval i2)
                        {
                            return i1.start-i2.start;
                        }
                    });
       
        //Heap is the container of room!!!
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length,new Comparator<Interval>()
                                                                   {
                                                                       @Override
                                                                       public int compare(Interval a, Interval b)
                                                                       {
                                                                           return a.end-b.end;
                                                                       }
                                                                   });
        
       heap.offer(intervals[0]);
        for(int i=1; i<intervals.length; i++)
        {
            Interval interval = heap.poll();
            
        	if(intervals[i].start>=intervals[i].end)
        	{
        		interval.end = intervals[i].end;
        	}
        	else
        	{
        		heap.offer(intervals[i]);
        	}
            heap.offer(interval);
        }
		return heap.size();
    }
	

}
