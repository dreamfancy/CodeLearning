package leetcode131to160;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private class Node
	{
		int key;
		int value;
		Node pre;
		Node next;
		
		public Node(int key, int value)
		{
			this.key = key;
			this.value = value;
		}
		public Node()
		{
			this(0, 0);
		}
	}
	
	private Map<Integer,Node> hash; 
	private int count;
	private int capacity;
	private Node first;
	private Node last;
	
    public LRUCache(int capacity)
    {
    	hash = new HashMap<Integer,Node>();
    	first = new Node();
    	last = new Node();
    	first.next = last;
    	last.pre = first;
    	this.capacity = capacity; 
    	this.count = 0;
    }
    
    private void delete(Node node)
    {	
    	Node before = node.pre, after = node.next;
    	before.next = after;
    	after.pre = before;
    }
    private void add(Node node)
    {
        Node after = first.next;
        first.next = node;
        node.pre = first;
        node.next = after;
        after.pre = node;
    }
    	
    private void deleteTail()
    {
    	hash.remove(last.pre);
    	Node newtail = last.pre.pre;
    	newtail.next = last;
    	last.pre = newtail;
    	count--;
    }

    public int get(int key) 
    {
    	Node cur = hash.get(key);
    	if(cur==null) return -1;
    	delete(cur);
    	add(cur);
    	return cur.value;
    }
    
    
    public void put(int key, int value) 
    {
    	Node n = hash.get(key);
    	if(n==null)
    	{
    		n = new Node(key,value);
    		hash.put(key, n);
    		add(n);
    		count++;
    	}
    	else
    	{
    		n.value = value;
    		delete(n);
    		add(n);
    	}
    	
    	if(count>capacity)
    	{
    		deleteTail();
    	}
    }


}
