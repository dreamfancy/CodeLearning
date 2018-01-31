package leetcode300to350;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import tree.TreeNode;

public class BTVerticalOrderTraversal_314 
{
	
	//Sol 2: Queue with two level information DFS
	public List<List<Integer>> verticalOrder_2(TreeNode root) {
	    List<List<Integer>> res = new ArrayList<>();
	    if (root == null) {
	        return res;
	    }
	    
	    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	    Queue<TreeNode> q = new LinkedList<>();
	    Queue<Integer> cols = new LinkedList<>();

	    q.add(root); 
	    cols.add(0);

	    int min = 0;
	    int max = 0;
	    
	    while (!q.isEmpty()) {
	        TreeNode node = q.poll();
	        int col = cols.poll();
	        
	        if (!map.containsKey(col)) {
	            map.put(col, new ArrayList<Integer>());
	        }
	        map.get(col).add(node.val);

	        if (node.left != null) {
	            q.add(node.left); 
	            cols.add(col - 1);
	            min = Math.min(min, col - 1);
	        }
	        
	        if (node.right != null) {
	            q.add(node.right);
	            cols.add(col + 1);
	            max = Math.max(max, col + 1);
	        }
	    }

	    for (int i = min; i <= max; i++) {
	        res.add(map.get(i));
	    }

	    return res;
	}
	
	
	
	
	
	
	
	//My Sol : Solution 1  DFS
    class WeightNode
    {
        TreeNode node;
        int weight;
        
        public WeightNode(TreeNode tn, int we)
        {
            node = tn;
            weight = we;
        }
    }
    
    public List<List<Integer>> verticalOrder_1(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Map<Integer,List<WeightNode>> treemap = new TreeMap<Integer,List<WeightNode>>();
        
        helper(root,0,0,treemap);
        Iterator<Integer> iter = treemap.keySet().iterator();
        while(iter.hasNext())
        {
            List<WeightNode> weightlist = treemap.get(iter.next());  //Easy to typo here! it is iter.next() instead of writing only a iter here
            Collections.sort(weightlist,new Comparator<WeightNode>()
                             {
                                 @Override
                                 public int compare(WeightNode w1, WeightNode w2)
                                 {
                                     return w1.weight-w2.weight;
                                 }
                             });
            List<Integer> curlist = new ArrayList<Integer>();
            for(int i=0; i<weightlist.size(); i++)
            {
                curlist.add(weightlist.get(i).node.val);
            }
            result.add(curlist);
        }
        return result;
    }
    
    private void helper(TreeNode root, int hor, int vert, Map<Integer,List<WeightNode>> hash)
    {
        if(root==null) return;
        if(!hash.containsKey(hor))
        {
            hash.put(hor,new ArrayList<WeightNode>());
        }
        List<WeightNode> curlist = hash.get(hor); 
        WeightNode weightroot = new WeightNode(root, vert);
        curlist.add(weightroot);
        
        helper(root.left,hor-1,vert+1,hash);
        helper(root.right,hor+1,vert+1,hash);
    }

}
