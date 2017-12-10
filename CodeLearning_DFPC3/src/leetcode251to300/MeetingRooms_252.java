package leetcode251to300;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms_252 
{
    public boolean canAttendMeetings(Interval[] intervals) 
    {
        if(intervals==null || intervals.length<=1) return true;
        Arrays.sort(intervals, new Comparator<Interval>()
                    {
                        @Override
                        public int compare(Interval i1, Interval i2)
                        {
                            return i1.start-i2.start;
                        }
                    });
        
        int preend = intervals[0].end;
        
        for(int i=1; i<intervals.length; i++)
        {
            if(intervals[i].start<preend) return false;
            preend = intervals[i].end;
        }
        return true;
    }	

}
