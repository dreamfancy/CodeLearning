package treetraverse;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal_144 {
	
	//Solution 1: Recursion
    public List<Integer> preorderTraversal(TreeNode root) {
    	
        LinkedList<Integer> list = new LinkedList<Integer>();
        //return preorderTraversalWithList(root,list);
        return preorderTraversal_Iteration_Deque(root,list);
    }
	
    public List<Integer> preorderTraversalWithList(TreeNode root, List<Integer> li)
    {
        if(root==null) return li;
        li.add(root.val);
		//if(root.left!=null) 
        li = preorderTraversalWithList(root.left,li);
		//if(root.right!=null) 
        li = preorderTraversalWithList(root.right,li);
        return li;
    }

    //standard solution for iteration
    public List<Integer> preorderTraversal_standard(TreeNode root)
    {
    	List<Integer>  ans = new ArrayList<Integer>();
    	if(root ==null) return ans;
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	while(root!=null || !st.isEmpty())
    	{
    		if(root==null) 
    		{
    			root = st.pop();
    			root = root.right;
    		}
    		else
    		{
    			st.push(root);
    			ans.add(root.val);
    			root = root.left;
    		}
    	}
    	return ans;
    }
    
    //For Preorder, the left nodes have priority than any right nodes, even the parents' right node, 
    //then we can think that stack is a good structure to do this because the latest in stack can pop up earlier
    //(than their parents)
    public List<Integer> preorderTraversal_Iteration_Stack(TreeNode root, List<Integer> li)
    {
    	if(root == null) return li;
    	TreeNode cur = root;
    	//li.add(cur.val);
  
    	Stack<TreeNode> s_nodes  = new Stack<TreeNode>();
    	s_nodes.push(cur);
    	while(!s_nodes.empty())
    	{
    		TreeNode c = s_nodes.pop();
    		li.add(c.val);
    		if(c.right!=null) s_nodes.push(c.right);
    		if(c.left!=null) s_nodes.push(c.left);
    	}
    	
    	return li;
    }
    
    public List<Integer> preorderTraversal_Iteration_Deque(TreeNode root, List<Integer> li)
    {
    	if(root == null) return li;
    	TreeNode cur = root;
    	//li.add(cur.val);
  
    	Deque<TreeNode> s_nodes  = new ArrayDeque<TreeNode>();
    	s_nodes.push(cur);
    	while(!s_nodes.isEmpty()) //Stack has Empty(), others are all isEmpty()?
    	{
    		TreeNode c = s_nodes.removeLast();
    		li.add(c.val);
    		if(c.right!=null) s_nodes.addLast(c.right);
    		if(c.left!=null) s_nodes.addLast(c.left);
    	}
    	
    	return li;
    }
    
    //For the iteration_deque solution, we can also change it to linkedlist. In other word,
    //LinkedList API also provides addFirst(E), addLast(E), contains(), getFirst(), getLast(),
    //offerFirst(),offerLast(),peek(),peekFirst(),peekLast() .etc.
    
}
