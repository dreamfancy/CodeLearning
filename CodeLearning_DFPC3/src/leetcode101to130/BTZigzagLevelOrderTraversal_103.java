package leetcode101to130;

import java.util.ArrayList;
import java.util.List;

public class BTZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
        {
            return result;
        }
        
        travel(root,result,0);
        return result;
    }
    
    private void travel(TreeNode cur, List<List<Integer>> result, int level)
    {
        if(cur==null) return;
        if(result.size()<=level)
        {
            List<Integer> newlevel = new ArrayList<Integer>();
            result.add(newlevel);
        }
        List<Integer> curlist = result.get(level);
        if(level%2==0)
        {
            curlist.add(cur.val);
        }
        else
        {
            curlist.add(0,cur.val);
        }
        travel(cur.left,result,level+1);
        travel(cur.right,result,level+1);
    }
}
