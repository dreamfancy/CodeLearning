package leetcode51to100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

public class BTInOrderTraversal_94 
{
	//Sol 2: Iterative Solution 
    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        while(root!=null || !st.isEmpty())
        {
            while(root!=null) 
            {
                st.push(root);
                root = root.left;
            }
            TreeNode cur = st.pop();
            res.add(cur.val);
            root = cur.right;
        }
        return res;
    }
	
	
	//Sol 1: Recursion
	
    public List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorderTraversal(root,res);
        return res;
        
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> res)
    {
        if(root==null) return;
        if(root.left!=null)
            inorderTraversal(root.left,res);
        res.add(root.val);
        if(root.right!=null)
            inorderTraversal(root.right,res);
    }

}
