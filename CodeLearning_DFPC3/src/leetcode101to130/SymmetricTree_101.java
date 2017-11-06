package leetcode101to130;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree_101 {

	//Sol 4: ITeration Using Stack
	public boolean isSymmetric_5(TreeNode root) 
	{
		if(root==null) return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode left,right;
		if(root.left!=null) 
		{
			if(root.right==null)return false;
			stack.push(root.left);
			stack.push(root.right);
		}
		else if (root.right!=null)
		{
			return false;
		}
		while(!stack.isEmpty())
		{
			if(stack.size()%2!=0) return false;
			right = stack.pop();
			left = stack.pop();
			if(right.val!=left.val) return false;
			
			if(left.left!=null)
			{
				if(right.right==null) return false;
				stack.push(left.left);
				stack.push(right.right);
			}
			else if(right.right!=null) return false;
			
			if(left.right!=null)
			{
				if(right.left==null) return false;
				stack.push(left.right);
				stack.push(right.left);
			}
			else if(right.left!=null) return false;
		}
		return true;
	}

	
	//Sol 3: Iteration Using Queue
	 public boolean isSymmetric_3(TreeNode root) {
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        if(root == null) return true;
	        q.add(root.left);
	        q.add(root.right);
	        while(q.size() > 1){
	            TreeNode left = q.poll(),
	                     right = q.poll();
	            if(left== null&& right == null) continue;
	            if(left == null ^ right == null) return false;
	            if(left.val != right.val) return false;
	            q.add(left.left);
	            q.add(right.right);
	            q.add(left.right);
	            q.add(right.left);            
	        }
	        return true;
	    }
	//Sol 2: Recursion
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
	
	
	// My Solution :
	//Use InOrder Traverse to compare the arry
	//171 out of 173 test cases pass, but left two not
    public boolean isSymmetric_1_Not_All_Test_Pass(TreeNode root) {
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        inOrderTraverse(root,list);
        return checkSymmetricList(list);
    }
    
    
    public void inOrderTraverse(TreeNode root, List<TreeNode> list)
    {
        if(root==null) 
        {
            list.add(null);
            return;
        }
        inOrderTraverse(root.left,list);
        list.add(root);
        inOrderTraverse(root.right,list);
    }
    
    public boolean checkSymmetricList(List<TreeNode> list)
    {
        
        for(TreeNode t: list)
        {
            if(t==null)            
            {
                System.out.print("null  ");
            }
            else System.out.print(t.val +"  ");
        }
        
        if(list==null || list.size()<=1) return true;
        int n = list.size();
        int left = 0;
        int right = 0;
        if(n%2==0)
        {
            left = n/2-1;
            right = n/2;
        }
        else
        {
            left = n/2-1;
            right = n/2+1;
        }
        
        while(left>=0)
        {
            if(list.get(left)==null && list.get(right)==null)
            {
                left--;
                right++;
                continue;
            }
            else if (list.get(left)==null || list.get(right)==null) return false;
            else if(list.get(left).val!=list.get(right).val) return false;
            left--;
            right++;
        }
        return true;
    }
}
