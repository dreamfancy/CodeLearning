package leetcode131to160;

public class IntersectionofTwoLinkedList_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        if(headA==null || headB==null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        boolean flag1 = false;
        boolean flag2 = false;

        
        while(curA!=curB)
        {
            curA = curA.next;
            curB = curB.next;
            
            if(curA==null)
            {
                if(flag1==false)
                {
                    curA = headB;
                    flag1 = true;
                }
                else
                {
                    return null;
                }
            }
            if(curB==null) 
            {
                if(flag2==false)
                {
                    curB = headA;
                    flag2 = true;
                }
                else
                {
                    return null;
                    
                }   
            }
        }
        return curA;
        
    }
}
