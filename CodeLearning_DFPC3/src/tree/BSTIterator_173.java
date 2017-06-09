package tree;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//In order traverse the BST to a LinkedList then next it
public class BSTIterator_173 {

    public BSTIterator_173(TreeNode root) {
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
       return false; 
    }

    /** @return the next smallest number */
    public int next() {
      return -1;  
    }
}
