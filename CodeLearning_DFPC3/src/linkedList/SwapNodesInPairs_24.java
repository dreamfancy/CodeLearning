package linkedList;

public class SwapNodesInPairs_24 {
	
	//Use dummy node to deal with duplicates
    public ListNode swapPairs(ListNode head) 
    {
    	if(head==null || head.next==null) return head;
    	
    	return helper(head);
    }
    
    //List all four nodes by sequence, very clear good!
    public ListNode helper(ListNode head)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
    	ListNode first = head;
    	ListNode second = head.next;
        ListNode preNode = dummy; 
        ListNode nextNode = second.next;
    	
    	while(first!=null && second!=null)
    	{
            nextNode = second.next;
            second.next = first;
            first.next = nextNode;
            preNode.next = second;
            
            
    		preNode = first;
            
            first = nextNode;
            if(nextNode!=null) 
            {
                second = first.next;
            }
            else second = null;
    	}
    	return dummy.next;
    }
	
}
