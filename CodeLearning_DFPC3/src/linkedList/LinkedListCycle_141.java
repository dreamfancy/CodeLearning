package linkedList;

import java.util.HashSet;

public class LinkedListCycle_141 
{
	public static boolean hasCycle(ListNode head)
	{
		if(head == null) return false;
		
		ListNode first = head;
		ListNode second = head;
		
		while(second.next !=null && second.next.next!=null)
		{
			first = first.next;
			second = second.next.next;
			if(first==second) return true;
		}
		
		return false;
	}
	
	
	//Any LinkedList please pay attention that the end element's next is NULL!
	
	//Solution_1 use HashSet to record repeat
    public static boolean hasCycle_UseHashSet(ListNode head) 
    {
    	if(head==null) return false;
    	
    	HashSet<ListNode> hash = new HashSet<ListNode>();
    	
    	while(head.next!=null && !hash.contains(head))
    	{
    		hash.add(head);
    		head=head.next;
    	}
    	
    	if(hash.contains(head)) return true;
    	
    	return false;
    }
}
