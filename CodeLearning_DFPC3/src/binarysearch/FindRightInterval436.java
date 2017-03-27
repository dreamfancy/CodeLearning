package binarysearch;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
public class Interval {

    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
*/

public class FindRightInterval436 {

	public static int[] findRightInterval_MyOwn(Interval[] intervals) 
	{
		TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
	
		for(int i=0; i<intervals.length; i++)
		{
			tm.put(intervals[i].start,i);
		}
		
		int[] res = new int[intervals.length];

		for(int i=0; i<intervals.length;i++)
		{
			Entry<Integer,Integer> entry = tm.ceilingEntry(intervals[i].end); //Att!:Entry should always have generic type after it
			if(entry!=null)
			{
				res[i] = tm.get(entry.getValue());
			}
			else 
			{
				res[i] = -1;
			}		
		}
		return res;		
	}
	
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; ++i) {
            map.put(intervals[i].start, i);    
        }
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }
	
}
