package first100;

public class ReverseInteger_7 
{
	//Solution 2: How to check overflow: Cannot go back if overflow
	//Leetcode most common solution
    public int reverse(int x) 
    {
        int reverseInteger = 0;
        int previous_num = 0;
        while (x != 0) 
        {
        	int first = x % 10;
        	reverseInteger = (reverseInteger * 10) + first; 
        	if((reverseInteger- first)/10!=previous_num)
        	{
        		return 0;
        	}
     
        	previous_num = reverseInteger;
        	x = x / 10;
        }
        return reverseInteger;
    }
	
	
	//Solution 1: My Solution: How to deal with the issue of overflow
	//Check in a reverse flow
    public int reverse_MySolution(int x) 
    {
    	boolean neg = false;
    	if(x<0)
    	{
    		neg = true;
    		x = -x;
    	}
    	int result = 0;
		result +=x%10;
		x = x/10;
    	boolean overflow = false;
    	while(x!=0 && overflow == false)
    	{
    		if(result>Integer.MAX_VALUE/10) return 0;
    		result = result *10;
    		if(result>Integer.MAX_VALUE-x%10) return 0;
    		result +=x%10;
    		if(result<0) return 0;
    		x = x/10;
    	}
    	
    	return neg==false ? result : -result;
    }


}
