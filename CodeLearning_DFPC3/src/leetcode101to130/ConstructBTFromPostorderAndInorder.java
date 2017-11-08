package leetcode101to130;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPostorderAndInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length!=postorder.length) return null;
        Map<Integer,Integer> hashinorder = new HashMap<Integer,Integer>();
        for(int i=0; i<inorder.length; i++)
        {
            hashinorder.put(inorder[i],i);
        }
        
        return buildTree(inorder,0,inorder.length-1,postorder,postorder.length-1,hashinorder);
    }
    
    public TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int postend, Map<Integer,Integer> hashinorder)
    {
        if(instart>inend || postend<0) return null;
        
        TreeNode curroot = new TreeNode(postorder[postend]);
        int inorderpos = hashinorder.get(postorder[postend]);
        int numleftchild = inorderpos-instart;
        int numrightchild = inend-inorderpos;
        
        int leftchildendpostorder = postend - numrightchild - 1;
        
        curroot.left = buildTree(inorder,instart,inorderpos-1,postorder,leftchildendpostorder, hashinorder);
        curroot.right = buildTree(inorder,inorderpos+1,inend,postorder,postend-1, hashinorder);
        
        return curroot;
    }
}
