package leetcode1to50;

public class ReverseInteger_7 
{
	//Solution 1: 
	//How to check overflow 1: reverse the operation to see if the original value can be obtained
    public int reverse_1(int x) 
    {
        if(x==0) return 0;
        boolean flag = (x>0) ? true : false;
        int val = (x>0)? x : -x;
                
        int result = 0;

        while(val!=0)
        {
            int cur = val%10;
            val = val/10;
            int newresult = result * 10 + cur;
            if((newresult-cur)/10!=result) return 0;
            result = newresult;
        }
        
        return flag==true ? result : -result;
    }
    
	//Solution 2: 
    //How to check overflow 2: Use long, then have opportunity to check if >Integer.MAX_VALUE or < Integer.MIN_VALUE
    public int reverse_2(int x) 
    {
        if(x==0) return 0;
        boolean flag = (x>0) ? true : false;
        int val = (x>0)? x : -x;
                
        long result = 0;

        while(val!=0)
        {
            int cur = val%10;
            val = val/10;
            result= result *10 + cur;
            if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) return 0;
        }
            
        return flag==true ? (int)result : -(int)result;
    }

}
