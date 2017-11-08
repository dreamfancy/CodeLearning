package leetcode101to130;

public class ConvertSortedArrayToBST_108 
{
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) return null;
        if(nums.length==1) return new TreeNode(nums[0]);
        
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    
    public TreeNode sortedArrayToBST(int[] nums,int start,int end)
    {
        if(start>end) return null;
        if(start==end) return new TreeNode(nums[start]);
        
        int mid = start + (end-start)/2 +(end-start)%2;//why think about it 
        
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = sortedArrayToBST(nums,start,mid-1);
        cur.right = sortedArrayToBST(nums,mid+1,end);
        return cur;
    }

}
