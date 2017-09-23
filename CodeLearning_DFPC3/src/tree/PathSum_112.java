package tree;

public class PathSum_112 
{
	
	//It is an easy question but need to revisit!
	//You need to consider the status if only one child is not null ( this other is null)
	//So the base case is not only root==null, but root.left==null && root.right==null
   
	//Solution 1: My solution
	public boolean hasPathSum_1(TreeNode root, int sum) {

        if(root==null) return false;
        return hasPathSum(root,sum, 0);
        
    }
    
    public boolean hasPathSum(TreeNode root, int sum, int curSum)
    {
        if(root==null) return false;
        
        if(root.left==null && root.right==null && (curSum+root.val)==sum) return true;

        if(root.left==null && root.right==null) return false;
        
        return hasPathSum(root.left,sum,curSum+root.val) || hasPathSum(root.right,sum,curSum+root.val);
        
        //if(root.left!=null) return hasPathSum(root.left,sum,curSum+root.val);
        //if(root.right!=null) return hasPathSum(root.right,sum,curSum+root.val);
        
        //return false;
    }
	
    //Solution 2: LC_topRatedSolution
    public boolean hasPathSum_2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum_2(root.left, sum - root.val) || hasPathSum_2(root.right, sum - root.val);
    }
    

}
