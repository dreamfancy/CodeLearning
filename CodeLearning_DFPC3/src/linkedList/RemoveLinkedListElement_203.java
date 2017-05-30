package linkedList;



//Two way of delete
//203: change reference
//207 change the value of previous node to the new one
public class RemoveLinkedListElement_203 
{
	
	//For the common solution of LinkedList problems, we can either 
	//use two pointer pre, cur and update all the time or just use one pointer
	//pre, and use the relationship of pre.next pre.next.next
	//When necessary, it is useful to create a temp node help the 
	
    public ListNode removeElements(ListNode head, int val) 
    {
    	if(head==null) return head;
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode pre = dummy;
    	//ListNode cur = head;
    	
    	while(pre.next.next!=null)
    	{
    		if(pre.next.val==val)
    		{
    			pre.next = pre.next.next;
    		}
    		else
    		{
    			pre = pre.next;
    		}
    	}
    	
    	if(pre.next.val==val)
    	{
    		pre.next = null;
    	}
    	return dummy.next;
    }
}
