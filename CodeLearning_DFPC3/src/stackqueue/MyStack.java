package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

	/*
	  How to use queue to realize stack
	  Whenever an elment is put to a queue, immediately "reverse" the queue
	  
	  Make all the elements before this new added element dequeue then input to the queue
	  again.
	  
	 
	 */
	
	private Queue<Integer> q;
	int count;
	
    /** Initialize your data structure here. */
    public MyStack() {
    	q = new LinkedList<Integer>();
    	count=0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	q.offer(x);
    	count++;
 
    	for(int c = count; c>1; c--)
    	{
    		int cur = q.poll();
    		q.offer(cur);
    	}
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(count>0)
    	{
    		count--;
    		return q.poll();
    	}
    	return -1;
    }
    
    /** Get the top element. */
    public int top() {
    	if(count>0)
    	{
    		return q.peek();
    	}
    	return -1;
    	
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(count<=0) return true;
        else return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
