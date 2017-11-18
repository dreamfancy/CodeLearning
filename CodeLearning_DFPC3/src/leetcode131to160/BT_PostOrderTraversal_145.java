package leetcode131to160;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BT_PostOrderTraversal_145 
{
	//Sol 2: Iteration
    public List<Integer> postorderTraversal_2(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        
        Stack<TreeNode> st = new Stack<TreeNode>();
                
        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                result.add(root.val);
                st.push(root);
                root = root.right;
            }
            if(!st.isEmpty())
            {
                TreeNode cur = st.pop();
                root = cur.left;
            }
        }
        Collections.reverse(result);
        return result;  
    }
	
	
	
	//Sol 1: Recursion
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        postorderTraversal(root,result);
        return result;
    }
    
    public void postorderTraversal(TreeNode root, List<Integer> result)
    {
        if(root==null) return;
        postorderTraversal(root.left,result);
        postorderTraversal(root.right,result);
        result.add(root.val);

    }

}
