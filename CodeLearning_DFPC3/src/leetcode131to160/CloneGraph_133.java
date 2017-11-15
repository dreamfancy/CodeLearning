package leetcode131to160;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph_133 {
	
	/*
	 class UndirectedGraphNode 
	 {
		int label;
		List<UndirectedGraphNode> neighbors;
	 	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
      };
	*/
	
	//Sol 2: To copy, use queue to traverse the original structure and use 
	
	public UndirectedGraphNode cloneGraph_QAndHashMap(UndirectedGraphNode node) 
	{
		if(node==null) return null;
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		
		UndirectedGraphNode newhead = new UndirectedGraphNode(node.label);
		
		queue.add(node);
		map.put(node, newhead);
		
		while(!queue.isEmpty())
		{
			UndirectedGraphNode oricur = queue.poll();
			List<UndirectedGraphNode> neighbors = oricur.neighbors;
			
			for(UndirectedGraphNode neighbor: neighbors)
			{
				if(!map.containsKey(neighbor))
				{
					UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor, copy);
					map.get(oricur).neighbors.add(copy);
					queue.add(neighbor);
				}
				else
				{
					map.get(oricur).neighbors.add(map.get(neighbor));
				}
			}
		}
		return newhead;
		
	}

	
	
	//My Solution 1: Use two queue, one for original, one for new copied, to do bfs
    //But two queue cannot resolve the situation when one node has two links to the same neighbor
	
	public UndirectedGraphNode cloneGraph_TwoQueue(UndirectedGraphNode node) 
    {
    	if(node==null) return null;
    	UndirectedGraphNode clonedhead = new UndirectedGraphNode(node.label);
    	Queue<UndirectedGraphNode> originalnodequeue = new LinkedList<UndirectedGraphNode>();
    	Queue<UndirectedGraphNode> copiednodequeue = new LinkedList<UndirectedGraphNode>();
    	originalnodequeue.offer(node);
    	copiednodequeue.offer(clonedhead);

    	while(!originalnodequeue.isEmpty())
    	{
    		UndirectedGraphNode oricur = originalnodequeue.poll();
    		UndirectedGraphNode copiedcur = copiednodequeue.poll();
    		
    		Set<UndirectedGraphNode> neigborset = new HashSet<UndirectedGraphNode>();
    		for(UndirectedGraphNode neigbor : oricur.neighbors)
    		{
    			if(neigbor!=oricur)
    			{
    				originalnodequeue.offer(neigbor);
    				UndirectedGraphNode newneigbor = new UndirectedGraphNode(neigbor.label);
    				copiedcur.neighbors.add(newneigbor);
    				copiednodequeue.offer(newneigbor);
    			}
    			else
    			{
    				copiedcur.neighbors.add(copiedcur);
    			}
    		}
    	    
    	}
    	
    	return clonedhead;
    }

}
