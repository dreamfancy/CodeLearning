package leetcode131to160;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTUpsideDown_156 {

	//Sol 4: Recursion!
    public TreeNode upsideDownBinaryTree_recur(TreeNode root) 
    {
        if(root == null || root.left == null) return root;
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;    
    }	
	
	//Sol 3: Iteration: Greedy change node Revisit!!
	public TreeNode upsideDownBinaryTree_3(TreeNode root)
	{
		if(root==null) return null;
		TreeNode parent = root;
		TreeNode cur = root;
		TreeNode leftChild = cur.left;
		TreeNode rightChild = cur.right;
		root.left = null;
		root.right = null;
		while(leftChild!=null)
		{
			TreeNode nextLeftChild =leftChild.left;
			TreeNode nextRightChild =leftChild.right;
			leftChild.left = rightChild;
			leftChild.right = cur;
			cur = leftChild;
			leftChild = nextLeftChild;
			rightChild = nextRightChild;
		}
		return leftChild;	
	}
	
	
	//Sol 2: Use stack to reconstructure
	//Time exceeds the limit
    public TreeNode upsideDownBinaryTree_2(TreeNode root) 
    {
        if(root==null) return null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(root.left!=null)
        {
            st.push(root);
            System.out.println(st.peek());
            st.push(root.right);
            System.out.println(st.peek());
            root = root.left;
        }
        
        TreeNode newroot = root;
        TreeNode cur = newroot;

        while(!st.isEmpty())
        {
            cur.left = st.pop();
            cur.right = st.pop();
            cur = cur.right;
        }
        
        return newroot;
        
    }
	
    
    //Wrong!!! Do not visit
	//Sol 1: My solution: Try to simulate a postorder traverse.
	//But please attention if right==null ? will cause different results
    //Wrong!!!
	public TreeNode upsideDownBinaryTree(TreeNode root) 
    {
        if(root==null) return null;
        List<TreeNode> seq = new ArrayList<TreeNode>();

        postOrderTraverse(root,seq);
        
        int i=0;
        
        int cur = 2;
        TreeNode newhead = seq.get(2);
        TreeNode curNode = newhead;

        while((cur+2)<seq.size())
        {
            TreeNode leftNode = seq.get(cur+1);
            TreeNode rightNode = seq.get(cur+2);
            
            curNode.left = leftNode;
            curNode.right = rightNode;
            if(leftNode!=null)
            {
                leftNode.left = null;
                leftNode.right = null;
            }
            curNode = rightNode;
            cur = cur+2;
        }
        curNode.left = null;
        curNode.right = null;
        return newhead;
        
    }
    
    private void postOrderTraverse(TreeNode root,List<TreeNode> seq)
    {
        if(root==null)
        {
            seq.add(null);
            return;
        }
        postOrderTraverse(root.left,seq);
        postOrderTraverse(root.right,seq);
        seq.add(root);
    }
}
