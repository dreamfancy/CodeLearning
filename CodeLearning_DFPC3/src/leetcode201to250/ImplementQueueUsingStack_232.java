package leetcode201to250;

import java.util.Stack;

public class ImplementQueueUsingStack_232 
{
	class MyQueue {

	    /** Initialize your data structure here. */
	    Stack<Integer> st1;
	    Stack<Integer> st2;
	    
	    public MyQueue() {
	        st1 = new Stack<Integer>();
	        st2 = new Stack<Integer>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        while(!st1.isEmpty())
	        {
	            st2.push(st1.pop());
	        }
	        st1.push(x);
	        while(!st2.isEmpty())
	        {
	            st1.push(st2.pop());
	        }
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() 
	    {
	        return st1.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() 
	    {
	        return st1.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() 
	    {
	        return st1.isEmpty();
	    }
	}

}
