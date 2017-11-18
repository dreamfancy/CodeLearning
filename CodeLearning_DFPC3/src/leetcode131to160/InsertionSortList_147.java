package leetcode131to160;

public class InsertionSortList_147 
{
	//Sol 2: 
	public ListNode insertionSortList_2(ListNode head) 
	{
		if(head==null) return head;
		ListNode helper = new ListNode(0);
		ListNode cur = head;
		ListNode pre = helper;
		ListNode next = null;
		
		while(cur!=null)
		{
			next = cur.next;
			while(pre.next!=null && pre.next.val<cur.val)
			{
				pre = pre.next;
			}
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		
		return helper.next;
	}

	
	//Sol 1: use the previous list node as storage, wrong
    public ListNode insertionSortList_1(ListNode head) {
        
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
