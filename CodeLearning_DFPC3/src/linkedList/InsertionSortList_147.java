package linkedList;

public class InsertionSortList_147 {

	
	//Solution 1: Consider LinkedList update always to create a new LinkedList
	//Think in an opposite way!
    public ListNode insertionSortList(ListNode head) 
    {
    	ListNode dummy = new ListNode(0);
    	while(head!=null)
    	{
    		ListNode node =dummy;
    		while(node.next!=null && node.next.val<head.val)
    		{
    			node = node.next;
    		}
    
    		ListNode temp = head.next;
    		head.next = node.next;
    		node.next = head;
    		head = temp;
    	} 	
    	return dummy.next;
    }
	
	
	
	
	
	//Solution 2: Consider LinkedList as an Array and use the solutions of 
	//an array: Use swap
    public ListNode insertionSortList_swap(ListNode head) 
    {
    	if(head==null || head.next==null) return head;
    	
    	ListNode curHead = head;
    	
    	ListNode dummyHead = new ListNode(0);
    	dummyHead.next = curHead;
    	ListNode preHead = dummyHead;
    	
    	while(curHead!=null)
    	{
    		ListNode iter = curHead;
			ListNode curMin = curHead;
			ListNode preMin = preHead;

    		while(iter.next != null)
    		{
    			if(iter.next.val<curMin.val)
    			{
    				curMin=iter.next;
    				preMin=iter;
    			}
    			iter=iter.next;
    		}
    		
    		if(curMin.val!=curHead.val)
    		{
    			swap(curMin,curHead,preMin,preHead);
    			curHead = preHead.next;
    		}
    		
    		curHead = curHead.next;
    		preHead = preHead.next;
    	}
    	return dummyHead.next;
    }

    public void swap(ListNode curMin, ListNode curHead, ListNode preMin, ListNode preHead)
    {
        if(curHead.next!=curMin)
    	{
    	    ListNode nextHead = curHead.next;
    	    ListNode nextMin = curMin.next;
    	    preMin.next=curHead;
    	    preHead.next=curMin;
    	    curHead.next = nextMin;
    	    curMin.next = nextHead;
    	}
    	else
    	{
    		ListNode temp = curMin.next;
    		preHead.next = curMin;
    		curMin.next = curHead;
    		curHead.next = temp;
    	}
    }
}
