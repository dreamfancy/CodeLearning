package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class GraphNode
{
	int value;
	boolean visited;  //we can use if distance==-1 to check if visited or not
	int distance; 
	List<GraphNode> neis;
	
	GraphNode()
	{
		visited = false;
		distance = 0;
		neis = new ArrayList<GraphNode>();
	}
	
	
}

public class dijstra 
{
	public void dijstra(GraphNode start)
	{
		int size = 10;
		PriorityQueue<GraphNode> pq = new PriorityQueue<GraphNode>(10, new Comparator<GraphNode>(){
			
			@Override
			public int compare(GraphNode g1, GraphNode g2)
			{
				if(g1.value==g2.value) return 0;
				
				return g1.value<g2.value ? -1:1;
			}
			
		});
	
		HashSet<GraphNode> set = new HashSet<GraphNode>();
		
		pq.offer(start);
		
		while(!pq.isEmpty())
		{
			//expand poll()
			//find neis generate put into heap
		}
	}
	
	

}
