package basic;

import java.util.Stack;

//Stack is a class
//In stack, peek empty stack will cause exception (different from queue)
public class StackPractice {

//	public static void main(String[] args)
	{
		Stack s1 = new Stack();
		s1.push(1);
		s1.push(2);
		System.out.println(s1.empty());
		System.out.println(s1.pop());
		System.out.println(s1.peek());
		System.out.println(s1.pop());
		System.out.println(s1.peek());
		//System.out.println(s1.pop());


	}
}
