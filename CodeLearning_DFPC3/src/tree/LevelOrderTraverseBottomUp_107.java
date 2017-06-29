package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverseBottomUp_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) 
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
		
		Collections.reverse(arrLists);

    	return arrLists;    
    	
    }
}
