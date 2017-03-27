package linkedList;

import java.util.Stack;

public class AddTwoNumberTwo445 
{
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	
    	Stack<Integer> s1 = new Stack<Integer>();
    	Stack<Integer> s2 = new Stack<Integer>();
    	Stack<Integer> s3 = new Stack<Integer>();

    	ListNode ln = new ListNode(1);
    	ListNode st = ln;
    	
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
    	if(m<n)
    	{
    		int nextb = 0;
    		for(int i=1; i<=m; i++)
    		{
    			int cur1 = s1.pop() + s2.pop() + nextb;
    			s3.push(cur1%10);
    			nextb = cur1/10;	
    		}
    		for(int j=m+1; j<=n; j++)
    		{
    			int cur2 = s2.pop() + nextb;
    			s3.push(cur2%10);
    			nextb = cur2/10;
    		}
    		if(nextb == 1)
    			s3.push(1); 		
    	}
    	else if(m==n)
    	{
    		int nextb = 0;
    		for(int i=1; i<=m; i++)
    		{
    			int cur1 = s1.pop() + s2.pop() + nextb;
    			s3.push(cur1%10);
    			nextb = cur1/10;	
    		}
    		if(nextb == 1)
    			s3.push(1);
    	}
    	else if (m>n)
    	{
    		int nextb = 0;
    		for(int i=1; i<=n; i++)
    		{
    			int cur1 = s1.pop() + s2.pop() + nextb;
    			s3.push(cur1%10);
    			nextb = cur1/10;	
    		}
    		for(int j=n+1; j<=m; j++)
    		{
    			int cur2 = s1.pop() + nextb;
    			s3.push(cur2%10);
    			nextb = cur2/10;
    		}
    		if(nextb == 1)
    			s3.push(1);    		
    	}
    	
		if(!s3.isEmpty())
		{
			ln.val = s3.pop();
		}
		while(!s3.isEmpty())
		{
			ln.next = new ListNode(s3.pop());
			ln = ln.next;
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
