package first100;

public class RemoveNthNodeFromEndOfList_19 
{
	
	//My Solution
	//LinkedList questions: What about removing the first/last element
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
    	ListNode first = head;
    	ListNode second = head;
    	
    	int count = n;
    	while(n>0)
    	{
    		second = second.next;
    		n--;
    	}
    	if(second==null) return head.next;
    	
    	while(second.next!=null)
    	{
    		first = first.next;
    		second = second.next;
    	}
    	
    	first.next = first.next.next;
    	
    	return head;
    }
    
    //Solution 2: To avoid the first node issues please use the dummy node
    public ListNode removeNthFromEnd_2(ListNode head, int n) 
    {
    	ListNode dummy = new ListNode(1);
    	dummy.next = head;
    	ListNode first = dummy;
    	ListNode second = dummy;
    	
    	int count = n;
    	while(n>0)
    	{
    		second = second.next;
    		n--;
    	}
    	
    	while(second.next!=null)
    	{
    		first = first.next;
    		second = second.next;
    	}
    	
    	first.next = first.next.next;
    	
    	return dummy.next;
    }

}
