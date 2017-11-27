package leetcode161to200;

import java.util.Stack;

public class BSTIterator_173 {
    Stack<TreeNode> st;
    public BSTIterator_173(TreeNode root) {
        st = new Stack<TreeNode>();
        while(root!=null) 
        {
            st.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = st.pop();
        int retval = cur.val;
        if(cur.right!=null)
        {
            cur = cur.right;
            while(cur!=null)
            {
                st.push(cur);
                cur= cur.left;
            }
        }
        return retval;
    }
}
