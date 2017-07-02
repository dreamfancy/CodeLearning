package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraverse_103 
{
	//Solution 2: deque
	//offerFirst() offerLast() pollFirst() pollLast()
    public List<List<Integer>> zigzagLevelOrder_deque(TreeNode root) 
    {    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	if(root==null) return res;

    	Deque<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	int size = 0;
    	int flag = 1;
    	while(!q.isEmpty())
    	{
    		size = q.size();
    		List<Integer> list = new ArrayList<Integer>();
    		
    		if(flag==-1)
    		{
    			for(int i=0; i<size; i++)
    			{
    				TreeNode cur = q.pollFirst();
    				list.add(cur.val);
    				if(cur.right!=null) q.offerLast(cur.right);
    				if(cur.left!=null) q.offerLast(cur.left);	
    			}
    		}
    		else
    		{
    			for(int i=0; i<size; i++)
    			{
    				TreeNode cur = q.pollLast();
    				list.add(cur.val);
    				if(cur.left!=null) q.offerFirst(cur.left);
    				if(cur.right!=null) q.offerFirst(cur.right);
    			}
    		}
    		flag = -flag; // good! use +- as sign
    		res.add(list);
    	}
    	
    	return res;
    }
	
	//Solution 1: queue
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	if(root==null) return res;

    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	int size = 0;
    	int flag = 1;
    	while(!q.isEmpty())
    	{
    		size = q.size();
    		List<Integer> list = new ArrayList<Integer>();
    		while(size-->0)
    		{
    			TreeNode cur = q.poll();
    			list.add(cur.val);
       			if(cur.left!=null) q.offer(cur.left);
    			if(cur.right!=null) q.offer(cur.right);
    	
    		}
    		if(flag==-1) Collections.reverse(list);
    		flag = -flag;
    		res.add(list);
    	}
    	return res;
    }
}
