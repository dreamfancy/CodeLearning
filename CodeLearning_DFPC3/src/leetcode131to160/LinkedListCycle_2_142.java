package leetcode131to160;

public class LinkedListCycle_2_142 
{
    public ListNode detectCycle(ListNode head) 
    {
        if(head==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null) 
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) break;
        }
        
        if(fast.next==null || fast.next.next==null) return null;
        ListNode s2 = head;
        
        while(s2!=fast)
        {
            s2 = s2.next;
            fast = fast.next;
        }
        return fast;  
    }

}
