package leetcode201to250;

public class RemoveLinkedListElements_203 
{
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode cur = dummy;
        
        while(cur.next!=null)
        {
            if(cur.next.val==val)
            {
                cur.next = cur.next.next;
            }
            else cur = cur.next;
        }
        return dummy.next;
    }

}
