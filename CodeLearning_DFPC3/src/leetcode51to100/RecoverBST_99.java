package leetcode51to100;

import java.util.Stack;

import tree.TreeNode;

public class RecoverBST_99 
{
	//Sol 2: 
	public void recoverTree_MorrisTraversal(TreeNode root)
	{
		if(root==null) return;
		TreeNode pre = new TreeNode(Integer.MIN_VALUE);        
        TreeNode first = null;
        TreeNode second = null;
        TreeNode mpre = null;
        while(root!=null)
        {
        	if(root.left==null)
        	{
        		processNodes(root,pre,first,second);
        		root = root.right;
        	}
        	else
        	{
        		mpre = root.left;
        		while(mpre.right!=null && mpre.right!=root)
        		{
        			mpre = mpre.right;
        		}
        		if(mpre.right==null)
        		{
        			mpre.right = root;
        			root = root.left;
        		}
        		else
        		{
        			mpre.right = null;
        			root = root.right;
        		}
      
        	}
        }
		
	}
	
	public void processNodes(TreeNode cur, TreeNode pre, TreeNode first, TreeNode second)
	{
        if(first==null && pre.val>=cur.val)
        {
            first = pre;
        }
        if(first!=null && pre.val>=cur.val)
        {
            second = cur;   
        }
	}
	
	
	//Sol 1: Traverse tree and make note, process after traverse is done
    public void recoverTree_Stack(TreeNode root) 
    {
        if(root==null) return;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);        
        TreeNode first = null;
        TreeNode second = null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            
            if(first==null && pre.val>=root.val)
            {
                first = pre;
            }
            if(first!=null && pre.val>=root.val)
            {
                second = root;   
            }
            
            pre = root;
            root = root.right;
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp; 
    }
	

}
