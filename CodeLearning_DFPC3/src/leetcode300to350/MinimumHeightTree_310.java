package leetcode300to350;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTree_310 
{    public List<Integer> findMinHeightTrees(int n, int[][] edges) 
{
    List<Integer> result = new ArrayList<Integer>();
    if(n==1)
    {
        result.add(0);
        return result;
    }
    List<Set<Integer>> adj = new ArrayList<Set<Integer>>();
    for(int i=0; i<n; i++)
    {
        adj.add(new HashSet<Integer>());
    }
    
    for(int[] edge: edges)
    {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }
    
    for(int i=0; i<n; i++)
    {
        if(adj.get(i).size()==1)
            result.add(i);
    }
    while(n>2)
    {
        n -= result.size();
        List<Integer> leaves = new ArrayList<>();
        for(int i: result)
        {
            for(int j: adj.get(i))
            {
                adj.get(j).remove(i);
                if(adj.get(j).size()==1)
                {
                    leaves.add(j);
                }
            }
        }
        result = leaves;
    }
    return result;
}

}
