package leetcode101to130;

import java.util.ArrayList;
import java.util.List;

public class PathSun_2_113 
{
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        
        List<Integer> cursol = new ArrayList<Integer>();
        pathSum(root,sum,cursol,result);
        
        return result;
    }
    
    public void pathSum(TreeNode root, int sum, List<Integer> cursol, List<List<Integer>> result)
    {
        if(root==null) return;
        if(sum==root.val && root.left==null && root.right==null) 
        {
            cursol.add(root.val);
            result.add(new ArrayList<Integer>(cursol));
            cursol.remove(cursol.size()-1);
            return;
        }
        if(sum!=root.val && root.left==null && root.right==null) return;
        
        cursol.add(root.val);
        sum = sum-root.val;
        if(root.left!=null)
            pathSum(root.left,sum,cursol,result);
        if(root.right!=null)
            pathSum(root.right,sum,cursol,result);
        
        cursol.remove(cursol.size()-1);
    }

}
