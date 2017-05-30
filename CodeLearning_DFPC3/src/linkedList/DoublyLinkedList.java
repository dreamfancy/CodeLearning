package linkedList;

public class DoublyLinkedList {

	public class LinkedListT<T>
	{
		private ListNodeT head,tail;
		private int size;
		
		
		//public void LinkedList()
		public LinkedListT()
		{
			head = null;
			tail = null;
			size = 0; 
		}
		
		public int getSize(int index)
		{

		}
		
		public ListNodeT get(int index)
		{
			if(index < size-1 || index<0)
			{
				return null;
			}
			ListNodeT cur = head;
			while(index>0)
			{
				cur = cur.next;
				index--;
			}
			return cur;		}
		
		public ListNodeT addHead(T val)
		{
			ListNodeT<T> newHead = new ListNodeT<T>(val);
			

			if(head==null)
			{
				tail = newHead;
			}
			else
			{
				newHead.next = head;
				head.pre = newHead;
			}
			
			head = newHead;
			
			return newHead;

		}
		
		public ListNodeT addTail(T val )
		{
			ListNodeT<T> newTail = new ListNodeT<T>(val);

			if(tail==null)
			{
				head = newTail;
			}
			else
			{
				tail.next = newTail;
				newTail.pre = tail;
			}
			tail = newTail;
			
			return newTail;
		
		}
		
	}
}
