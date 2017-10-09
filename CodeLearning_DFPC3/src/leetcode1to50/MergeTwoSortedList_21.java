package leetcode1to50;

public class MergeTwoSortedList_21 {
	
	//Recursion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummy = new ListNode(1);
        ListNode cur = dummy;
        if(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
            	cur.next = l1;
            	cur = cur.next;
            	cur.next = mergeTwoLists(l1.next, l2);
            }
            else
            {
                cur.next = l2;
                cur = cur.next;
            	cur.next = mergeTwoLists(l1, l2.next);
            }
        }
        else if(l1!=null)
        {
            cur.next = l1;
        }
        else
        {
            cur.next = l2;
        }   
        return dummy.next;
    }

	
	
	
	//Iteration 
    public ListNode mergeTwoLists_Iter(ListNode l1, ListNode l2) 
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummy = new ListNode(1);
        ListNode cur = dummy;
        while(l1!=null && l2!=null)
        {
            ListNode nextL1 = l1.next;
            ListNode nextL2 = l2.next;
            
            if(l1.val<l2.val)
            {
                cur.next = l1;
                cur = cur.next;
                l1 = nextL1;
            }
            else
            {
                cur.next = l2;
                cur = cur.next;
                l2 = nextL2;
            }
        }
        if(l1!=null)
        {
            cur.next = l1;
        }
        if(l2!=null)
        {
            cur.next = l2;
        }
        
        return dummy.next;
    }
}
