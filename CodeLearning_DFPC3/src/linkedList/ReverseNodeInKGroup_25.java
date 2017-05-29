package linkedList;

//Please revisit this question

//If you set some assistant virables such as nextStart, preEnd, 
//Please remember to always update them in time.

public class ReverseNodeInKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) 
    {
    	if(head==null) return null;
    	if(k<=1) return head;
    	
    	ListNode start = head;
    	ListNode preEnd = null;
    	ListNode nextStart = start;
    	int count = k;
    	ListNode newHead = head;;
    	while(start!=null)
    	{
    		ListNode end = getTheNextEnd(start,count);
    		if(end!=null)
    		{
    			nextStart = end.next;
    		    ListNode reversedhead = reverseLinkedList(start,end);
    		    //System.out.println("revers");
    		    if(preEnd==null)
                {
                    newHead = reversedhead;
                }
    	    	else 
    	    	{
    	    	    preEnd.next = reversedhead;
    	    	}
    	    	preEnd = start;
    	    	start = nextStart;
    		}
    		else
    		{
    		    if(preEnd==null)
                {
                    newHead = start;
                }
    	    	else 
    	    	{
    	    	    preEnd.next = start;
    	    	}
    		    start = null;
    		}
    	
    	}
    	
    	return newHead;
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
    	end.next = pre;
    	start.next = null;
    	return end;
    }
    
    
    //Transit information by the returntype, if returntype is null,
    //it means that the list is not complete and does not need to revert
    public ListNode getTheNextEnd(ListNode cur, int count)
    {
    	while(cur!=null)
    	{
    		if(count>1) 
    		{
    		    cur = cur.next;
    		    count--; //Attention count-- all the time!
    		}
    		else return cur;
    	}
    	
    	//System.out.println("Current count"+ count);
    	return null;
    }
}
