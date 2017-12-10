package leetcode251to300;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class BTPaths_257 
{
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> result = new ArrayList<String>();
        if(root==null) return result;
        
        helper(root,new ArrayList<Integer>(),result);
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> cursol, List<String> result)
    {
        cursol.add(root.val);
        if(root.left==null && root.right==null)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(cursol.get(0));
            for(int i=1; i<cursol.size(); i++)
            {
                sb.append("->").append(cursol.get(i));
            }
            result.add(sb.toString());
            cursol.remove(cursol.size()-1);
            return;
        }
        if(root.left!=null)
            helper(root.left,cursol,result);
        if(root.right!=null)
            helper(root.right,cursol,result);
        cursol.remove(cursol.size()-1);
    }
}
