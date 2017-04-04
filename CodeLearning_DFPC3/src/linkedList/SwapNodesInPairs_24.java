package linkedList;

public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) 
    {
    	if(head==null || head.next==null) return head;
    	
    	return swapInPairsRec(head);
    }
    
    public ListNode swapInPairsRec(ListNode head)
    {
    	ListNode first = head;
    	ListNode second = head.next;
    	
    	head = second;
    	
    	while(second.next!=null && second.next.next !=null)
    	{
    		ListNode third = second.next.next;
    		second.next = first;
    		first.next = third;
    	}
    	ListNode third = second.next;
    	second.next = first; 
    	first.next = third;
    	
    	if(!third.equals(null))
    	third.next=null;
    	
    	
    	return head;
    }
	
}
