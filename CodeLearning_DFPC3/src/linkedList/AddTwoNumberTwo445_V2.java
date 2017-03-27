package linkedList;

import java.util.Stack;

public class AddTwoNumberTwo445_V2 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	
    	Stack<Integer> s1 = new Stack<Integer>();
    	Stack<Integer> s2 = new Stack<Integer>();

    	ListNode st = null;
    	
    	int m=1,n=1;
    	
    	s1.push(l1.val); 
    	while(l1.next!=null)
    	{	
    		s1.push(l1.next.val);
    		l1 = l1.next;
    		m++;
    	}
    	
    	s2.push(l2.val);
    	while(l2.next!=null)
    	{
    		s2.push(l2.next.val);
    		l2 = l2.next;
    		n++;
    	}
    	
    	int nextb = 0;
    	int sum = 0;
    	while(!s1.isEmpty()||!s2.isEmpty())
    	{
    	
    		if(!s1.isEmpty() )
    		{
    			sum += s1.pop();
    		}
    		if(!s2.isEmpty())
    		{
    			sum += s2.pop();
    		}
    		ListNode cur = new ListNode(sum%10);
    		sum = sum/10;
    		cur.next = st;
    		st = cur;
    	}
    	if (sum == 1)
    	{
    		ListNode cur= new ListNode(1);
    		cur.next = st;
    		st = cur;
    	}
    	
    		
    	
    	return st;
    	
    }
    public static void main(String[] args)
    {
    	ListNode l1 = new ListNode(9);
    	ListNode a2 = new ListNode(1);
    	ListNode a3 = new ListNode(9);
    	l1.next = a2;
    	a2.next = a3;
 

    	ListNode l2 = new ListNode(1);
    	ListNode b2 = new ListNode(9);
    	//ListNode b3 = new ListNode(1);
    	l2.next = b2;
    	//b2.next = b3;
    	    	  			
    	ListNode res = addTwoNumbers(l1,l2);
    	
    	while(res != null)
    	{
    		System.out.print(res.val+ "  ");
    		res = res.next;
    	}
    }
	
}
