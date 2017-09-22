package linkedList;

public class RotateList_61 
{
    public ListNode rotateRight(ListNode head, int k) 
    {
    	if(head==null || head.next==null) return head;
    	
    	ListNode first = head;
    	ListNode second = head;
    	
    	int count = k;
    	
    	while(count>=0 && second.next!=null) 
    	{
    		second = second.next;
    	}
    	
    	while(second.next!=null)
    	{
    		first = first.next;
    		second = second.next;
    	}
    	second.next = head;
    	head = first.next;
    	first.next = head;
    	
    	return head;
    }


}
