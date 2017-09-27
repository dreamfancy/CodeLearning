package treetraverse;

public class ConvertSortedListToBST_109 
{
	
	
	//Solution 4: LC_Toprated 
	//Use static variable in class to traverse the tree.
	
	static ListNode cur;
    public TreeNode sortedListToBST_4(ListNode head) {
        if (head == null){
            return null;
        }
        int size = getSize(head);
        cur = head;
        return constructTree(size);
    }
    
    private TreeNode constructTree(int size){
        if (size <= 0){
            return null;
        }
        
        TreeNode left = constructTree(size/2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = constructTree(size - 1- size/2);
        root.left = left;
        root.right = right;
        return root;
    }
    
    private int getSize(ListNode head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }
	
	
	//Solution 3 : Discussion 
    public TreeNode sortedListToBST_3(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;
        
        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }
	
	//Solution 2: Similar to Solution 1 But to reduce traverse of linkedlist
	//we update the sequence of call to make sure one traverse of linkedlist
	//can resolve the problem
	
	static ListNode h;
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
 
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
 
	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
 
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
 
	// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
 
		// mid
		int mid = (start + end) / 2;
 
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}
	
	
	
	//Solution 1: My solution : Time pass limit
	//Divide big list to smaller two recursively
    public TreeNode sortedListToBST(ListNode head, int end)
    {
        if(head==null) return null;
        if(end<0) return null;
        if(end==0) return new TreeNode(head.val);
         
        int mid = end/2;
        System.out.println("Current mid is : " + mid);

        ListNode midNode = head;
        int count = mid;
        while(count>0)
        {
            midNode = midNode.next;
            count--;
        }
        
        System.out.println("Current root is : " + midNode.val);
        TreeNode root = new TreeNode(midNode.val);
        root.left = sortedListToBST(head,mid-1);
        root.right = sortedListToBST(midNode.next,end-mid-1);
            
        return root;
    }
    public int getLength_1(ListNode head)
    {
        if(head==null) return 0;
        int count = 1;
        while(head.next!=null)
        {
            count++;
            head = head.next;
        }
        return count;
    }
}
