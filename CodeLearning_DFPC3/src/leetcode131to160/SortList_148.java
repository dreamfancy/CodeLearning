package leetcode131to160;

public class SortList_148 {
    public ListNode sortList(ListNode head) 
    {
        if(head==null || head.next==null) return head;   
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode lefthead = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode righthead = slow.next;
        slow.next = null;
        
        ListNode leftsorted = sortList(lefthead);
        ListNode rightsorted = sortList(righthead);
        
        return merge(leftsorted,rightsorted); 
    }
    
    private ListNode merge(ListNode leftsorted, ListNode rightsorted)
    {
        ListNode dummy = new ListNode(1);
        ListNode cur = dummy;
        while(leftsorted!=null && rightsorted!=null)
        {
            if(leftsorted.val<=rightsorted.val)
            {
                cur.next = leftsorted;
                cur = cur.next;
                leftsorted = leftsorted.next;
            }
            else
            {
                cur.next = rightsorted;
                cur = cur.next;
                rightsorted = rightsorted.next;
            }
        }
        if(leftsorted!=null)
        {
            cur.next = leftsorted;
        }
        if(rightsorted!=null)
        {
            cur.next = rightsorted;
        }
        return dummy.next;
    }
}
