package leetcode251to300;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBT_297 
{
    public String serialize(TreeNode root) 
    {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode curNode = queue.poll();
            if(curNode==null)
            {
                sb.append("# ");
                continue;
            }
            sb.append(curNode.val).append(" ");
            queue.offer(curNode.left);
            queue.offer(curNode.right);
        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if(data==null || data.length()==0) return null;
        String[] strArr = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        for(int i=1; i<strArr.length; i = i+2)
        {
            TreeNode cur = queue.poll();
            if(!strArr[i].equals("#"))
            {
                cur.left = new TreeNode(Integer.parseInt(strArr[i]));
                queue.offer(cur.left);
            }
            if(!strArr[i+1].equals("#"))
            {
                cur.right = new TreeNode(Integer.parseInt(strArr[i+1]));
                queue.offer(cur.right);
            }
        }
        
        return root;
    }

}
