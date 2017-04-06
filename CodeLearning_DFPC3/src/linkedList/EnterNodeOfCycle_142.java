package linkedList;

public class EnterNodeOfCycle_142 {
	
	//Solution 2: Make null as the outer loop and make == check as the break contidion
	public static ListNode detectCycle_2(ListNode head)
	{
		if(head==null || head.next==null) return null;
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode third = head;
		
		while(fast.next!=null && fast.next.next!=null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) break;
		}
		
		if(fast.next == null || fast.next.next == null) return null;

		
		while(slow != third)
		{
			slow = slow.next;
			third = third.next;
		}
		
		return third;
	}
	
	
	
	
	//Solution_1: Make != in the outer loop and make null check as the point to break and return null
	public static ListNode detectCycle(ListNode head)
	{
		if(head==null || head.next==null) return null;
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode third = head;
		do
		{
			if(fast.next==null || fast.next.next==null) return null;
			slow = slow.next;
			fast = fast.next.next;
		}
		while(slow != fast);

		while(slow != third)
		{
			slow = slow.next;
			third = third.next;
		}
		
		return third;
	}

}
