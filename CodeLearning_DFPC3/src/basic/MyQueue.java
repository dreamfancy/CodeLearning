package basic;

//Use Double Direction ListNode
public class MyQueue<T> 
{
	private ListNode<T> head;
	private ListNode<T> tail;
	
	public MyQueue()   //Class level we have already declared <T>, so it is not necessary to declare again at constructor or any methods
	{
		head = null;
		tail = null;
	}
	
	public void offer(T item)
	{

		ListNode<T> newNode = new ListNode<T>(item);
		if(tail==null)
		{
			tail = newNode;
			head = tail;
		}
		
		tail.next = newNode;
		newNode.pre = tail;
		tail = newNode;
	}
	
	public T poll()
	{
		if(head==null) return null;
		if(head.next==null)
		{
			T popNodeVal = head.val;
			head = null;
			tail = null; //!!!!!
			return popNodeVal;
		}
		
		ListNode<T> popNode = head;
		head = head.next;
		popNode.next = null;
		head.pre = null;
		return popNode.val;	
	}
	
	public T peek()
	{	
		return head==null ? null : head.val;
	}

	
	
	
}
