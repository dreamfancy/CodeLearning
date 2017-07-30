package bitoperation;

public class ReverseBits_190 
{
	//Solution 3: from lecture
	//The most standard solution for get and set operation
	public int reverseBits(int n)
	{
		int res = 0;
		for(int i=0; i<32; i++)
		{
			int temp = (n>>i)&1;
			res |= temp<<(31-i);
		}
		return res;
		
	}
	
	//Solution 2: shift the input and output
    public int reverseBits_2(int n) 
    {
    	if(n==0 || n==-1) return n;
    	int result = 0;
    	
    	for(int i=0; i<32; i++)
    	{
    		result |= n&1;
    		n>>=1;
    		result<<=1;
    	}
    	return result;
    }

	
	
	
	//My solution: get bit then assign directly;
    public int reverseBits_1(int n) {
        
        if(n==0) return 0;
        
        int result = 0;;
        int leftmask = 1;
        int rightmask = 1<<31;
        
        for(int i=0; i<32; i++)
        {
            int bit = (n & leftmask)==0? 0 : 1;
            
            if(bit==1)
            result = result | rightmask;
            
            leftmask = leftmask<<1;
            rightmask = rightmask>>>1;
        }
        return result;
    }

}
