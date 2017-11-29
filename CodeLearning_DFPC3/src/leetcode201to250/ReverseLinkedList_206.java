package leetcode201to250;

public class ReverseLinkedList_206 
{
	//Sol 2: Recursion
    public ListNode reverseList(ListNode head) 
    {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode newtail = head.next;
        ListNode newhead = reverseList(head.next);
        newtail.next = head;
        head.next = null;  //Important!!! remove unnessary links!!!
        return newhead;
    }
	
	
	//Sol 1: Iteration Revisit and Remember
    public ListNode reverseList_Iter(ListNode head) 
    {
        if(head==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null)
        {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }
}
