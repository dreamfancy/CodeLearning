package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal_94 {
    
	//Solution 1: Recursive with returning list
	public List<Integer> inorderTraversal(TreeNode root) 
    {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	return inorderTraversal_recur(root,list);
    	
    }
    
    public List<Integer> inorderTraversal_recur(TreeNode root, List<Integer> list)
    {
    	if(root==null) return list;
    	list = inorderTraversal_recur(root.left,list);
    	list.add(root.val);
    	list = inorderTraversal_recur(root.right,list);
    	
    	return  list;
    }
    
	//Solution 2: Recursive without returning list because the head is not changing
	public List<Integer> inorderTraversal2(TreeNode root) 
    {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	inorderTraversal_recur2(root,list);
    	return list;
    	
    }
    
    public void inorderTraversal_recur2(TreeNode root, List<Integer> list)
    {
    	if(root==null) return;
    	inorderTraversal_recur2(root.left,list);
    	list.add(root.val);
    	inorderTraversal_recur2(root.right,list);
    }

    //Solution 3: Iterative Solution
	public List<Integer> inorderTraversal3(TreeNode root) 
    {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	inorderTraversal_recur2(root,list);
    	return list;
    	
    }
    
    public void inorderTraversal_iter3(TreeNode root, List<Integer> list)
    {
    	if(root==null) return;
    	Stack<TreeNode> s_nodes = new Stack<TreeNode>();
    	s_nodes.push(root);
    	TreeNode tempNode = root;
    	while(!s_nodes.empty())
    	{
    		while((s_nodes.peek())!=null) 
    		{
    			tempNode = s_nodes.peek();
    			tempNode = tempNode.left;
    			s_nodes.push(tempNode);
    		}
    		
    		s_nodes.pop();
    		
    		if(!s_nodes.empty())
    		{
    			tempNode = s_nodes.pop();
    			list.add(tempNode.val);
    			s_nodes.push(tempNode.right);
    		}    		
    	}
    }
    
    
    //Standard Solution:
    public List<Integer> inorderTraversal_standard(TreeNode root)
    {
    	List<Integer>  ans = new ArrayList<Integer>();
    	if(root ==null) return ans;
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	while(root!=null || !st.isEmpty())
    	{
    		if(root==null) 
    		{
    			root = st.pop();
    			ans.add(root.val);
    			root = root.right;
    		}
    		else
    		{
    			st.push(root);
    			root = root.left;
    		}
    	}
    	return ans;
    }
    
}
