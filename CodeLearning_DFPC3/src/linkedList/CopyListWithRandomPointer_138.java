package linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 
{
	
	//Solution 1:
	//Two rounds: first round make the next pointer, second round make the random pointer
	// How to keep the relations between two lists: HashMap for the same position of first list and second list
	//The solution below needs to reverify. cannot pass case 4
    public RandomListNode copyRandomList_1(RandomListNode head) 
    {
        if(head==null) return null;
        RandomListNode cur = head;
        RandomListNode randomHead = new RandomListNode(head.label);
        if(cur.next==cur) randomHead.next = randomHead;
        if(cur.random==cur) randomHead.random = randomHead;
        RandomListNode curCopy = randomHead;
        Map<RandomListNode,RandomListNode> nodeMap = new HashMap<RandomListNode,RandomListNode>();
        
        while(cur.next!=null)
        {   
            RandomListNode nextNode = new RandomListNode(cur.next.label);
            curCopy.next = nextNode;
            nodeMap.put(cur,curCopy);
            curCopy = nextNode;
            cur = cur.next;
        }
        
        cur = head;
        curCopy = randomHead;
         
        while(cur!=null)
        {
            curCopy.random = nodeMap.get(cur.random);
            cur = cur.next;
            curCopy = curCopy.next;
        }
         
        return randomHead;
    }
    
    //Solution 2:
    //Initialize the randomed node immediately and put to hash
    //One round
    //Need to reverify! Time limit exceeded in leetcode answer
    public RandomListNode copyRandomList_2(RandomListNode head) 
    {
        if(head==null) return null;
        //RandomListNode cur = head;
        //RandomListNode randomHead = new RandomListNode(head.label);
        //if(cur.next==cur) randomHead.next = randomHead;
        //if(cur.random==cur) randomHead.random = randomHead;
        //RandomListNode curCopy = randomHead;
        RandomListNode cur = new RandomListNode(1);
        RandomListNode result = cur;


        Map<RandomListNode,RandomListNode> nodeMap = new HashMap<RandomListNode,RandomListNode>();
        
        while(cur!=null)
        {
        	if(!nodeMap.containsKey(head))
        	{
        		nodeMap.put(head, new RandomListNode(head.label));
        	}
        	cur.next = nodeMap.get(head);
        	if(head.random!=null)
        	{
        		if(!nodeMap.containsKey(head.random))
        		{
        			nodeMap.put(head.random, new RandomListNode(head.random.label));
        		}
        		cur.next.random = nodeMap.get(head.random);
        		head = head.next;
        		cur = cur.next;
        	}
        }
        return result.next;
    }
    
    //Solution 3: Use list duplicate to resolve the hash"map" feature
    public RandomListNode copyRandomList(RandomListNode head) {
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
}
