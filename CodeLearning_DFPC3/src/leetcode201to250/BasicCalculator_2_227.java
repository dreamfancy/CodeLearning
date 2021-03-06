package leetcode201to250;

import java.util.Stack;

public class BasicCalculator_2_227 
{
	//Sol 3: Stack
	public int calculate_3(String s) {
	    int len;
	    if(s==null || (len = s.length())==0) return 0;
	    Stack<Integer> stack = new Stack<Integer>();
	    int num = 0;
	    char sign = '+';
	    for(int i=0;i<len;i++){
	        if(Character.isDigit(s.charAt(i))){
	            num = num*10+s.charAt(i)-'0';
	        }
	        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
	            if(sign=='-'){
	                stack.push(-num);
	            }
	            if(sign=='+'){
	                stack.push(num);
	            }
	            if(sign=='*'){
	                stack.push(stack.pop()*num);
	            }
	            if(sign=='/'){
	                stack.push(stack.pop()/num);
	            }
	            sign = s.charAt(i);
	            num = 0;
	        }
	    }

	    int re = 0;
	    for(int i:stack){
	        re += i;
	    }
	    return re;
	}
	
	//Sol 2: Use preval and curval to  diff the +- and */
	public int calculate_2(String s) {
	    if (s == null) return 0;
	    s = s.trim().replaceAll(" +", "");
	    int length = s.length();
	    
	    int res = 0;
	    long preVal = 0; // initial preVal is 0
	    char sign = '+'; // initial sign is +
	    int i = 0;
	    while (i < length) {
	        long curVal = 0;
	        while (i < length && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48) { // int
	            curVal = curVal*10 + (s.charAt(i) - '0');
	            i++;
	        }
	        if (sign == '+') {
	            res += preVal;  // update res
	            preVal = curVal;
	        } else if (sign == '-') {
	            res += preVal;  // update res
	            preVal = -curVal;
	        } else if (sign == '*') {
	            preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
	        } else if (sign == '/') {
	            preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
	        }
	        if (i < length) { // getting new sign
	            sign = s.charAt(i);
	            i++;
	        }
	    }
	    res += preVal;
	    return res;
	}
	
	
	//sol 1: My Solution: set special memory for */
    public int calculate_1(String s) 
    {
        if(s==null || s.length()==0) return 0;
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        int i=0;
        char presign = '+';
        
        boolean prio = false;
        int outval = 0;
        char outsign = '+';
        while(i<s.length())
        {
            char c = s.charAt(i);
            if(c==' ') 
            {
                i++;
                continue;
            }
            else if(c=='+' || c=='-')
            {
                int digit = Integer.parseInt(sb.toString());
                if(presign=='+' || presign=='-')
                {
                    cur = presign=='+'? (cur+digit) : (cur-digit);
                    presign = c;
                }
                else
                {
                    cur = presign=='*'? (cur*digit) : (cur/digit);
                    int temp = cur;
                    cur = outval;
                    presign = outsign;
                    cur = presign=='+'? (cur+temp) : (cur-temp);
                    presign = c;
                }
                sb = new StringBuilder();
            }
            else if(c=='*' || c=='/')
            {
                int digit = Integer.parseInt(sb.toString());
                if(presign=='+' || presign=='-')
                {
                    outval = cur;
                    outsign = presign;
                    cur = digit;
                    presign = c;
                }
                else
                {
                    cur = presign=='*'? (cur*digit) : (cur/digit);
                    presign = c;
                }
                sb= new StringBuilder();
            }
            else
            {
                sb.append(s.charAt(i));
            }
            i++;
        } 
        if(sb.length()!=0)
        {
            int digit = Integer.parseInt(sb.toString());
            if(presign=='+') cur = cur + digit;
            else if(presign=='-') cur = cur - digit;
            else
            {
                 cur = presign=='*'? (cur*digit) : (cur/digit);
                 int temp = cur;
                 cur = outval;
                 presign = outsign;
                 cur = presign=='+'? (cur+temp) : (cur-temp);                
            }
        }
        return cur;
    }

}
