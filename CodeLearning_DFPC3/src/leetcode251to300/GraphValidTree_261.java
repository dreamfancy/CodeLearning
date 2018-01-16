package leetcode251to300;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree_261 
{
	  //Sol 2: Union Find
    public boolean validTree(int n, int[][] edges) 
    {
        int[] parent = new int[n];
        for(int i=0; i<n; i++)
        {
            parent[i] = i;
        }
        
        int[] rank = new int[n];
        int count = n;
        for(int i=0; i<edges.length; i++)
        {
            int num1 = find(parent,edges[i][0]);
            int num2 = find(parent,edges[i][1]);
            if(num1==num2) return false;
            parent[num2] = num1;
            count--;
        }
        return edges.length==(n-1) && count==1;
    }
        
    //Union Find core function    
    private int find(int[] parent, int i)
    {
        if(parent[i]==i) return i;
        return find(parent,parent[i]);
    } 
	  //Sol 1: One loop DFS checks two features!!!
	  public boolean validTree_1(int n, int[][] edges) 
	    {
	    	 List<List<Integer>> adjlist = new ArrayList<List<Integer>>();
	         
	         //  no need map as the point values are from 0 to n-1 without gap
	         for(int i=0; i<n; i++)
	         {
	             List<Integer> newlist = new ArrayList<Integer>();
	             adjlist.add(newlist);
	         }
	                 
	         for(int i=0; i<edges.length; i++)
	         {
	             int num1 = edges[i][0];
	             int num2 = edges[i][1];
	             adjlist.get(num1).add(num2);
	             adjlist.get(num2).add(num1);
	         }
	         
	         boolean[] visited = new boolean[n];
	         
	         if(hasCycle(adjlist,0,visited,-1)) return false;
	         
	         for(boolean visiting: visited)
	         {
	        	 if(visiting==false) return false;
	         }
	         return true;
	    
	    }
	    
	    private boolean hasCycle(List<List<Integer>> adjlist, int cur, boolean[] visited, int pre)
	    {
	    	visited[cur] = true;
	    	List<Integer> neigbors = adjlist.get(cur);
	    	
	    	for(Integer neigbor : neigbors)
	    	{
	            if(neigbor==pre) continue;
	     		if(visited[neigbor]==true) return true;
	    		if(hasCycle(adjlist,neigbor,visited,cur)==true) return true;
	    	}
	    	return false;
	    }

	

}
