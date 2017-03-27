package linkedList;

public class OddEvenLinkedList_328 {

	
	//For LinkedList Questions, Please attention on each sublist:
	//Whether the tail has been termintated!
	//Attention if any assigning next happens, the original presentation of next
	//can be changed.
    public ListNode oddEvenList(ListNode head) {
     
    	if (head == null) return null;
    	if(head.next == null) return head;
    	if(head.next.next == null) return head;
    	
    	ListNode first = head;
    	ListNode second = head.next;
    	ListNode midpoint = second;
    	
    	while(second.next!= null && second.next.next!=null)
    	{
    		first.next = second.next;
    		first = first.next;
    		second.next = second.next.next;
    		second = second.next;
    	}
    	
    	if(second.next!=null)
    	{
    		first.next = second.next;
    		first = first.next;
    		second.next = null;
    	}
    	first.next = midpoint;
    	
    	return head;
    }
	
	
}
