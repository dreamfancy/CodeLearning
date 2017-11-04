package leetcode51to100;

public class ReverseLinkedList_2_92 
{
	//My Solution: Great! Make the steps clear!!!
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null) return head;
        if(m==n) return head;
        
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode pre = dummy;
        
        for(int i=0; i<m-1; i++)
        {
            pre = pre.next;   
        }
        
        ListNode post = pre;
        
        for(int j=0; j<n-m+2; j++)
        {
            post = post.next;
        }
        
        ListNode reverseEnd = pre.next;
        ListNode first = reverseEnd;
        ListNode second = reverseEnd.next;
        
        for(int k=0; k<(n-m);k++)
        {
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        ListNode reverseStart = first;
        
        pre.next = reverseStart;
        reverseEnd.next = post;
        return dummy.next;
    }

}
