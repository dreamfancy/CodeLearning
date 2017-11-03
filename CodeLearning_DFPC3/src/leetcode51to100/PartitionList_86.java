package leetcode51to100;

public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        
        ListNode dummy1 = new ListNode(1);
        ListNode l1 = dummy1;
        ListNode dummy2 = new ListNode(2);
        ListNode l2 = dummy2;
        
        while(head!=null)
        {
            if(head.val<x)
            {
                l1.next = head;
                head = head.next;
                l1 = l1.next;
            }
            else
            {
                l2.next = head;
                head = head.next;
                l2 = l2.next;
            }
        }
        l1.next = dummy2.next;
        l2.next = null;
        return dummy1.next;
    }
}
