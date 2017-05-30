package linkedList;

public class PartitionList_86 {

	//Standard resolution for linkedlist with dummy nodeS.
    public ListNode partition(ListNode head, int x) 
    {
    	if(head==null || head.next==null) return head;
    	ListNode start = head;
    	ListNode dummy1 = new ListNode(0);
    	ListNode c1 = dummy1;
    	ListNode dummy2 = new ListNode(0);
    	ListNode c2 = dummy2;
    	while(start!=null)
    	{
    		if(start.val<x)
    		{
    			c1.next = start;
    			c1 = c1.next;
    			start = start.next;
    		}
    		else
    		{
    			c2.next = start;
    			c2 = c2.next;
    			start = start.next;
    		}
    	}
    	c2.next = null;
    	c1.next = dummy2.next;
    	return dummy1.next;
    
    }
 
}
