package leetcode201to250;

public class PalindromeLinkedList_234 
{
    public boolean isPalindrome(ListNode head) 
    {
        if(head==null || head.next==null) return true;
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newhead = null;
        if(fast.next==null)
        {
            newhead = slow.next;
            slow.next = null;
        }
        else
        {
            newhead = slow.next.next;
            slow.next = null;
        }
        
        newhead = reverseList(newhead);
        
        return sameList(head,newhead);
        
    }
    private boolean sameList(ListNode l1, ListNode l2)
    {
        while(l1!=null && l2!=null)
        {
            if(l1.val!=l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1==null && l2==null;
    }
    
    
    private ListNode reverseList(ListNode head)
    {
        if(head==null || head.next==null) return head;
        ListNode tail = head;
        ListNode first = head;
        ListNode second = head.next;
        
        while(second.next!=null)
        {
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
            
        }
        second.next = first;
        tail.next = null;
        return second;
    }

}
