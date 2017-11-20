package leetcode131to160;

import java.util.Stack;

public class MinStack 
{
	
	//Sol 2: Store the min if there is a difference
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
	
	//Sol 1 below: Use two stacks
	/*
    Stack<Integer> st;
    Stack<Integer> minst;
    
    public MinStack() {
        st = new Stack<Integer>();
        minst = new Stack<Integer>();
    }
    
    public void push(int x) {
        st.push(x);
        if(!minst.isEmpty())
        {
            minst.push(Math.min(minst.peek(),x));
        }
        else
        {
            minst.push(x);
        }
    }
    
    public void pop() {
        st.pop();
        minst.pop();
        
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
    */
}
