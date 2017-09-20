package first100;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals_56 
{  
	public List<Interval> merge(List<Interval> intervals) 
	{
		List<Interval> result = new ArrayList<Interval>();
		if(intervals==null || intervals.size()==0) return result;
		if(intervals.size()==1)
		{
			result.add(intervals.get(0));
			return result;
		}
		int start = 0;
		//int end = 0;
		int cur = 1;
		int preEndValue = intervals.get(0).end;
		while(cur<intervals.size())
		{
			if(intervals.get(cur).start>preEndValue)
			{
				result.add(new Interval(intervals.get(start).start,intervals.get(cur-1).end));
				start = cur;
			}
			preEndValue = intervals.get(cur).end;
			cur++;
		}
		
		if(start == intervals.size()-1)
			result.add(intervals.get(intervals.size()-1));
		else
		{
			result.add(new Interval(intervals.get(start).start,intervals.get(intervals.size()-1).end));
		}
		return result;
	}
    

	

}
