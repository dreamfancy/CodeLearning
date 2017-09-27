package treetraverse;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConstructStringFromBT_606 
{
	
	//Solution 1: My solution : Recursive
	//Why !!!: Parent and children share the same logic, so recursive
    public String tree2str(TreeNode t) 
    {
    	StringBuilder sb = new StringBuilder();
    	tree2str(t,sb);
    	return sb.toString();
    }
    
    public void tree2str(TreeNode t, StringBuilder sb)
    {
    	if(t==null) return;
    	sb.append(t.val);
    	if(t.left==null && t.right==null) return;
    	//if(t.left!=null)
    	//{
    		sb.append('(');
    		tree2str(t.left,sb);
    		sb.append(')');
    	//}
    	if(t.right!=null)
    	{
    		sb.append('(');
    		tree2str(t.right,sb);
    		sb.append(')');
    	}
    	return;    	
    }

    public String tree2str_2(TreeNode t) 
    {
    	StringBuilder sb = new StringBuilder();
    	tree2str(t,sb);
    	return sb.toString();
    }
    
    public void tree2str_2(TreeNode t, StringBuilder sb)
    {
    	if(t==null) return;
    	sb.append(t.val);
    	if(t.left==null && t.right==null) return;
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	TreeNode cur = null;
    	Set<TreeNode> visited = new HashSet<TreeNode>();
    	while(!st.isEmpty())
    	{		
    		t = st.peek();
            if (visited.contains(t)) {
                st.pop();
                sb.append(")");
            } else {
                visited.add(t);
                sb.append("(" + t.val);
                if(t.left==null && t.right!=null)
                	sb.append("()");
                if(t.right!=null)
                {
                	st.push(t.right);
                }
                if(t.left!=null)
                {
                	st.push(t.left);
                }
            }
    	}
    }
    	
    	
    //Solution 3: Official Solution for Iterative 
        public String tree2str_3(TreeNode t) {
            if (t == null)
                return "";
            Stack < TreeNode > stack = new Stack < > ();
            stack.push(t);
            Set < TreeNode > visited = new HashSet < > ();
            StringBuilder s = new StringBuilder();
            while (!stack.isEmpty()) {
                t = stack.peek();
                if (visited.contains(t)) {
                    stack.pop();
                    s.append(")");
                } else {
                    visited.add(t);
                    s.append("(" + t.val);
                    if (t.left == null && t.right != null)
                        s.append("()");
                    if (t.right != null)
                        stack.push(t.right);
                    if (t.left != null)
                        stack.push(t.left);
                }
            }
            return s.substring(1, s.length() - 1);
        }	

}
