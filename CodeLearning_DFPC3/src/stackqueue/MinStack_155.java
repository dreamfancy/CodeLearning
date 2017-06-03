package stackqueue;

import java.util.Stack;

public class MinStack_155 {
	
	private Stack<Integer> s1;
	private Stack<Integer> s2;

    /** initialize your data structure here. */
    public MinStack_155() {
        
    	s1 = new Stack<Integer>();
    	s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        s1.push(x);
        if(s2.empty()) s2.push(x);
        else
        {
        	s2.push(s2.peek()<x?s2.peek():x);
        }
    }
    
    public void pop() {
    	s1.pop();
    	s2.pop();
    	
    }
    
    public int top() {
    	if(!s1.empty())
    	{
    		return s1.peek();
    	}
    	else return -1;
    }
    
    public int getMin() {
    	if(!s2.isEmpty())
    	{
    		return s2.peek();
    	}
    	else return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */