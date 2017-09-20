package recursion;

public class PowXN_50 
{
	//Solution 1 from program creek, Cannot pass the scenarios when n=Integer.MIN_VALUE
    public double myPow(double x, int n) 
    {
    	if(n==0) return 1.0;
    	if(n<0) return (1/x)* (1/myPow(x,-(n+1)));//Fix here
    	
    	double v =  myPow(x,n/2);
    	
    	if(n%2==0)
    	{
    		return v*v;
    	}
    	else return v*v*x;	
    }
    
    //Solution 2: Pass all the scenarios.
    public double myPow_2(double x, int n) {
        if (n < 0) return 1 / (x*myPow(x, -(++n)));//To Avoid Exception !!! When n is the Integer.MIN_VALUE
        else if (n == 0) return 1;
        else return (n % 2 == 0) ? myPow(x*x, n / 2) : x*myPow(x*x, n / 2);
    }

}
