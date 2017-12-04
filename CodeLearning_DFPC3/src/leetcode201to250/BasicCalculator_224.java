package leetcode201to250;

import java.util.Stack;

public class BasicCalculator_224 
{
	//Sol 1: The main focus is different scenarios with brackets
    public int calculate(String s) 
    {
        if(s==null) return 0;
        s = s.trim();
        if(s.length()==0) return 0;
        
        int cur = 0;
        int presign = 1;
        StringBuilder sb = new StringBuilder();
        int i=0;
        Stack<Integer> stack = new Stack<Integer>();
        
        while(i<s.length())
        {
            if(s.charAt(i)==' ') 
            {
                i++;
                continue;
            }
            else if(s.charAt(i)=='+' || s.charAt(i)=='-')
            {
                if(sb.length()!=0)
                {
                    int digit = Integer.parseInt(sb.toString());
                    cur = presign==1 ? (cur+digit) : (cur-digit);
                    sb = new StringBuilder();
                }
                presign = s.charAt(i)=='+' ? 1 : -1;
            }
            else if(s.charAt(i)=='(')
            {
                stack.push(cur);
                stack.push(presign);
                cur = 0;
                presign = 1;
            }
            else if(s.charAt(i)==')')
            {
                if(sb.length()!=0)
                {
                    int digit = Integer.parseInt(sb.toString());
                    cur = presign==1? (cur+digit) : (cur-digit);
                }
                int bracketval = cur;
                presign = stack.pop();
                cur = stack.pop();
                cur = presign==1 ? cur+bracketval : cur-bracketval;
                sb = new StringBuilder();
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
            cur = presign==1? (cur+digit):(cur-digit);
        }
        return cur;
    }
	

}
