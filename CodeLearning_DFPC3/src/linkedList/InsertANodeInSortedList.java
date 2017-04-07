package linkedList;

public class InsertANodeInSortedList {

	public ListNode InsertANodeInSortedList(ListNode head, int target)
	{
		ListNode tarNode = new ListNode(target);
		
		/*
		if(head==null)
			return tarNode;
		
		if(head.val>target)
		{
			tarNode.next = head;
			return tarNode;
		}
		*/
		if(head==null || head.val>target)
		{
			tarNode.next = head;
			return tarNode;
		}
		
		
		ListNode pre = head;
		//ListNode cur = head.next;
		
		//if(cur!=null && cur.val<target)
		if(pre.next!=null && pre.next.val<target)
		{
			//cur = cur.next;
			pre = pre.next;
		}
		
		//pre.next = tarNode;
		//tarNode.next = cur;
		
		tarNode.next = pre.next;
		pre.next = tarNode;
		
		return head;
	}
}
