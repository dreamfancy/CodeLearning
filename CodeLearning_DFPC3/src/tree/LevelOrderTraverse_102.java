package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverse_102 {

	//Solution 1: Use two queue to to cut off where to create a new list
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
    	List<List<Integer>> arrLists = new ArrayList<List<Integer>>();
    	if(root==null) return arrLists;
    	Queue<TreeNode> q1 = new LinkedList<TreeNode>();
    	Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.offer(root);
		List<Integer> rootList = new ArrayList<Integer>();
		rootList.add(root.val);
		arrLists.add(rootList);
		while(!q1.isEmpty() || !q2.isEmpty())
		{
			List<Integer> list1 = new ArrayList<Integer>();
			while(!q1.isEmpty())
			{	
				TreeNode curNode = q1.poll();
				if(curNode.left!=null)
				{
					q2.offer(curNode.left);
					list1.add(curNode.left.val);
				}
				if(curNode.right!=null)
				{
					q2.offer(curNode.right);
					list1.add(curNode.right.val);
				}
			}
			if(!list1.isEmpty())
			{
				arrLists.add(list1);
			}
			
			List<Integer> list2 = new ArrayList<Integer>();
			while(!q2.isEmpty())
			{
				TreeNode curNode = q2.poll();	
				if(curNode.left!=null)
				{
					q1.offer(curNode.left);
					list2.add(curNode.left.val);
				}
				if(curNode.right!=null)
				{
					q1.offer(curNode.right);
					list2.add(curNode.right.val);
				}
			}
			if(!list2.isEmpty())
			{
				arrLists.add(list2);
			}
		}
    	return arrLists;
    }
    
	//Solution 2: Use two queue to to cut off where to create a new list
    // Use for loop to control the number of process 
    public List<List<Integer>> levelOrder_2(TreeNode root) 
    {
    	
    	List<List<Integer>> arrLists = new ArrayList<List<Integer>>();
    	if(root==null) return arrLists;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		List<Integer> rootList = new ArrayList<Integer>();
		rootList.add(root.val);
		arrLists.add(rootList);
		while(!q.isEmpty())
		{
			
			List<Integer> list = new ArrayList<Integer>();
			int curQSize = q.size();
			for(int i=0; i<curQSize; i++)
			{
				TreeNode curNode = q.poll();
			
				if(curNode.left!=null)
				{
					q.offer(curNode.left);
					list.add(curNode.left.val);
				}
				if(curNode.right!=null)
				{
					q.offer(curNode.right);
					list.add(curNode.right.val);
				}
			}
			
			//If after for loop, the result is still an empty, it means that the last level has done in previous loop, 
			//this level means the traverse of the null children of the last level. It needs to delete.
			if(!list.isEmpty())
			{
				arrLists.add(list);
			}
		}

    	return arrLists;    

    }
}
