 package tree;


//Binary Tree: For every node, at most two children, without cycle ->DAG
//1 Never lose your root
//2 When de-reference, check null
//3 Add null for every leaf node

//Binary Search Tree: For every node x in binary tree, all nodes' value in the left subtree (NOT left child) 
//should be less than root x's value; all nodes' value in the right subtree should be greater than x' value.

//Complete Binary Tree: For every level, except the last level, it should be filled completedly (full binary tree),
//last level should be filled as left as possible

//For heap, the storage structure is array while the logic structure is complete binary tree

//Balanced Binary Tree: For every node, the height difference between left subtree and right subtree should not be
//greater than one

//PreOrder: Read a root first!
 
 //Binary Search Tree: How to Verify: When you are traversing the tree by in order, it is always ascending

public class TreeNode {
	int val;
	TreeNode left;
    TreeNode right;
    //TreeNode mid;
    //TreeNode parent; //Ask the interviewer
    TreeNode(int x) { val = x; }
}