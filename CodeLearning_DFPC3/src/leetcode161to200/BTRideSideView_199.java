package leetcode161to200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRideSideView_199 
{
	
	
	//My Solution : Level Order Traverse
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int count = q.size();
            TreeNode rightmost = q.poll();
            result.add(rightmost.val);
            if(rightmost.right!=null)
                q.offer(rightmost.right);
            if(rightmost.left!=null)
                q.offer(rightmost.left);
            
            for(int i=1; i<count; i++)
            {
                TreeNode cur = q.poll();
                
                if(cur.right!=null)
                    q.offer(cur.right);
                if(cur.left!=null)
                    q.offer(cur.left);
            }
        }
        return result;
    }
}
