package leetcode1to50;

public class RemoveNthNodeFromEndOfList_19 
{
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head==null || n<=0) return head;
        ListNode first = head;
        ListNode second = head;
        
        for(int i=0; i<n; i++)
        {
            if(second==null) return head;
            second = second.next;
        }
        if(second==null) return head.next;
        
        while(second.next!=null)
        {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        
        return head;
    }

}
