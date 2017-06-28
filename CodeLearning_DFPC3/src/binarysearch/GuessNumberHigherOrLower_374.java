 package binarysearch;

public class GuessNumberHigherOrLower_374 {

    static int guess(int num)
    {
    	return 1;
    	//-1,0,1
    }

    
    //Solution_1 Recursive! Attention because of three status of mid, so use mid-1,mid+1 as new boundary
    public static int guessNumber(int n) {
    	return guessNumber(1,n);
    }
    
    public static int guessNumber(int start, int end)
    {
    	if(start==end)
    	{   
    	    System.out.println("Finish! Start end"+start +" "+end);
    		if(guess(start)==0) return start;
    		else return -1;
    	}
    	int mid = start + (end-start)/2;
    	if(guess(mid)==0) return mid;
    	else if(guess(mid)==-1)
    	{
    		System.out.println("current Start end"+start +" "+(mid-1));
    		return guessNumber(start,mid-1);
    	}
    	else if(guess(mid)==1)
    	{
    	   System.out.println("current Start end"+(mid+1) +" "+end);
    		return guessNumber(mid+1,end);
    	}
    	return -1;
    }

    //Use start<end-1
    
    public static int guessNumber_2(int n) {
    	return guessNumber(1,n);
    }
    
    public static int guessNumber_2(int start, int end)
    {
    	if(start==end)
    	{   
    		if(guess(start)==0) return start;
    		else return -1;
    	}
    	
    	while(start<end-1)
    	{
    	    int mid = start + (end-start)/2;
    	    if(guess(mid)==0) 
    	    {
    	        return mid;
    	    }
        	else if(guess(mid)==-1)
        	{
    		    end = mid;
        	}
        	else if(guess(mid)==1)
    	    {
    	   		start = mid;
    	    }
    	}
    	if(guess(start)==0) return start;
    	else if(guess(end)==0) return end;
        return -1;
    }
    
    public static int guessNumber_3(int n) {
    	return guessNumber(1,n);
    }
    
    public static int guessNumber_3(int start, int end)
    {
    	if(start==end)
    	{   
    		if(guess(start)==0) return start;
    		else return -1;
    	}
    	
    	while(start<=end)
    	{
    	    int mid = start + (end-start)/2;
    	    if(guess(mid)==0) 
    	    {
    	        return mid;
    	    }
        	else if(guess(mid)==-1)
        	{
    		    end = mid-1;
        	}
        	else if(guess(mid)==1)
    	    {
    	   		start = mid+1;
    	    }
    	}
    	if(guess(start)==0) return start;
        return -1;
    }
}
