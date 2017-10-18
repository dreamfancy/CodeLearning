package leetcode1to50;

public class MyPow_50 {
	
	
	//Solution 3: Discussion Solution 1
	//Instead of recursion n --> n/2 and duplicate the result, let's do x*x
	
    public double pow_3(double x, int n) {
    	
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow_3(x*x, n/2) : x*pow_3(x*x, n/2);
    }
	
	//Solution 2: 
	//Consider special cases: x==1 -1 n==0 Integer.MAX_VALUE, Integer.MIN_VALUE
    public double myPow(double x, int n) 
    {
        if(x==1.0) return 1.0;
        if(x==-1.0) return n%2==0 ? 1.0 : -1.0;
        if(n==0) return 1.0;
        if(n==1) return x;
        if(n==Integer.MIN_VALUE) return 0;
        if(n<0) return 1/myPow(x,-n);
        
        double half = myPow(x,n/2);
        
        return n%2==0 ? half*half : half*half*x;    
    }
	
	
	
	//Solution 1: Pure recursion: when doing each part of recursion there are duplicate
	//calculation of myPow(x,n/2);
    public double myPow_1(double x, int n) 
    {
        if(x==1.0) return 1.0;
        if(n==0) return 1.0;
        if(n==1) return x;
        if(n<0) return 1/myPow_1(x,-n);
        
        return n%2==0 ? myPow_1(x,n/2)*myPow_1(x,n/2) : myPow_1(x,n/2)*myPow_1(x,n/2)*x;        
    }
}
