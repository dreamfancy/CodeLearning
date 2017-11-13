package leetcode101to130;

import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers_129 {
	
	//Sol 2: No use of sb builder, create the number based on
	// 10*predigit + curdigit
	
	public int sumNumbers_2(TreeNode root) {
		return sum_2(root, 0);
	}

	public int sum_2(TreeNode n, int s){
		if (n == null) return 0;
		if (n.right == null && n.left == null) return s*10 + n.val;
		return sum_2(n.left, s*10 + n.val) + sum_2(n.right, s*10 + n.val);
	}
	
	
	//Sol 1: StringBuilder
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        List<Integer> result = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        sumNumbers(root,sb,result);
        int sum = 0;
        for(int i: result)
        {
            sum += i;
        }
        return sum;
    }
    
    public void sumNumbers(TreeNode root,StringBuilder sb, List<Integer> result)
    {
        if(root==null) return;
        sb.append(root.val);
        if(root.left==null && root.right==null)
        {
            result.add(Integer.parseInt(sb.toString()));
        }
        if(root.left!=null)
        {
            sumNumbers(root.left,sb,result);
        }
        if(root.right!=null)
        {
            sumNumbers(root.right,sb,result);
        }
        sb.setLength(sb.length()-1);
    }
}
