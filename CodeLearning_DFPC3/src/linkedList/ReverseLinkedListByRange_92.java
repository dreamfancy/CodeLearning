package linkedList;

public class ReverseLinkedListByRange_92 {

    public ListNode reverseBetween(ListNode head, int m, int n) 
    {	
    	if(head == null) return null;
    	if(m>=n) return head;
    	
    	ListNode preEnd = getPositionOfList(head,m-1);
    	ListNode end = getPositionOfList(head,n);
    	ListNode nextStart = end.next;
    	ListNode start;
    	if(preEnd!=null)
    	{
    		start = preEnd.next;
    	}
    	else start = head;
    	ListNode revertStart = reverseLinkedList(start,end);
    	start.next = nextStart;
    	
    	if(preEnd!=null)
    	{
    		preEnd.next = end;
    		return head;
    	}
    	
    	return revertStart;
    	
    	
    }
    
    public ListNode reverseLinkedList(ListNode start, ListNode end)
    {
    	if(start==null || start.next==null) return start;
    	ListNode pre = start;
    	ListNode cur = start.next;
    	
    	while(cur!=end)
    	{
    		ListNode temp = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = temp;
    	}
    	//if(cur!=null)
    	//{
    		cur.next=pre;
    		start.next = null;
    		return cur;
    	//}
    	
    	//return pre;
    }
    
    
    public ListNode getPositionOfList(ListNode start, int k)
    {
    	if(k<=0 || start == null) return null;
    	while(k>1)
    	{
    		if(start.next!=null)
    		{
    			start = start.next;
    			k--;
    		}
    	}
    	if(k==1) return start;
    	return null;
    	
    }

}
