package first100;

import java.util.Stack;

public class ReverseNodesInKGroup_25 
{
	//LC Discussion 1: recursion, first recursion then process
	public ListNode reverseKGroup_Rec2(ListNode head, int k) {
	    ListNode curr = head;
	    int count = 0;
	    while (curr != null && count != k) { // find the k+1 node
	        curr = curr.next;
	        count++;
	    }
	    if (count == k) { // if k+1 node is found
	        curr = reverseKGroup_Rec2(curr, k); // reverse list with k+1 node as head
	        // head - head-pointer to direct part, 
	        // curr - head-pointer to reversed part;
	        while (count-- > 0) { // reverse current k-group: 
	            ListNode tmp = head.next; // tmp - next head in direct part
	            head.next = curr; // preappending "direct" head to the reversed list 
	            curr = head; // move head of reversed part to a new node
	            head = tmp; // move "direct" head to the next node in direct part
	        }
	        head = curr;
	    }
	    return head;
	}
	
	
	//LC Official Solution
	//Put one question too two steps
	public ListNode reverseKGroup(ListNode head, int k) {
	    ListNode begin;
	    if (head==null || head.next ==null || k==1)
	    	return head;
	    ListNode dummyhead = new ListNode(-1);
	    dummyhead.next = head;
	    begin = dummyhead;
	    int i=0;
	    while (head != null){
	    	i++;
	    	if (i%k == 0){
	    		begin = reverse(begin, head.next);
	    		head = begin.next;
	    	} else {
	    		head = head.next;
	    	}
	    }
	    return dummyhead.next;
	    
	}

	public ListNode reverse(ListNode begin, ListNode end){
		ListNode curr = begin.next;
		ListNode next, first;
		ListNode prev = begin;
		first = curr;
		while (curr!=end){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		begin.next = prev;
		first.next = curr;
		return first;
	}
	
	
	
	//My Solution : Recursion for the "group"
    public ListNode reverseKGroup_Rec(ListNode head, int k) {
        if(head==null || k<=1) return head;

        Stack<ListNode> st = new Stack<ListNode>();
        ListNode cur = head;
      
        for(int i=0; i<k; i++)
        {
            if(cur==null && i!=k) return head;
            st.push(cur);
            cur = cur.next;
        }
        
        ListNode newHead = st.pop();
        ListNode newcur = newHead;
        while(!st.isEmpty())
        {
            newcur.next = st.pop();
            newcur = newcur.next;
        }
        newcur.next = reverseKGroup(cur,k);
        
        return newHead;
        
    }

}
