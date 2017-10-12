package leetcode1to50;

public class DivideTwoIntegers_29 
{
	//Solution 2: Official Solution
	//Shift can only use in one direction 
	//numShift++; numsShift-- resolve the issue perfectly
	//Please compare my solution then you will know why my solution fail
	public int divide_2(int dividend, int divisor) {
	    //handle special cases
	    if(divisor==0) return Integer.MAX_VALUE;
	    if(divisor==-1 && dividend == Integer.MIN_VALUE)
	        return Integer.MAX_VALUE;
	 
	    //get positive values
	    long pDividend = (long)Math.abs(dividend);
	    long pDivisor = (long)Math.abs(divisor);
	 
	    int result = 0;
	    while(pDividend>=pDivisor){
	        //calculate number of left shifts
	        int numShift = 0;    
	        while(pDividend>=(pDivisor<<numShift)){
	            numShift++;
	        }
	 
	        //dividend minus the largest shifted divisor
	        result += 1<<(numShift-1);
	        pDividend -= (pDivisor<<(numShift-1));
	    }
	 
	    if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
	        return result;
	    }else{
	        return -result;
	    }
	}
	
	//My Solution 1 : 1/-1 cannot pass
	//Remember Math.abs of most negative value is 1 more than most positive value
    public int divide(int dividend, int divisor) 
    {
        if(divisor==0) return Integer.MAX_VALUE;
    	if(dividend==0) return 0;
    	long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
    	
    	boolean signal = (pDividend>0 && pDivisor>0) || (pDividend<0 && pDivisor<0);
    	if(pDividend<0) pDividend = -dividend;
    	if(pDivisor<0) pDivisor = -pDivisor;
    	int result = 0;
    	int val = 1;
    	long divisor_origin = pDivisor;
    	
    	while(pDividend>=divisor_origin)
    	{
    		pDivisor = divisor_origin;
            val = 1;
    		while(pDividend>=pDivisor)
    		{
    			pDivisor = pDivisor<<1;
    			val = val<<1;
    		}
    		val = val>>1;
    		pDivisor = pDivisor>>1;
    		result += val;
    		pDividend = pDividend-divisor;
    		val  = 1;
    	}
    	
    	return signal==true ? result : -result; 
    }


}
