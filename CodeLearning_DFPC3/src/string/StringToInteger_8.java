package string;

import java.util.HashSet;
import java.util.Set;

public class StringToInteger_8 
{
	//Leetcode Official Solution
	public int myAtoi(String str) {
        int index = 0;
        int sign = 1;
        int total = 0;
        if (str == null || str.length() == 0){
            return 0;
        }
        while (str.charAt(index) == ' '){
            index++;
        }
        if (str.charAt(index) == '-' || str.charAt(index) == '+'){
            sign = str.charAt(index) == '-'? (-1) : 1;
            index++;
        }
        while (index < str.length()){
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9){  //Attention!!! Please revisit!
                break;
            }
            //overflow
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)){
                //****
                 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            index++;
        }
        return total * sign;
    }
	
	
	//My Solution: 
	public int myAtoi_2(String str) {
        if(str==null || str.length()==0) return 0;
        
        int res = 0;
        int c=0;
        int sig = 0;
        boolean allowmore = true;
        Set<Character> set = new HashSet<Character>();
        
        /*
        for(int i=0; i<10; i++)
        {
            set.add((char)(" "+ i));
        }
        */
        
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
        
        while(c<str.length() && (str.charAt(c)==' ' || str.charAt(c)=='+' || str.charAt(c)=='-' || str.charAt(c)=='0'))
        {
        		if(allowmore==false) return 0;
        		if((str.charAt(c)=='-' || str.charAt(c)=='+') && sig!=0) return 0; 
        		if(str.charAt(c)=='-') 
        		{
        			sig = -1;
        		}
        		if(str.charAt(c)=='+') 
        		{
        			sig = 1;
        		}
        		if(str.charAt(c)=='0')
        		{
        			allowmore = false;
        		}
        		c++;
        }
            
 
        while(c<str.length())
        {
            char cur = str.charAt(c++);
            if(cur==' ') continue;
            if(!set.contains(cur)) break;
            if(((long)res*10+cur-'0')>Integer.MAX_VALUE)
            {
            	if(sig==1) return Integer.MAX_VALUE;
            	else return Integer.MIN_VALUE;
            }
            res = res*10 + cur - '0';
        }        
        
        if(sig==-1) res = -res;
        return res;
    }
    
	/*
    public static void main(String[] args)
    {
        char c1 = '9';
        char c2 = '4';
        
        System.out.println(c1==c2);
        
        int val = c1-'0' + c2 -'0';
        
        System.out.println(val);
        
        System.out.println(Integer.MAX_VALUE);
    }
    */
    
   
}
