package linkedList;


//This answer is directed copied from internet
//Attention that if a new digit is created, please add a new node.
public class PlusOne_369 {
	public ListNode plusOne(ListNode head) {
	    ListNode h2 = reverse(head);
	 
	    ListNode p=h2;
	 
	    while(p!=null){
	        if(p.val+1<=9){
	            p.val=p.val+1;
	            break;
	        }else{
	            p.val=0;
	            if(p.next==null){
	                p.next = new ListNode(1);
	                break;
	            }
	            p=p.next;
	        }
	    }
	 
	    return reverse(h2);
	}
	 
	public ListNode reverse(ListNode head){
	    if(head==null||head.next==null)
	        return head;
	 
	    ListNode p1=head;
	    ListNode p2=p1.next;
	    while(p2!=null){
	        ListNode t = p2.next;
	        p2.next=p1;
	        p1=p2;
	        p2=t;
	    }
	 
	    head.next=null;
	 
	    return p1;
	}
}
