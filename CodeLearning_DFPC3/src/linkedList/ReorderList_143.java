package linkedList;

public class ReorderList_143 {
    
	//How to change one big problem to small problems
	//1 Basic Operation: Find middle
	//2 Reverse (the second) LinkedList
	//3 Merge
	public void reorderList(ListNode head) 
    {
		if(head==null || head.next==null) return;
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next !=null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode res = dummy;
		
		ListNode second = reverseList(slow.next);
		
		ListNode first = head;
		
		while(first!=null && second !=null)
		{
			res.next= first;
			first = first.next;
			res = res.next;
			
			res.next = second;
			second = second.next;
			res = res.next;
		}
		
		if(first!=null)
		{
			res.next = first;
		}
		first.next = null;
		//return dummy.next;
		
    }
	
	public ListNode reverseList(ListNode node)
	{
		if(node==null ||node.next==null) return node;
		ListNode cur = node.next;
		ListNode pre = node;
		ListNode temp = null;
		while(cur!=null)
		{	
			temp = cur.next;
			cur.next = pre;			
			pre = cur;
			cur = temp;
		}
		node.next = null;
		return pre;
	}
	

}
