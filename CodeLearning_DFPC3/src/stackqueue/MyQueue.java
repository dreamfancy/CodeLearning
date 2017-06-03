package stackqueue;

import java.util.Stack;

public class MyQueue {

	private Stack<Integer> s1,s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        
    	s1 = new Stack<Integer>();
    	s2 = new Stack<Integer>();
    }
    
    public void push(int x) 
    {
    	s1.push(x);
    
    }

    public int pop() 
    {
    	//Normal think
    	/*
    	if(!s2.isEmpty())
    	{
    		return s2.pop();
    	}
    	else
    	{
    		while(!s1.isEmpty())
    		{
    			s2.push(s1.pop());
    		}
    		return s2.isEmpty()? null:s2.pop();
    	}
    	*/
    	
    	//Optimizing:
    	//Make the following if sentence as a method move(){}
    	if(s2.isEmpty() && !s1.isEmpty())
    	{
    		s2.push(s1.pop());
    	}
    	
    	return s2.isEmpty()? null:s2.pop();
    }
    
    public int peek() 
    {
    	if(!s2.isEmpty())
    	{
    		return s2.peek();
    	}
    	else
    	{
    		while(!s1.isEmpty())
    		{
    			s2.push(s1.pop());
    		}
    		return s2.isEmpty()? null:s2.peek();
    	}

    }
    public boolean empty() 
    {
    	return (s1.isEmpty()) && (s2.isEmpty());
    	
    }

    
    
}
    //Solution 1: My Solution, Keep Pop and Peek easy, make more work for push
    /*    
    public void push(int x) {
        while(!s1.isEmpty())
        {
        	s2.push(s1.pop());        	
        }
        
        s2.push(x);
        while(!s2.isEmpty())
        {
        	s1.push(s2.pop());
        }
    }
   
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
*/
