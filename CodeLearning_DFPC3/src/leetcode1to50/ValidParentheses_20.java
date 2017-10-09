package leetcode1to50;

import java.util.Stack;

public class ValidParentheses_20 
{
	//My solution
    public boolean isValid(String s) 
    {
        if(s==null || s.length()==0) return true;
        
        Stack<Character> st = new Stack<Character>();
        
        int i=0;
        while(i<s.length())
        {
            char cur = s.charAt(i);
            /*
            if(cur=='(' || cur=='[' || cur=='{')
            {
                st.push(cur);
            }
            */
            if(cur=='(')
            {
                st.push(')');
            }
            else if(cur=='[')
            {
                st.push(']');
            }
            else if(cur=='{')
            {
                st.push('}');
            }
            else
            {
                if(st.isEmpty() || st.peek()!=cur) return false; 
                st.pop();
            }
            i++;
        }
        if(!st.isEmpty()) 
        {
            return false;
        }
        return true;
    }

}
