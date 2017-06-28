package basic;

public class MyStackByArray 
{
	//[0,head)
	//push      assign head++
	//poll      head-- get
	
	int[] array;
	int head;
	int size;
	int capacity;
	
	public MyStackByArray(int capa)
	{
		array = new int[capa];
		capacity = capa;
		head = 0;
		size = 0;
	}
	
	public boolean push(int val)
	{
		if(head>=capacity) return false;
		array[head++] = val;
		size++;
		
		return true;
	}

	public int poll()
	{
		if(head<=0) return -1;
		size--;
		
		return array[--head];
		
	}
	
	public int peek()
	{
		return head<=0 ? -1 : array[head-1];
	}
}
