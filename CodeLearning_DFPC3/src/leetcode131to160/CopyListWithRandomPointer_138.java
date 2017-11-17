package leetcode131to160;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CopyListWithRandomPointer_138 {
	
	//Sol 3: Optimization to sol 2 below

	public RandomListNode copyRandomList_3(RandomListNode head) {
		RandomListNode iter = head, next;

		// First round: make copy of each node,
		// and link them together side-by-side in a single list.
		while (iter != null) {
			next = iter.next;

			RandomListNode copy = new RandomListNode(iter.label);
			iter.next = copy;
			copy.next = next;

			iter = next;
		}

		// Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}

		// Third round: restore the original list, and extract the copy list.
		iter = head;
		RandomListNode pseudoHead = new RandomListNode(0);
		RandomListNode copy, copyIter = pseudoHead;

		while (iter != null) {
			next = iter.next.next;

			// extract the copy
			copy = iter.next;
			copyIter.next = copy;
			copyIter = copy;

			// restore the original list
			iter.next = next;

			iter = next;
		}

		return pseudoHead.next;
	}
	
	//Sol 2: Copy and add to the end
    public RandomListNode copyRandomList_2(RandomListNode head) 
    {
    	if(head==null) return null;
    	    	
        RandomListNode oricur = head;
        RandomListNode copycur = new RandomListNode(head.label);

        //Round 1: Double the linkedlist length but add the copy at the end of each element
        while(oricur.next!=null)
        {
            RandomListNode orinext = oricur.next;
            oricur.next = copycur;
            copycur.next = orinext;
            oricur = orinext;
            copycur = new RandomListNode(oricur.label);
        }
        oricur.next = copycur;
        
        //Round 2: Assign random
        oricur = head;
        while(oricur!=null)
        {
            if(oricur.random!=null)
            {
                oricur.next.random = oricur.random.next;
            }
            oricur = oricur.next.next;
        }
        
        //Round 3: Split //Question to mianshiguan: whether needs to keep the old list
        oricur = head;
        RandomListNode newhead = head.next;
        RandomListNode newcur = newhead;
        
        while(newcur.next!=null)
        {
            oricur.next = newcur.next;
            newcur.next = newcur.next.next;
        }
        oricur.next = null;
        return newhead;
        
        
        
    }
	
	//Sol 1: HashMap old and new listpoint
    public RandomListNode copyRandomList_1(RandomListNode head) 
    {
    	if(head==null) return null;
    	
    	Map<RandomListNode, RandomListNode> hash = new HashMap<RandomListNode, RandomListNode>();
    	
    	RandomListNode newhead = new RandomListNode(head.label);
    	hash.put(head, newhead);
		RandomListNode curori = head;
    	
    	while(curori.next!=null)
    	{
    		curori = curori.next;
    	    RandomListNode newnext = new RandomListNode(curori.label);
    	    hash.put(curori, newnext);
    	}
    	
    	Iterator<RandomListNode> iter = hash.keySet().iterator();
    	
    	while(iter.hasNext())
    	{
    		RandomListNode curkey = iter.next();
    		if(curkey.random!=null)
    		{
    			hash.get(curkey).random = hash.get(curkey.random);
    		}
            if(curkey.next!=null)
    		{
    			hash.get(curkey).next = hash.get(curkey.next);
    		}
    	}
    	
    	return newhead;
    }
}
