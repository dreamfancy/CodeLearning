package leetcode101to130;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPreorderAndInorder_105 
{
	//Sol 2: When we get a value(root) from preorder, we want to find its position in inorder array. So:
	//First build a hashmap of inorder value and its position in array.
	public TreeNode buildTree_2(int[] preorder, int[] inorder) {
	    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
	    
	    for(int i = 0; i < inorder.length; i++) {
	        inMap.put(inorder[i], i);
	    }

	    TreeNode root = buildTree_2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	    return root;
	}

	public TreeNode buildTree_2(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
	    if(preStart > preEnd || inStart > inEnd) return null;
	    
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inRoot = inMap.get(root.val);
	    int numsLeft = inRoot - inStart;
	    
	    root.left = buildTree_2(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
	    root.right = buildTree_2(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
	    
	    return root;
	}
	
	
	//Sol 1: Directly get the relationship
    public TreeNode buildTree_1(int[] preorder, int[] inorder) 
    {
        if(preorder==null || inorder==null || preorder.length==0 || preorder.length!=inorder.length) return null;

        return buildTree_1(preorder,0,0,preorder.length-1,inorder);
    }
    
    public TreeNode buildTree_1(int[] preorder, int prestart, int instart, int inend, int[] inorder)
    {
        if(prestart>=preorder.length || instart>inend) return null;   
        int i=0;
        for(i=instart; i<=inend; i++)
        {
            if(inorder[i]==preorder[prestart]) break;
        }
        TreeNode curroot = new TreeNode(preorder[prestart]);
        curroot.left = buildTree_1(preorder,prestart+1, instart, i-1,inorder);
        int rchild = prestart + i - instart + 1;
        curroot.right = buildTree_1(preorder,rchild,i+1,inend,inorder);
        return curroot;
    }	

}
