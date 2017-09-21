package first100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 
{  
	
	//Good Example to Use Sort Collections with Comparator!!!
	public List<Interval> merge(List<Interval> intervals) 
	{
		List<Interval> result = new ArrayList<Interval>();
		if(intervals==null || intervals.size()==0) return result;
		if(intervals.size()==1)
		{
			result.add(intervals.get(0));
			return result;
		}
		Collections.sort(intervals,new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2)
			{
				if(i1.start!=i2.start) return i1.start-i2.start;
				else return i1.end-i2.end;
			}	
		});
		
		Interval pre = intervals.get(0);
		for(int i=1;i<intervals.size(); i++)
		{
			Interval cur = intervals.get(i);
			if(cur.start>pre.end)
			{
				result.add(pre);
				pre = cur;
			}
			else
			{
				Interval merged = new Interval(pre.start,Math.max(pre.end,cur.end));
				pre = merged;
			}
		}
		
		result.add(pre);
		
		return result;
	}
	
	//Solution: Program creek:

	
	//My solution 2: different understanding of the questions
	public List<Interval> merge_2(List<Interval> intervals) 
	{
		List<Interval> result = new ArrayList<Interval>();
		if(intervals==null || intervals.size()==0) return result;
		if(intervals.size()==1)
		{
			result.add(intervals.get(0));
			return result;
		}
		//int start = 0;
		//int end = 0;
		int cur = 1;
		int preEndValue = intervals.get(0).end;
		int curStart = intervals.get(0).start;
		int curEnd = intervals.get(0).end;
		while(cur<intervals.size())
		{
			if(intervals.get(cur).start>preEndValue)
			{
				result.add(new Interval(curStart,curEnd));
				//start = cur;
				preEndValue = intervals.get(cur).end;
				curStart = intervals.get(cur).start;
				curEnd = intervals.get(cur).end;
				//cur++;
			}
			else
			{
				curStart = Math.min(curStart, intervals.get(cur).start);
				curEnd = Math.max(curEnd, intervals.get(cur).end);
			}
			cur++;
		}
			result.add(new Interval(curStart,curEnd));
			
		return result;
	}
    

	//My Soltuion 1 :Different understanding of the question 
	public List<Interval> merge_MySolution_1(List<Interval> intervals) 
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
