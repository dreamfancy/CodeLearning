package basic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class DequePractice {

	
	public static void priorityQueuePractice()
	{
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.offer(3);
		q.offer(2);
		q.offer(4);

		System.out.println(q.peek());
		System.out.println(q.poll());
		
		
	}

	
	
	//public static void main(String[] args)
	public static void dequePractice()
	{
		//Queue is on default to add from last and poll from first
		Deque dq = new ArrayDeque();
		dq.addFirst(1);
		System.out.println(dq.peek());
		dq.addFirst(2);
		System.out.println(dq.peek());
		dq.addLast(3);
		System.out.println(dq.removeFirst());
		System.out.println(dq.removeLast());


	}
	
	public static void main(String[] args)
	{
		//queuePractice();
		System.out.println(11);
		dequePractice();
	}
	
}

