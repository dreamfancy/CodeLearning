package tree;

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
    	
    }
}
