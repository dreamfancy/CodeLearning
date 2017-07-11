package tree;

import java.util.Stack;

public class ValidParentheses_20 {
	
	//Solution 2: My solution optimized
    public boolean isValid_2(String s)
    {
    	Stack<Character> st = new Stack<Character>();
    	for(Character c: s.toCharArray())
    	{
    		if("([{".contains(String.valueOf(c)))
    		{
    			st.push(c);
    		}
    		else
    		{
    			if(!st.isEmpty() && is_valid(st.peek(),c))
    			{
    				st.pop();
    			}
    			else return false;
    		}
    	}
    	
    	return st.isEmpty();
    }
    
    private boolean is_valid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
            || (c1 == '[' && c2 == ']');
    }
	
	//Solution 1: My solution, use stack
    public boolean isValid_1(String s) 
    {
    	char[] charArray = s.toCharArray();
    	Stack<Character> st = new Stack();
    	
    	for(int i=0; i<charArray.length; i++)
    	{
    		if(charArray[i]=='(')
    		{
    			st.push(')');
    		}
    		else if(charArray[i]=='[')
    		{
    			st.push(']');
    		}
    		else if(charArray[i]=='{')
    		{
    			st.push('}');
    		}
    		else
    		{
    			if(st.isEmpty()) return false;
    			if(charArray[i]!=st.pop()) return false;
    		}
    	}
     
    	if(!st.isEmpty()) return false;
    	return true;
    }
}
