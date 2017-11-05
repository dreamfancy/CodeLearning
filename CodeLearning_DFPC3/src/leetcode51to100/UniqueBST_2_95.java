package leetcode51to100;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class UniqueBST_2_95 
{
	
	//Sol 2: DP
	public static List<TreeNode> generateTrees_DP(int n) {
	    List<TreeNode>[] result = new List[n + 1];
	    result[0] = new ArrayList<TreeNode>();
	    if (n == 0) {
	        return result[0];
	    }

	    result[0].add(null);
	    for (int len = 1; len <= n; len++) {
	        result[len] = new ArrayList<TreeNode>();
	        for (int j = 0; j < len; j++) {
	            for (TreeNode nodeL : result[j]) {
	                for (TreeNode nodeR : result[len - j - 1]) {
	                    TreeNode node = new TreeNode(j + 1);
	                    node.left = nodeL;
	                    node.right = clone(nodeR, j + 1);
	                    result[len].add(node);
	                }
	            }
	        }
	    }
	    return result[n];
	}

	private static TreeNode clone(TreeNode n, int offset) {
	    if (n == null) {
	        return null;
	    }
	    TreeNode node = new TreeNode(n.val + offset);
	    node.left = clone(n.left, offset);
	    node.right = clone(n.right, offset);
	    return node;
	}
	
	//Sol 1: Revisit !!!For loop for a list of result
    public List<TreeNode> generateTrees(int n) {     
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(n<=0) return res;
        return generateTrees(1,n);
    }
    
    public List<TreeNode> generateTrees(int start, int end)
    {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start==end)
        {
            res.add (new TreeNode(start));
            return res;
        }
        
        if(start>end)
        {
            res.add(null);//!!!Why!!!
            return res;
        }
        
        for(int i=start; i<=end; i++)
        {
            List<TreeNode> leftroots = generateTrees(start,i-1);
            List<TreeNode> rightroots = generateTrees(i+1,end);
            for(TreeNode l : leftroots)
            {
                for(TreeNode r: rightroots)
                {
                    TreeNode select = new TreeNode(i);
                    select.left = l;
                    select.right = r;
                    res.add(select);
                }
            }
        }
        return res;  
    }

}
