package first100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval_57 {
	
	//The question has stated that the intervals were initially sorted according to their start times...
	// new inteval(newstart,newend)
	
	//scan while(end <newstart) ++
	//when the first time end >newstart,	
	
	 // Official Solution 2:
	 public List<Interval> insert_BestSubmission(List<Interval> intervals, Interval newInterval) {
	        List<Interval> result = new ArrayList<Interval>();
	        if (intervals == null || intervals.size() == 0) {
	           result.add(newInterval);
	           return result;
	        }        
	        int size = intervals.size();
	        int newStart = newInterval.start;
	        int newEnd = newInterval.end;
	        int i = 0; 
	        
	        while( i < size && intervals.get(i).end < newStart){
	            result.add(intervals.get(i));
	            i++;
	        }
	        if(i == size){
	            result.add(newInterval);
	            return result;
	        }
	        newStart = Math.min(intervals.get(i).start, newStart);
	        
	        while( i < size && intervals.get(i).start <= newEnd){
	            newEnd = Math.max(intervals.get(i).end, newEnd);
	            i++;
	        }
	        result.add(new Interval(newStart, newEnd));
	        

	        while( i < size ){
	            result.add(intervals.get(i));
	            i++;
	        }
	        return result;        
	    }
	
	
	
	//Official solution
	public List<Interval> insert_LCDiscuss1(List<Interval> intervals, Interval newInterval) {
	    List<Interval> result = new LinkedList<>();
	    int i = 0;
	    // add all the intervals ending before newInterval starts
	    while (i < intervals.size() && intervals.get(i).end < newInterval.start)
	        result.add(intervals.get(i++));
	    // merge all overlapping intervals to one considering newInterval
	    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
	        newInterval = new Interval( // we could mutate newInterval here also
	                Math.min(newInterval.start, intervals.get(i).start),
	                Math.max(newInterval.end, intervals.get(i).end));
	        i++;
	    }
	    result.add(newInterval); // add the union of intervals we got
	    // add all the rest
	    while (i < intervals.size()) result.add(intervals.get(i++)); 
	    return result;
	}
	
	
	
	//My unfinished solution : logic is mess
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) 
    {
    	List<Interval> result = new LinkedList<Interval>();
    	
    	int newstart = newInterval.start;
    	int newend = newInterval.end;
    	
    	Interval insertedInterval = newInterval;
    	 
    	if(intervals==null || intervals.size()==0)
        {
            result.add(newInterval);
            return result;
        }
    	
    	int cur = 0;
		Interval curInterval = intervals.get(cur);

    	while(cur<intervals.size() && newstart>curInterval.end)
    	{
    		System.out.println("In loop 1");
    		curInterval = intervals.get(cur);
    		result.add(curInterval);
    		cur++;
    	}
    	if(cur==intervals.size())
    	{
    		System.out.println("In loop 2");
    		result.add(newInterval);
    		return result;
    	}
    	
    	if(cur<intervals.size() && newstart<=curInterval.end)
    	{
    		System.out.println("In loop 3");
    		insertedInterval.start = Math.min(curInterval.start,newstart);
    		insertedInterval.start = Math.max(curInterval.end,newstart);
    		cur++;
    	}
    	
    	while((cur<intervals.size() && newend>curInterval.end) || cur==(intervals.size()-1))
    	{
    		System.out.println("In loop 4");
    		curInterval = intervals.get(cur);
    		cur++;
    	}
    	if(cur<intervals.size() && newend<=curInterval.end)
    	{
    		System.out.println("In loop 5");
    		insertedInterval.end = curInterval.end;
    		result.add(insertedInterval);
    		cur++;
    	}
    	
    	while(cur<intervals.size())
    	{
    		System.out.println("In loop 6");
    		curInterval = intervals.get(cur);
    		result.add(curInterval);
    		cur++;
    	}
    	
    	return result;
    }

}
