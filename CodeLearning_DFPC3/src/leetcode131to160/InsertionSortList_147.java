package leetcode131to160;

public class InsertionSortList_147 
{
	
	//Sol 1: use the previous list node as storage, wrong
    public ListNode insertionSortList(ListNode head) {
        
        if(head==null) return head;
        ListNode dummyhead = new ListNode(1);
        dummyhead.next = head;
        ListNode nexttoswap = dummyhead;
        ListNode nextmin = dummyhead;
        
        while(nexttoswap.next!=null)
        {
            nextmin = nexttoswap;
            ListNode cur = nexttoswap;
            {
                while(cur.next!=null)
                {
                    if(cur.next.val<nextmin.val)
                    {
                        nextmin = cur;
                    }
                    cur = cur.next;
                }
                if(nextmin!=nexttoswap)
                {
                    swap(nextmin,nexttoswap);
                }
                nexttoswap = nextmin.next;
            }
        }
        return dummyhead.next;
    }
    
    public void swap(ListNode n1, ListNode n2)
    {
        ListNode nn1 = n1.next.next;
        ListNode nn2 = n2.next.next;
        ListNode cur1 = n1.next;
        ListNode cur2 = n2.next;
        
        n1.next = cur2;
        cur2.next = nn1;
        n2.next = cur1;
        cur1.next = nn2;   
    }
	

}
