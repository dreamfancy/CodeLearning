package basic;

public class MyStackByListNode<T> 
{
	//fields
	private ListNode<T> head = null;
	
	public MyStackByListNode()
	{
		head = null;
	}
	
	//methods 
	public void offer(T item)
	{
		ListNode newNode = new ListNode<T>(item);
		newNode.next = head;
		head = newNode;
	}
	
	public T poll()
	{
		if(head==null) return null;
		ListNode<T> popNode = head;
		head = head.next;
		popNode.next = null;    //Dereference!!!
		return popNode.val;
	}
	
	
	public T peek()
	{
		return head==null ? null : head.val;
	}

}
