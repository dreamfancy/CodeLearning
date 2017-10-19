package leetcode51to100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class MergeIntervals_56 
{   
	//Solution 3: Similar to the TreeMap: sort interval array by 
	public List<Interval> merge_3(List<Interval> intervals) 
	{
        if(intervals==null || intervals.size()<=1) return intervals;

		Collections.sort(intervals,new Comparator<Interval>()
				{
					@Override
					public int compare(Interval i1, Interval i2)
					{
						return i1.start-i2.start;
					}
				});
		
		List<Interval> result = new ArrayList<Interval>();
		Interval pre = intervals.get(0);
		for(int i=1; i<intervals.size(); i++)
		{
			Interval cur = intervals.get(i);
			if(cur.start<=pre.end)
			{
				pre.end = Math.max(cur.end,pre.end);
			}
			else
			{
				result.add(pre);
				pre = cur;
			}
		}
        
        result.add(pre);
		return result;	
	}
	
	//Solution 2: Use some treeMap methods
	public List<Interval> merge_2(List<Interval> intervals) 
	{
		if(intervals==null || intervals.size()<=1) return intervals;

		TreeMap<Integer,Integer> startmap= new TreeMap<Integer,Integer>();		
		for(int i=0; i<intervals.size(); i++)
		{
			int start = intervals.get(i).start;
			if(!startmap.containsKey(start))
			{
				startmap.put(start, i);
			}
			else
			{
				int end = intervals.get(i).end;
				int preend = intervals.get(startmap.get(start)).end;
				if(end>preend)
				{
					startmap.put(start,i);
				}
			}
		}
		List<Interval> res = new ArrayList<Interval>();
		
		int curStart = startmap.firstEntry().getKey();
		int curEnd = intervals.get(startmap.firstEntry().getValue()).end;
		while(startmap.ceilingEntry(curStart)!=null)
		{
			int nextStart = startmap.ceilingEntry(curStart).getKey();
			int nextEnd = intervals.get(startmap.get(nextStart)).end;
			if(nextStart>curEnd)
			{
				res.add(new Interval(curStart,curEnd));
                curStart = nextStart;
                curEnd = nextEnd;
			}
			else
			{
				curEnd = Math.max(curEnd,nextEnd);
			}
		}
		
		res.add(new Interval(curStart,curEnd));
		
		return res;
	}
	
	
	
	//My Solution 1: Use iterator of keySet of treeMap
	public List<Interval> merge_1(List<Interval> intervals) 
	{
		if(intervals==null || intervals.size()<=1) return intervals;

		TreeMap<Integer,Integer> startmap= new TreeMap<Integer,Integer>();		
		for(int i=0; i<intervals.size(); i++)
		{
			int start = intervals.get(i).start;
			if(!startmap.containsKey(start))
			{
				startmap.put(start, i);
			}
			else
			{
				int end = intervals.get(i).end;
				int preend = intervals.get(startmap.get(start)).end;
				if(end>preend)
				{
					startmap.put(start,i);
				}
			}
		}
		List<Interval> res = new ArrayList<Interval>();
		
		Iterator<Integer> iter = startmap.keySet().iterator();
		int curStart = iter.next();
		int curEnd = intervals.get(startmap.get(curStart)).end;
		while(iter.hasNext())
		{
			int nextStart = iter.next();
			int nextEnd = intervals.get(startmap.get(nextStart)).end;
			if(nextStart>curEnd)
			{
				res.add(new Interval(curStart,curEnd));
                curStart = nextStart;
                curEnd = nextEnd;
			}
			else
			{
				curEnd = Math.max(curEnd,nextEnd);
			}
		}
		
		res.add(new Interval(curStart,curEnd));
		
		return res;
	}

	

}
