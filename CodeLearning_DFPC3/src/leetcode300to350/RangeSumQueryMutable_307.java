package leetcode300to350;

public class RangeSumQueryMutable_307 
{
	class NumArray {

	    int[] nums;
	    int[] tree;
	    int n;
	    
	    public NumArray(int[] nums) 
	    {
	        this.nums = nums;
	        int sum;
	        int lowbit;
	        tree = new int[nums.length+1];
	        
	        for(int i=1; i<tree.length; i++)
	        {
	            sum = 0;
	            lowbit = i&(-i);
	            for(int j=i; j>i-lowbit; j--)
	            {
	                sum += nums[j-1];
	            }
	            tree[i] = sum;
	        }
	        
	    }
	    
	    public void update(int i, int val) 
	    {
	        int diff = val - nums[i];
	        nums[i] = val;
	        i++;   //<-- i+1 is the corresponding position in the tree
	        for(;i<tree.length; i+=(i&(-i)))
	            tree[i] += diff;
	        
	    }
	    
	    public int sumRange(int i, int j) 
	    {
	        return sum(j+1) -sum(i);
	    }
	    
	    private int sum(int k)
	    {
	        int sum = 0;
	        
	        while(k>0)
	        {
	            sum += tree[k];
	            int lowbit = k&(-k);
	            k -= lowbit;
	        }
	        return sum;
	    }
	}

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * obj.update(i,val);
	 * int param_2 = obj.sumRange(i,j);
	 */
	
	
	
	/*
	 
	//Sol 1: Segment Tree
	
	public class NumArray {

	    class SegmentTreeNode {
	        int start, end;
	        SegmentTreeNode left, right;
	        int sum;

	        public SegmentTreeNode(int start, int end) {
	            this.start = start;
	            this.end = end;
	            this.left = null;
	            this.right = null;
	            this.sum = 0;
	        }
	    }
	      
	    SegmentTreeNode root = null;
	   
	    public NumArray(int[] nums) {
	        root = buildTree(nums, 0, nums.length-1);
	    }

	    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
	        if (start > end) {
	            return null;
	        } else {
	            SegmentTreeNode ret = new SegmentTreeNode(start, end);
	            if (start == end) {
	                ret.sum = nums[start];
	            } else {
	                int mid = start  + (end - start) / 2;             
	                ret.left = buildTree(nums, start, mid);
	                ret.right = buildTree(nums, mid + 1, end);
	                ret.sum = ret.left.sum + ret.right.sum;
	            }         
	            return ret;
	        }
	    }
	   
	    void update(int i, int val) {
	        update(root, i, val);
	    }
	   
	    void update(SegmentTreeNode root, int pos, int val) {
	        if (root.start == root.end) {
	           root.sum = val;
	        } else {
	            int mid = root.start + (root.end - root.start) / 2;
	            if (pos <= mid) {
	                 update(root.left, pos, val);
	            } else {
	                 update(root.right, pos, val);
	            }
	            root.sum = root.left.sum + root.right.sum;
	        }
	    }

	    public int sumRange(int i, int j) {
	        return sumRange(root, i, j);
	    }
	    
	    public int sumRange(SegmentTreeNode root, int start, int end) {
	        if (root.end == end && root.start == start) {
	            return root.sum;
	        } else {
	            int mid = root.start + (root.end - root.start) / 2;
	            if (end <= mid) {
	                return sumRange(root.left, start, end);
	            } else if (start >= mid+1) {
	                return sumRange(root.right, start, end);
	            }  else {    
	                return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
	            }
	        }
	    }
	}

	
*/
}
