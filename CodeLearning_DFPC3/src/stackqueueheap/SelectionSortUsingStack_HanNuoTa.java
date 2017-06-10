package stackqueueheap;

import java.util.Stack;

public class SelectionSortUsingStack_HanNuoTa 
{
	//access modifier can only be declared in class level, not inside method
	public Stack<Integer> selectionSortUsingStacks(Stack<Integer> s_ori)
	{
		if(s_ori.empty()) return s_ori;
		
		Stack <Integer> s_asis = new Stack<Integer>();
		int min = s_ori.peek();
		int count=0;
		int numdone = 0;
		boolean found;
		
		while(!s_ori.empty())
		{
			found = false;
			while(!s_ori.empty())
			{
				int cur = s_ori.pop();
				if(cur<min) min = cur;
				s_asis.push(cur);
				count++;
			}
	
			while(count>numdone)
			{
				int c = s_asis.pop();
				if(c!=min || found==true)
				{
					s_ori.push(c);
				}
				count--;
			
			}
			s_asis.push(min);
			numdone++;
		}
		return s_ori;
	}
}
