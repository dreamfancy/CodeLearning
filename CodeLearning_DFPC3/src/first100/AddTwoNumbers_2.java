package first100;


public class AddTwoNumbers_2 {
    
	
	
	//Solution 1: My initial solution, consider each scenario separately
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int val;
        int next = 0;
        while(l1!=null && l2!=null)
        {
            val = (l1.val+l2.val+next)%10;
            next = (l1.val+l2.val+next)/10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1!=null)
        {
        	val = (next +l1.val)%10;
            cur.next = new ListNode(val);
            next = (next+l1.val)/10;
            cur = cur.next;
            l1 = l1.next;
        }
        
        while(l2!=null)
        {
        	val = (next +l2.val)%10;
            cur.next = new ListNode(val);
            next = (next+l2.val)/10;
            cur = cur.next;
            l2 = l2.next;
        }
        
        if(next==1)
        {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }	
	
	
}
