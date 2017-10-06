package leetcode1to50;

public class StringToInteger_8 
{
	//My Solution: Best Solution
    public int myAtoi(String str) 
    {
        if(str==null || str.length()==0) return 0;
        int cur = 0;
        while(str.charAt(cur)==' ') cur++;
        boolean flag = true;
        if(str.charAt(cur)=='-')
        {
            flag = false;
            cur++;
        }
        else if(str.charAt(cur)=='+')
        {
            cur++;
        }
        
        long result = 0;
        if(cur>=str.length()) return 0;
        
        while(str.charAt(cur)=='0') cur++;
        
        while(result <= Integer.MAX_VALUE && cur<str.length() && str.charAt(cur)>='0' && str.charAt(cur)<='9')
        {
            result = result*10;
            result += str.charAt(cur++)-'0';
        }
        
        if(result>Integer.MAX_VALUE)
        {
            if(flag==true) return Integer.MAX_VALUE;
            if(flag==false) return Integer.MIN_VALUE;
        }
        
        if(flag==false) result = -result;
            
        return (int)result;
    }

}
