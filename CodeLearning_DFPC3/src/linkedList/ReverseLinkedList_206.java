package linkedList;

public class ReverseLinkedList_206 {

	
	public ListNode reverseLinkedListByIterator(ListNode head)
	{
		if(head == null || head.next==null) return head;

		return reverseLinkedList(head);
	}
	
	
	
	//Iterator by two pointer
	public ListNode reverseLinkedList(ListNode head)
	{
		ListNode first = head;
		ListNode second = head.next;
		
		first.next = null;
		while(second != null)
		{
			ListNode third = second.next;
			second.next = first;
			first = second;
			second = third;
		}
		 return first;
	}
	
	//Recursive
	public ListNode reverseLinkedListByRecursive(ListNode head)
	{
		if(head==null || head.next==null) return head;
		ListNode newHead = reverseLinkedListByRecursive(head.next);
		head.next.next= head;
		head.next = null;
		return newHead;
	}
	
}
