package leetcode251to300;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream_295 
{
	
    /** initialize your data structure here. */
    PriorityQueue<Integer> firstqueue;
    PriorityQueue<Integer> secondqueue;
    int size1;
    int size2;
    
    public FindMedianFromDataStream_295() 
    {
        firstqueue = new PriorityQueue<Integer>(1,new Comparator<Integer>()
                                                {
                                                    @Override
                                                    public int compare(Integer i1, Integer i2)
                                                    {
                                                        return (i2-i1);
                                                    }
                                                });
        secondqueue = new PriorityQueue<Integer>(1,new Comparator<Integer>()
                                                {
                                                    @Override
                                                    public int compare(Integer i1, Integer i2)
                                                    {
                                                        return (i1-i2);
                                                    }
                                                });
        size1 = 0;
        size2 = 0;
    }
    
    public void addNum(int num) {
        if(size1==size2)
        {
            if(!secondqueue.isEmpty() && secondqueue.peek()<=num)
            {
                firstqueue.offer(secondqueue.poll());
                secondqueue.offer(num);
            }
            else
            {
                firstqueue.offer(num);
            }
            size1++;
        }
        else
        {
            if(firstqueue.peek()>=num)
            {
                secondqueue.offer(firstqueue.poll());
                firstqueue.offer(num);
            }
            else
            {
                secondqueue.offer(num);
            }
            size2++;
        }
        
    }
    
    public double findMedian() 
    {
        if(size1==size2)
        {
            return 1.0 * (double)(firstqueue.peek()+secondqueue.peek())/2;
        }
        
        
        return 1.0*(firstqueue.peek());      
    }

}
