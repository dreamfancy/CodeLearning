package treetraverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal_145 {
	
	//PostOrder Iteration thought: 
	//stack.push(root) root= root.left root = stack.pop(), root = root.light
	//are four key chains to manage
	
    public List<Integer> postorderTraversal_standard(TreeNode root)
    {
    	List<Integer>  ans = new ArrayList<Integer>();
    	if(root ==null) return ans;
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	while(root!=null || !st.isEmpty()) //Remember and Revisit!
    	{
    		if(root==null) 
    		{
    			root = st.pop();
    			root = root.left;
    		}
    		else
    		{
    			ans.add(root.val);
    			st.push(root);
    			root = root.right;
    		}
    	}
    	Collections.reverse(ans);//Remember to reverse ArrayList/LinkedList
    	return ans;    	
    }

}
