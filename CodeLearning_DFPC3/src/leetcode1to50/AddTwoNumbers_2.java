package leetcode1to50;

public class AddTwoNumbers_2 
{
	
	//Review I
	
	//Official Solution:
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) 
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummy = new ListNode(1);
        ListNode cur = dummy;
        int next = 0;
        int curDig = 0;
        
        while(l1!=null || l2!=null)
        {
            int x = (l1==null) ? 0 : l1.val;
            int y = (l2==null) ? 0 : l2.val;

            int sum = x + y + next;
            curDig = sum%10;
            cur.next = new ListNode(curDig);
            next = sum/10;

            cur = cur.next;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }
       
        if(next>0)
            cur.next = new ListNode(1);
        
        return dummy.next;
    }
	
	
	//My Solution 
    public ListNode addTwoNumbers_my(ListNode l1, ListNode l2) 
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummy = new ListNode(1);
        ListNode cur = dummy;
        int next = 0;
        int curDig = 0;
        
        while(l1!=null && l2!=null)
        {
            curDig = (l1.val + l2.val +next)%10;
            cur.next = new ListNode(curDig);
            next = (l1.val + l2.val +next)/10;

            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        //if(next==1 && l1==null && l2==null)
        //{
        //   cur.next = new ListNode(1);
        //}
        if(l1==null)
        {
            while(l2!=null)
            {
                curDig = (l2.val+next)%10;
                cur.next = new ListNode(curDig);
                next = (l2.val + next)/10;

                cur = cur.next;
                l2 = l2.next;
            }
            if(next==1)
                cur.next = new ListNode(1);
        }
        
        if(l2==null)
        {
            while(l1!=null)
            {
                curDig = (l1.val+next)%10;
                cur.next = new ListNode(curDig);
                next = (l1.val + next)/10;
                cur = cur.next;
                l1 = l1.next;
            }
            if(next==1)
                cur.next = new ListNode(1);
        }
        
        return dummy.next;
    }

}
