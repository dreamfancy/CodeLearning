package leetcode101to130;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode_116_117 {
	
	
	//sol 4: 117
	public void connect_4(TreeLinkNode root) {
	    TreeLinkNode dummyHead = new TreeLinkNode();
	    TreeLinkNode pre = dummyHead;
	    while (root != null) {
		    if (root.left != null) {
			    pre.next = root.left;
			    pre = pre.next;
		    }
		    if (root.right != null) {
			    pre.next = root.right;
			    pre = pre.next;
		    }
		    root = root.next;
		    if (root == null) {
			    pre = dummyHead;
			    root = dummyHead.next;
			    dummyHead.next = null;
		    }
	    }
	}
	
	//sol 3: 116
    public void connect_3_rec(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                
                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }
	
	//sol 2: recursion! for 116
	public void connect_2(TreeLinkNode root)
	{
		if(root==null) return;
		if(root.left!=null)
		{
			root.left.next = root.right;
			if(root.next!=null)
			{
				root.right.next = root.next.left;
			}
		}
		connect(root.left);
		connect(root.right);
		
	}
	
	
	//sol 1: My sol: use queue
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int levelnum = q.size();
            TreeLinkNode pre = null;
            for(int i=0; i<levelnum; i++)
            {
                TreeLinkNode cur = q.poll();
                if(cur.left!=null)
                    q.offer(cur.left);
                if(cur.right!=null)    
                    q.offer(cur.right);
                if(pre!=null) pre.next = cur;
                pre = cur;
            }
            pre.next = null;
        }
    }
}
