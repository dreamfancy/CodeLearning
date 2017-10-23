package leetcode51to100;

public class SqrtX_69 
{
	//Bit Operation
	//
	
	
	
	//Updated My Solution, Accepted
	//Need to Revisit
	   public int mySqrt_1(int x) 
	    {
	        if(x<0) return -1;
	        if(x==0 || x==1) return x;
	        
	        int start = 1;
	        int end = x;
	        
	        while(start<(end-1))
	        {
	            int mid = start +(end-start)/2;
	            int cur = x/mid;
	            if(mid==cur) return mid;            
	            else if(mid<cur)
	            {
	                start = mid;
	            }
	            else 
	            {
	                end = mid-1;
	            }
	        }
	        System.out.println("Start "+start);
	        System.out.println("End "+end);
	        if(end<=(x/end)) return end;
	        return start;
	    }
	
	
	//My Solution : Binary Tree
	//Top to bottom : Wasting Time
	//Time Exceed Limit, Also has Integer.MAX_VALUE problem
	//How to resolve??? Use divide instead of multiply!
    public int mySqrt_wrong(int x) 
    {
        if(x<0) return -1;
        if(x==0 || x==1) return x;
        
        int start = 1;
        int end = Integer.MAX_VALUE;
        
        while(start<(end-1))
        {
            int mid = start +(end-start)/2;
            int cur = x/mid;
            if(mid==cur) return mid;            
            else if(mid<cur)
            {
                start = mid;
            }
            else 
            {
                end = mid-1;
            }
        }
        System.out.println("Start "+start);
        System.out.println("End "+end);
        if(end*end<=x) return end;
        return start;
    }

}
