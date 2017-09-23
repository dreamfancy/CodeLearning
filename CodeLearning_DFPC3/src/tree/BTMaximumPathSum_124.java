package tree;

public class BTMaximumPathSum_124 
{
	//Lecture: divide a big question to small questions
	// Step 1: From any leaf to root
	public int maxSum_leafToRoot_s1(TreeNode root)
	{
		if(root==null) return 0;
		int left = maxSum_leafToRoot_s1(root.left);
		int right = maxSum_leafToRoot_s1(root.right);
		return Math.max(0, Math.max(left, right))+root.val; //Change Math.max to jianzhi negative values
	}
	
	//Step 2: Any leaf to any leaf
	public int maxSum_leafToRoot_s2(TreeNode root)
	{
		if(root==null) return 0;
		int left = maxSum_leafToRoot_s2(root.left);
		int right = maxSum_leafToRoot_s2(root.right);
		return Math.max(0, Math.max(left, right))+root.val; //Change Math.max to jianzhi negative values
	}
	
	//Solution 2: LC_topBar
    public int maxPathSum_LCTopBar(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        returnLongestHeight(root,max);
        return max[0]; 
    }
    private int returnLongestHeight(TreeNode node,int[] max){
        if(node == null)
            return 0;
        int left = returnLongestHeight(node.left,max);
        int right = returnLongestHeight(node.right,max);
        int localMax = Math.max(left,right);
        max[0] = Math.max(max[0],Math.max(node.val,Math.max(localMax,left+right)+node.val));//Combined all the scenarios in my anser
        //Please revisit solution 1 : my solution. That is better and readable 
        return Math.max(localMax,0)+ node.val;
    }
	
	
	//Solution 1: My solution good!
    public int maxPathSum(TreeNode root) 
    {
    	//int[] rec = new int[3]; // rec[0]: return value  rec[1]: leftMax rec[2]: rightMax    	
    	int[] max = new int[1];
    	max[0] = Integer.MIN_VALUE;
    	//rec[0] = rec[1] + rec[2];
        
    	maxPathSum(root, max);

    	return max[0];
    }
    public int maxPathSum(TreeNode root, int[] max)
    {
    	if(root==null)
    	{
    		return 0;
    	}
    	
    	int leftVal = maxPathSum(root.left,max);
    	int rightVal = maxPathSum(root.right,max);
    	int upVal;
    	if(leftVal<=0 && rightVal<=0)
    	{
        	max[0] = Math.max(root.val, max[0]);
        	upVal = root.val;
    	}
    	else if(leftVal<=0)
    	{
        	max[0] = Math.max(root.val + rightVal, max[0]);	
        	upVal = root.val + rightVal;
    	}
    	else if(rightVal<=0)
    	{
    		max[0] = Math.max(root.val + leftVal, max[0]);
        	upVal = root.val + leftVal;

    	}
    	else
    	{
    		max[0] = Math.max(root.val+leftVal+rightVal, max[0]);
    		upVal = Math.max(leftVal, rightVal) + root.val;
    	}
    
    	return upVal;
    }
    

    //This is the method assuming all the values are positive
    public int maxPathSum_AllPositive(TreeNode root, int[] max)
    {
    	if(root==null)
    	{
    		return 0;
    	}
    	
    	int leftVal = maxPathSum(root.left,max);
    	int rightVal = maxPathSum(root.right,max);
    	max[0] = Math.max(leftVal+rightVal+root.val, max[0]);
    	return (Math.max(leftVal, rightVal) + root.val);
    }
    
    
    
    
}
