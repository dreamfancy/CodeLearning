package leetcode201to250;

import tree.TreeNode;

public class CountUnivalueSubtrees_250 
{
	//sol 2 : recursion and count only update once
    public int countUnivalSubtrees_2(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }
    
    private boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }

	
	
	//sol 1: recursion the number
    private int max = 0;    
    public int countUnivalSubtrees_1(TreeNode root)
    {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) 
    {
        if(root==null) return 0;
        if(root.left==null && root.right==null)
        {
            max = Math.max(1,max);
            return 1;
        }
        else if(root.left==null)
        {
            int num = helper(root.right);
            if(num<=0) return num;
            else if(root.right.val==root.val)
            {
                max = Math.max(max,num+1);
                return num+1;
            }
            else
            {
                return -num;
            }
        }
        else if(root.right==null)
        {
            int num = helper(root.left);
            if(num==0) return 0;
            if(num<0) return num;
            else if(root.left.val==root.val)
            {
                max = Math.max(max,num+1);
                return num+1;
            }
            else
            {
                return -num;
            }
        }
        else
        {
            int num1 = helper(root.left);
            int num2 = helper(root.right);
            if(num1<=0 && num2<=0)
            {
                max = Math.max(-num1-num2,max);
                return num1+num2;
            }
            else if(num1<=0)
            {
                max = Math.max(-num1+num2,max);
                return num1-num2;
            }
            else if(num2<=0)
            {
                max = Math.max(num1-num2,max);
                return -num1+num2;
            }
            else if(root.left.val==root.val && root.val==root.right.val)
            {
                max = Math.max(num1+num2+1,max);
                return num1+num2+1;
            }
            else
            {
                max = Math.max(num1+num2,max);
                return -num1-num2;
            }
        }
    }	

}
