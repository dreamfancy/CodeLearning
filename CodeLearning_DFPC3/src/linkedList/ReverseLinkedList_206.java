package linkedList;

public class ReverseLinkedList_206 {

	
	public ListNode reverseLinkedListByRecursive(ListNode head)
	{
		if(head == null || head.next==null) return head;

		return reverseLinkedList(head);
	}
	
	
	
	//Iterater by two pointer
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
	
}
