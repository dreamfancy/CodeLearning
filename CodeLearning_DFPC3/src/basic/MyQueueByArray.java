package basic;

public class MyQueueByArray <T>{
	
	//stack :
	//push  assign head__;
	//poll  head --get
	//peak  array[head-1]
	//circular array  %array.length;
	//empty/full queue  head==tail + flag(tail catch head or head catch tail),size or capacity
	
	
	//Queue :
	//[head,tail)
	//offer add to tail,tail++;
	//poll get head, head++;
	
	
	//int capacity = 10;
	
	private int[] array;
	private int head;
	private int tail;
	private int size;
	private int capacity;
	
	public MyQueueByArray(int capa)
	{
		//array = new T[capacity];
		
		array = new int[capacity];
		head = 0;
		tail = 0;
		size = 0;
		capacity = capa;
	}
	
	public boolean offer(int val)
	{
		if(size>=capacity) return false;
		array[tail] = val;
		tail = (++tail)%capacity;
		size++;
		return true;
	}
	
	public int poll()
	{
		if(size<=0) return -1;
		int res = array[head];
		head = (++head)%capacity; 
		size--;
		return res;
	}
	
	public int peek()
	{
		return size==0 ? null : array[head];
	}
}

