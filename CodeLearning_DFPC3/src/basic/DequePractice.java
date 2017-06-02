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
	
	public static void main(String[] args)
	{
		//queuePractice();
		priorityQueuePractice();
	}
	
}

