package linkedList;

public class RotateList_61 
{
	//For while loop never forget i++ i--
	
	//Solution 3: Official Solution 
    public ListNode rotateRight_3(ListNode head, int k) {
        ListNode start=new ListNode(0);
        start.next=head;
        ListNode a=start,b=start;
        if(head==null||k==0) return head;
        
        for(int i=0;i<k;i++){
            if(a.next==null){
                a=(k%i==0?start:head);
                k=k%i+i;
            }
            else
                a=a.next;
        }
        while(a.next!=null){
            a=a.next;
            b=b.next;
        }
        
        if(b!=start&&b!=a){
            start.next=b.next;
            b.next=null;
            a.next=head;
        }
        
        return start.next;
    }
	
	//Solution 2:
	//In the question, there is no limitation of the shift number to right
	//So we need to get the length to do % operation to avoid unnecessary shift
	public int getLength(ListNode head)
	{
		int count = 0;
		while(head!=null)
		{
			head = head.next;
			count++;
		}
		return count;
		
	}
	public ListNode rotateRight_2(ListNode head, int k) 
    {
		if(head==null || head.next==null) return head;
    	if(k==0) return head;
    	
		int length = getLength(head);
		int shift = k%length;
		
		ListNode first = head;
    	ListNode second = head;
		
    	while(shift>0) 
    	{
    		second = second.next;
    		if(second == null) second = head;
    		shift--;
    	}
    	if(first == second) return head;
    	
    	while(second.next!=null)
    	{
    		first = first.next;
    		second = second.next;
    	}
    	second.next = head;
    	head = first.next;
    	first.next = null;
    	
    	return head;
	
		
    }
	
	
	
	
	//My solution 1: Solution Of Life In Code website
	//Time Exceed Limit
    public ListNode rotateRight(ListNode head, int k) 
    {
    	if(head==null || head.next==null) return head;
    	if(k==0) return head;
    	ListNode first = head;
    	ListNode second = head;
    	
    	int count = k;
    	
    	//while(count>0 && second.next!=null) 
    	while(count>0) 
    	{
    		second = second.next;
    		if(second == null) second = head;
    		count--;
    	}
    	if(first == second) return head;
    	
    	while(second.next!=null)
    	{
    		first = first.next;
    		second = second.next;
    	}
    	second.next = head;
    	head = first.next;
    	first.next = null;
    	
    	return head;
    }


}
