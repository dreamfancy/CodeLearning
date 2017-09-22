package tree;

public class LCA_236 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
    	if(root==null || root==p || root==q) return root;
    	
    	TreeNode left = lowestCommonAncestor(root.left,p,q);
    	TreeNode right = lowestCommonAncestor(root.right,p,q);
    	
    	if(left!=null && right!=null) return root;
    	if(left!=null) return left;
    	if(right!=null) return right;
    	
    	return null;
    }
    
    //Extension 1: If the tree is BST
    //1.1 If it is a BST -> if root.val< p && root.val < q not check left child
    //                  if root.val> p && root.val > q not check right child
    //1.2 If it is a BST -> The first child between two values must be the LCA
    //                  if not -> does not satisfy BST
    //Summary: From the root start checking, if root<p && root<q root=root.right; If root>p && root>q root=root.left ; If root is between, return root
    
    //Extension 2:
    //If there is link from child to parent
    // p1: l1 -> l3 -> l2                                            l3   O
    // P2: l2 -> l3 -> l1                                                 O    l2
    // Walk cross to the other end                                   l1 O   O      
    //Or Find length difference of two paths first, then BingPaiZou    O
     
    //Extension 3: LowestCommonAncester of M nodes Exactly same as the original question. 
    //Just change base case: if null || any nodes, return node
    //return cur if left!=null && right !=null ; return leftValue if right==null ; return rightValue if left==null
    
    //Extension 4: K cha tree two nodes
    //Same as original question except: return cur if two children are not null; return the child if one child is not null
    //return null if all children are null
    
    //Extension 5: K cha tree M nodes :
    //return cur if more than two (including) children are not null; return the child if one child is not null
    //return null if all children are null
    //Change base case: if root== any node || null  return root
    
    
   
    
    
}
 