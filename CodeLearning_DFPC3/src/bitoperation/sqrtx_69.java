package bitoperation;

public class sqrtx_69 
{
	
	//Solution 3:
	//Best Solution from LeetcodeGraph
    public int mySqrt_3(int x) {
        if(x == 0) return 0;
        int start = 1;
        int end = x;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if (mid == x/mid) {
                return mid;
            }
            else if(mid < x/mid) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
       return start;
    }
	
	
	//Solution 2 from Zizuo Lecture revisit please!
    public int mySqrt_2(int x) 
    {
    	if(x<=1) return x;
    	double f0 = x/2;
    	
    	double f1 = (x/f0 + f0)/2;
    	
    	while(Math.abs(x/f0 + f0)>0.1)
    	{
    		f0 = f1;
    		f1 = (x/f0 + f0)/2;
    	}
    	
    	return (int)f1;
    }
    
    
    //Solution 1: LeetcodeGraph
    public int sqrt_1(int x) 
    {
    	int low = 0;
        int high = x;
    	while(low<=high)
    	{
    	    long mid = (long)(low + high)/2;
    	    if(mid*mid < x)
                 low = (int)mid + 1;
    	    else if(mid*mid > x)
                 high = (int)mid - 1;
    	    else
    	         return (int)mid;
    	}
    	return high;
    }
}
