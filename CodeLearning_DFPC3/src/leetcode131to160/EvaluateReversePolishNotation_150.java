package leetcode131to160;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation_150 
{
	//Sol 2: Only need to previous two number to do the operation
	//--> stack
	public int evalRPN_ST(String[] tokens)
	{
		Stack<Integer> st= new Stack<Integer>();
		for(String s: tokens)
		{
			switch(s)
			{
				case "+":
					st.push(st.pop()+st.pop()); 
					break;
				case "-":
					st.push(-st.pop()+st.pop());
					break;
				case "*":
					st.push(st.pop()*st.pop());
					break;
				case "/":
					int num2 = st.pop();
					int num1 = st.pop();
					st.push(num1/num2);
					break;
				default:
					st.push(Integer.parseInt(s));
			}
		}
		return st.pop();
	}
	
	
	//My Sol: Sol 1 go through array and adjust the list in time.
	//Set, remove the list element and adjust list size flexiblely
    public int evalRPN_List(String[] tokens) {
        if(tokens==null || tokens.length==0) return 0;
        
        Set<String> hash = new HashSet<String>();
        hash.add("+");
        hash.add("-");
        hash.add("*");
        hash.add("/");
        
        if(tokens.length==1) 
        {   
            if(hash.contains(tokens[0])) return -1;
            return Integer.parseInt(tokens[0]);
        }
        List<Integer> worklist = new ArrayList<Integer>();
        
        for(int i=0; i<tokens.length; i++)
        {
            if(!hash.contains(tokens[i]))
            {
                int toadd = Integer.parseInt(tokens[i]);
                System.out.println(toadd);
                worklist.add(toadd);
            }
            else
            {
                int cursize = worklist.size();
                int first = worklist.get(cursize-2);
                int second = worklist.get(cursize-1);
                if(tokens[i].equals("+"))
                {
                    worklist.set(cursize-2, first+second);  
                }
                else if(tokens[i].equals("-"))
                {
                    worklist.set(cursize-2, first-second);
                } 
                else if(tokens[i].equals("*"))
                {
                    worklist.set(cursize-2, first*second);
                }
                else if(tokens[i].equals("/"))
                {
                    if(second==0) return -1;
                    worklist.set(cursize-2, first/second);
                }
                worklist.remove(cursize-1);
            }
        }
        return worklist.get(0);
    }
}
