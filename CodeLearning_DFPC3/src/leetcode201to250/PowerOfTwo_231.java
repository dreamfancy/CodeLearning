package leetcode201to250;

public class PowerOfTwo_231 
{
	//Sol 2: Remember and revisit!
	public boolean isPowerOfTwo(int n)
	{
		return n>0 && (n&(n-1))==0;
	}
	
	//Sol 1: Go through 32 bits
    public boolean isPowerOfTwo_1(int n) 
    {
    	if(n<1) return false;
    	int count = 0;
    	for(int i=0; i<32; i++)
    	{
    		if((n&1)==1) count++;
    		n = n>>>1;
    	}
    	return count==1;
    }	

}
