package array;

import java.util.Stack;

public class DeduplicateArray_Lec20 
{
	public String deduplicate(String input)
	{
		if(input==null || input.length()<=1) return input;
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<input.length(); i++)
		{
			if(stack.empty() || stack.peek() != input.charAt(i))
			{
				stack.push(input.charAt(i));
			}
		}
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty())
		{
			sb.insert(0, stack.pop());
		}
		
		return sb.toString();
		
	}
	

}
