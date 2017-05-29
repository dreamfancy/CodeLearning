package linkedList;

public class RemoveDuplicatesFromSortedList_83 
{
    public ListNode deleteDuplicates(ListNode head) 
    {
    	if(head==null || head.next==null) return head;
    	
    	ListNode first = head;
    	while(first.next!=null)
    	{
    		while(first.next!=null && first.next.val==first.val)
    		{
    			first.next = first.next.next;
    		}
    	
    		first = first.next;
    	}
    	
    	return head;
    }

}
