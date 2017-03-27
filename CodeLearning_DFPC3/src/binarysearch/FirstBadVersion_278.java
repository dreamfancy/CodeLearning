package binarysearch;

public class FirstBadVersion_278 {

	//For the sake of no compile error
    static boolean isBadVersion(int version)
    {
    	return true;
    }

    public static int firstBadVersion(int n) {
    	
    	if(n==0) return 0;
    	if(n==1) return 1;
    	
    	return firstBadVersion(1,n);
    }
    
    
    //Recursive Solution
    public static int firstBadVersion(int first, int last)
    {
    	if(first==last) return first;
    	if(first>last) return -1;
    	int mid = first + (last-first)/2;
//!!!!!Attention: To get the mid value of two integers, please use the solution above. 
//We need to avoid the possibily of ADD out of range.
    	if(isBadVersion(mid)==true)
    	{
    		return firstBadVersion(first,mid);
    	}
    	else 
    	{
    		return firstBadVersion(mid+1,last);
    	}
    }
    
    
    //Iteration Solution_1
    //first<last-1,mid mid;
    public static int firstBadVersion_2(int n) {
    	
    	if(n==0) return 0;
    	if(n==1) return 1;
    	
    	return firstBadVersion_2(1,n);
    }
    
    //Leave the border situation separately ad the end of the function
    public static int firstBadVersion_2(int first, int last)
    {
    	if(first==last) return first;
    	if(first>last) return -1;

    	while(first<last-1)
    	{
        	int mid = first + (last-first)/2;
    		
    		if(isBadVersion(mid)==true)    
    		{
    			last = mid;
    		}
    		else
    		{
    			first = mid;
    		}
    	}
    	
    	if(isBadVersion(first)==true)
    	{
    		return first;
    	}
    	else if(isBadVersion(last)==true)
    	{
    		return last;
    	}
    	
    	return -1;
    }
    
    //Iteration Solution_2
    //first<=last,mid mid;
    public static int firstBadVersion_3(int n) {
    	
    	if(n==0) return 0;
    	if(n==1) return 1;
    	
    	return firstBadVersion_3(1,n);
    }
    
    public static int firstBadVersion_3(int first, int last)
    {
    	if(first==last) return first;
    	if(first>last) return -1;

    	while(first<=last)
    	{
        	int mid = first + (last-first)/2;
    		
    		if(isBadVersion(mid)==true)    
    		{
    			last = mid-1;
    		}
    		else
    		{
    			first = mid+1;
    		}
    	}
    	
    	return first;
    }

}
