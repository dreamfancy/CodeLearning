package leetcode1to50;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists_23 {

	
	//My solution 2: Everytime just need the minimum value and
    public ListNode mergeKLists_2(ListNode[] lists) 
    {
        if(lists==null || lists.length==0) return null;
        
        int k = lists.length;
        ListNode dummy = new ListNode(1);
        ListNode cur = dummy;
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length,
        		new Comparator<ListNode>()
        		{
        			@Override
        			public int compare(ListNode l1, ListNode l2)
        			{
        				return (l1.val-l2.val);
        			}
        		}
        );
        for(int i=0; i<lists.length; i++)
        {
        	heap.offer(lists[i]);
        }
        //Attention: Comparable is an interface. the compare method should be in the ListNode class instead of PriorityQueue
        //If we want to implments Comparator when doing initialization. PLease rememeber the format of this question!
        
        
        while(!heap.isEmpty())
        {
        	cur.next = heap.poll();	
        	cur = cur.next;
        	if(cur.next!=null) heap.offer(cur.next);
        }
        
        return dummy.next;
    }
        

	
	
	
	
	//Official soltuion 1:
    //Who can do the sort: Array!
    //So you can traverse all the linkedlist and collect the values of the nodes into an array
    //Sort and iterate over this array for new sorted linkedlist
	
	
	
	//My solution 1: All cases passed but time complexity is very bad
	//Reason, everytime there is a comparation between all the first node of list array element
	//but only one is changed/updated each time
	//Can we use priorityQueue as heap? please see solution 2
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists==null || lists.length==0) return null;
        
        int k = lists.length;
        ListNode dummy = new ListNode(1);
        ListNode cur = dummy;
        int p = findMinimum(lists);
        
        while(p!=-1)
        {
            cur.next = lists[p];
            lists[p] = lists[p].next;
            cur = cur.next;
            p = findMinimum(lists);
        }
        cur.next = null;
        
        return dummy.next;
    }
    
    public int findMinimum(ListNode[] lists)
    {
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for(int i=0; i<lists.length; i++)
        {
            if(lists[i]==null) continue;
            if(lists[i].val<min)
            {
                min = lists[i].val;
                pos = i;
            }
        }
        
        return pos;
    }
}
