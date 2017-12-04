package basic;
/*
 Queue Interface Structure:
Type of Action 		Throws exception       Returns Special Value
 	Insert               add                      offer
    Remove               remove                   poll
    Examine              element 				  peek

Queue is an interface. We can use LinkedList as instance.
 */



import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuePractice {

	
	public static void priorityQueuePractice()
	{
		PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();
		q1.offer(3);
		q1.offer(2);
		q1.offer(4);

		System.out.println(q1.peek());
		System.out.println(q1.poll());
		System.out.println("************");

		PriorityQueue<Integer> q2 = new PriorityQueue<Integer>();
		q2.offer(2);
		System.out.println(q2.peek());
		q2.offer(1);
		System.out.println(q2.peek());
		q2.offer(1);
		System.out.println(q2.peek());
		q2.poll();
		System.out.println(q2.peek());
		q2.poll();
		System.out.println(q2.peek());
		q2.poll();
		System.out.println(q2.peek());

		
	}
	
	
	public static void main(String[] args)
	{
		//queuePractice();
		priorityQueuePractice();
	}
	
	
	
	//public static void main(String[] args)
	public static void queuePractice()
	{
		Queue q1 = new LinkedList();
		q1.add(null);
		q1.add(2);
		q1.offer(3);
		System.out.println(q1.element());
		System.out.println(q1.peek());
		System.out.println(q1.remove());
		System.out.println(q1.poll());
		System.out.println(q1.poll());
		System.out.println(q1.poll());
		System.out.println(q1.peek());
	//	System.out.println(q1.element());
	}
	

	
}
