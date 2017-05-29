package linkedList;

public class MergeTwoSortedLinkedList_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
    	if(l1==null) return l2;
    	if(l2==null) return l1;
    	
    	ListNode dummy = new ListNode(0);
    	ListNode cur = dummy;
    	
    	//Use dummy node to resolve "who is first issue"
    	while(l1!=null && l2!=null)
    	{
    		if(l1.val<=l2.val)
    		{
    			cur.next = l1;
    			cur = l1;
    			l1 = l1.next;
    		}
    		else
    		{
    			cur.next = l2;
    			cur = l2;
    			l2 = l2.next;
    		}
    	}
    	if(l1==null) cur.next = l2;
    	else cur.next = l1;
    	
    	return dummy.next;

    }
}
