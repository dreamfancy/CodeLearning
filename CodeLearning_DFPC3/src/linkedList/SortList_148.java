package linkedList;

public class SortList_148 {

	//The merge sort divide and conquer algorithm
	//Before for an array divide O(n), merge O(nlogn) so total is o(n)+O(nlogn) = o(nlogn) 
	//Now for a LinkedList 
    public ListNode sortList(ListNode head) 
    {
    	if(head==null || head.next==null) return head;
    	return mergesortList(head,null);
    }
    public ListNode mergesortList(ListNode head, ListNode end)
    {
    	ListNode mid = findMidPoint(head,end);
    	ListNode firstHalf = mergesortList(head,mid);
    	ListNode secondHalf = mergesortList(mid.next,end);
    	
    	return mergeList(firstHalf,mid,end);
    	
    }
    public ListNode mergeList(ListNode start, ListNode mid, ListNode end)
    {
    	ListNode p1 = start;
    	ListNode p2 = mid.next;
    	
    	ListNode dummyNode = new ListNode(0);
    	ListNode cur = dummyNode;
    	while(p1!=mid && p2!=end)
    	{
    		if(p1.val<p2.val)
    		{
    			cur.next = p1;
    			p1 = p1.next;
    		}
    		else
    		{
    			cur.next = p2;
    			p2 = p2.next;
    		}
    	}
    	while(p1!=mid)
    	{
			cur.next = p1;
			p1 = p1.next;
    	}
    	while(p2!=end)
    	{
    		cur.next = p2;
    		p2 = p2.next;
    	}
    	return dummyNode.next;
    }
    
    public ListNode findMidPoint(ListNode head,ListNode end)
    {	
    	if(head==null) return null;
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while(fast.next!=end && fast.next.next !=end)
    	{
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }

}
