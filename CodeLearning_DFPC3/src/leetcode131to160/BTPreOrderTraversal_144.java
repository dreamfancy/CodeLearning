package leetcode131to160;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPreOrderTraversal_144 {

	//Sol 2: Iteration: Use stack to simulate the recursion
    public List<Integer> preorderTraversal_2(TreeNode root) 
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
                root = root.left;
            }
            if(!st.isEmpty())
            {
                TreeNode cur = st.pop();
                root = cur.right;
            }
        }
        return result;  
    }
	
	//Sol 1: Recursion
    public List<Integer> preorderTraversal_Rec(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        preorderTraversal(root,result);
        return result;
    }
    
    public void preorderTraversal(TreeNode root, List<Integer> result)
    {
        if(root==null) return;
        result.add(root.val);
        preorderTraversal(root.left,result);
        preorderTraversal(root.right,result);
    }
}
