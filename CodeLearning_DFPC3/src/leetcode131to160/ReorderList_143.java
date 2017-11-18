package leetcode131to160;

public class ReorderList_143 
{
	//Sol 2: Attention tail=null needs to be processed to avoid infinite loop
    public void reorderList_2(ListNode head) {
        if(head==null || head.next==null) return;
        
        ListNode first = head;
        ListNode second = head;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        second = slow.next;
        slow.next = null;
        
        second = reverseList(second);
    
        ListNode cur1 = head;
        ListNode cur2 = second;
        
        while(cur2!=null)
        {
            ListNode next = cur1.next;
            cur1.next = cur2;
            cur2 = cur2.next;
            cur1.next.next = next;
            cur1 = next;
        }
        
    }
    public ListNode reverseList_2(ListNode head)
    {
        ListNode tail = head;
        ListNode first = head;
        ListNode second = head.next;
        
        while(second!=null)
        {
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        tail.next = null;
        return first;
    }
       
	
	
	
	//Sol 1: Wrong understanding of the topic but still worth to revisit
	//Change a big problem to small problems combination
    public void reorderList_1_Wrong(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode dummyeven = new ListNode(1);
        ListNode dummyodd = new ListNode(1);
        
        ListNode cureven = dummyeven;
        ListNode curodd = dummyodd;
        
        ListNode cur = head;
        
        //Step 1: Split the list
        while(cur!=null && cur.next!=null)
        {
            cureven.next = cur;
            cureven = cur;
            curodd.next = cur.next;
            curodd = cur.next;
            cur = cur.next.next;
        }
        
        if(cur!=null)
        {
            cureven.next = cur;
            cureven = cur;
            curodd.next = null;
        }
        else cureven.next = null;
        /*
        //Test of step 1:
        ListNode testeven = dummyeven;
        while(testeven!=null)
        {
            System.out.print(testeven.val+ "  ");
            testeven = testeven.next;
        }
        System.out.println();
       */         
        ListNode testodd = dummyodd;
        while(testodd!=null)
        {
            System.out.print(testodd.val+ "***");
            testodd = testodd.next;

        }
        System.out.println();
        
        
        cureven.next = null;
        curodd.next = null;
        
        //step 2: reverse the odd list
        curodd = reverseList(dummyodd);
        //test of step 2
        ListNode testst2 = curodd;
        
        while(testst2!=null)
        {
             System.out.print(testst2.val+ "  ");
            testst2 = testst2.next;
        }
            System.out.println();
        
        
        cureven = head;
        while(curodd!=null)
        {
            ListNode temp = cureven.next;
            cureven.next = curodd;
            curodd = curodd.next;
            cureven.next.next = temp;
            cureven = temp;
        }
        
        if(cureven!=null)
        {
            cureven.next = null;
        }
    }
    
    public ListNode reverseList(ListNode dummyodd)
    {
        ListNode tail = dummyodd.next;
        ListNode first = dummyodd;
        ListNode second = dummyodd.next;
        
        //first.next = null;
        while(second!=null)
        {
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        tail.next = null;
        return first;
    }
}
