package first100;

public class SwapNodesInPairs_24 {
	
	
	//My Solution
    public ListNode swapPairs(ListNode head) 
    {
        if(head==null || head.next==null)
            return head;
        
        ListNode second = head.next;
        ListNode third = second.next;
        
        second.next = head;
        head.next = swapPairs(third);
        
        return second;
    }
}
