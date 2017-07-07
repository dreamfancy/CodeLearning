package stackqueueheap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

//Time: O(klogk)
//Space O(k)




public class KthSmallestElement_378 
{
	
	class Node
	{
		int i,j,val;
		public Node(int _i, int _j, int _val)
		{
			i = _i;
			j = _j;
			val = _val;
		}
		
		public boolean equals(Object n)
		{
			return (i==((Node)n).i && j==((Node)n).j);
		}
	}
	
    public int kthSmallest(int[][] matrix, int k) 
    {
    	if(k<=0 || k>matrix.length * matrix[0].length) return -1;
    	
    	PriorityQueue<Node> pq = new PriorityQueue<Node>(k,new Comparator<Node>(){
    		@Override
    		public int compare(Node n1, Node n2)
    		{
    			return n1.val-n2.val;
    		}
    	});
    	
    	HashSet<Integer> visited = new HashSet<Integer>();
    	
    	int i=0,j=0;
    	pq.offer(new Node(i,j,matrix[i][j]));
    	visited.add(0);
    	int count = 0;
        Node cur = null;
    	while(!pq.isEmpty() && count<k )
    	{
    		cur = pq.poll();
            count++;
            
            System.out.println("current count is " + count);
            
    		if(cur.i<matrix.length-1)
    		{
    			Node add1 = new Node(cur.i+1,cur.j,matrix[cur.i+1][cur.j]);
    			int hash1 = (cur.i+1) * (matrix[0].length) + cur.j;
                boolean signal1 = visited.contains(hash1);
                System.out.println(signal1); 
    			if(!visited.contains(hash1))
    			{
    				pq.offer(add1);
        			visited.add(hash1);
    				System.out.println("i "+(cur.i+1) + "  j: "+cur.j + "  "+ matrix[cur.i+1][cur.j]);
    			}
    		}
    		if(cur.j<matrix[0].length-1)
    		{
				Node add2 = new Node(cur.i,cur.j+1,matrix[cur.i][cur.j+1]);
    			int hash2 = cur.i * (matrix[0].length) + cur.j + 1;
                boolean signal2 = visited.contains(hash2);
                System.out.println(signal2); 
    			if(!visited.contains(hash2))
    			{
    				pq.offer(add2);
        			visited.add(hash2);
    				System.out.println("i    "+cur.i + "  j: "+(cur.j+1) + "  "+ matrix[cur.i][cur.j+1]);
    			}
    		}
           
    	}
    	
        System.out.println("final count is" + count);
    	return cur.val;
    	
    }
}
