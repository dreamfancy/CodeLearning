package leetcode51to100;

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null) return null;
        if(k==0) return head;
        
        ListNode check = head;
        int count = 0;
        while(check!=null)
        {
            count++;
            check = check.next;
        }
        
        k = k%count;
        if(k==0) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i=0; i<k; i++)
        {
            fast = fast.next;
        }
        
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
