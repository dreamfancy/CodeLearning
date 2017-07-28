package bitoperation;

public class PowerOfTwo_231 {

	//Best solution for bit operation
	public boolean isPowerOfTwo(int n)
	{
		return (n>0) && ((n&(n-1))==0);
	}
	
	//Recursion solution
	public boolean isPowerOfTwo_recursion(int n)
	{
		if(n<=0) return false;
		if(n==1) return true;
		return n%2==0 && isPowerOfTwo_recursion(n/2); 
	}
	//Iteration solution
	public boolean isPowerOfTwo_whileloop(int n)
	{
		while(n%2==0)
		{
			n = n/2;
		}
		if(n==1) return true;
		return false;
		
	}

	
	//My solution : Bit operation
    public boolean isPowerOfTwo_MySolution(int n) {
        
        if(n==1) return true;
        if(n<=0) return false;
        boolean flag = false;
        if((n&1)!=0) return flag;
        while(n!=0)
        {
            n = n >>> 1;
            int temp = n & 1;
            if(temp==0) continue;
            else
            {
                n = n >>> 1;
                if(n==0) flag = true;
                break;
            }

        }
        
        return flag;
    }

}
