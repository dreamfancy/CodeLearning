package leetcode201to250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule_207 
{
	//Sol 3: BFS
    public boolean canFinish_3(int numCourses, int[][] prerequisites) 
    {
    	if(prerequisites==null || prerequisites.length==0 || prerequisites[0].length==0 || numCourses<=1) return true;
    	int prerequisiteslen = prerequisites.length;
    	int[] dependnum = new int[numCourses];
    	for(int i=0; i<prerequisiteslen; i++)
    	{
    		dependnum[prerequisites[i][0]]++;
    	}
    	
    	int cleared = 0;
    	Queue<Integer> queue = new LinkedList<Integer>();
    	
    	for(int i=0; i<numCourses; i++)
    	{
    		if(dependnum[i]==0)
    		{
    			queue.offer(i);
    			cleared++;
    		}
    	}
    	
    	while(!queue.isEmpty())
    	{
    		int cur = queue.poll();
    		for(int i=0; i<prerequisiteslen; i++)
    		{
    			if(prerequisites[i][1]==cur)
    			{
    				dependnum[prerequisites[i][0]]--;
                    System.out.println(prerequisites[i][0]);
    				if(dependnum[prerequisites[i][0]]==0)
    				{
    					cleared++;
    					queue.offer(prerequisites[i][0]);
    				}
    			}
    		}
    	}
    	return cleared==numCourses;	
    }
	
	
	
	//Sol 2: Optimize for sol 1
    public boolean canFinish_2(int numCourses, int[][] prerequisites) 
    {
        if(prerequisites==null || prerequisites.length==0 || prerequisites[0].length==0 || numCourses<=1) return true;
        
        Map<Integer,List<Integer>> dependmap = new HashMap<Integer,List<Integer>>();

        int[] visited = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++)
        {   
            if(dependmap.containsKey(prerequisites[i][0]))
            {
                List<Integer> curlist = dependmap.get(prerequisites[i][0]);
                curlist.add(prerequisites[i][1]);
            }
            else
            {
                List<Integer> curlist = new ArrayList<Integer>();
                curlist.add(prerequisites[i][1]);
                dependmap.put(prerequisites[i][0],curlist);
            } 
        }
        
        for(int i=0; i<numCourses; i++)
        {
            if(!dfs(dependmap,i,visited))
            {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer,List<Integer>> dependmap, int cur, int[] visited)
    {
        if(visited[cur]==-1) return false;
        if(visited[cur]==1) return true;  //Why!!!If there is a ring, from any point it can be detected. So if previous point does not find a ring, this point will not find as well
        visited[cur]=-1;
        if(dependmap.containsKey(cur))
        {
            for(int next: dependmap.get(cur))
            {
                if(dfs(dependmap,next,visited)==false) return false;
            }
        }
        visited[cur] = 1;
        return true; 
    }
	
	
	//Sol 1: Make Sense but Time Exceed Limit
	//HashMap and Visited working together to check if some elements
	//occur again while it has already been visited.
    public boolean canFinish_1(int numCourses, int[][] prerequisites) 
    {
        if(prerequisites==null || prerequisites.length==0 || prerequisites[0].length==0 || numCourses<=1) return true;
        
        Map<Integer,List<Integer>> dependmap = new HashMap<Integer,List<Integer>>();
        Set<Integer> visited = new HashSet<Integer>();
        for(int i=0; i<prerequisites.length; i++)
        {   
            if(dependmap.containsKey(prerequisites[i][0]))
            {
                List<Integer> curlist = dependmap.get(prerequisites[i][0]);
                curlist.add(prerequisites[i][1]);
                //dependmap.put(prerequisites[i][0],curlist);
            }
            else
            {
                List<Integer> curlist = new ArrayList<Integer>();
                curlist.add(prerequisites[i][1]);
                dependmap.put(prerequisites[i][0],curlist);
            } 
        }
        
        for(int i=0; i<numCourses; i++)
        {
            if(!dfs(dependmap,i,visited))
            {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer,List<Integer>> dependmap, int cur, Set<Integer> visited)
    {
        if(visited.contains(cur)) return false;
        visited.add(cur);
        if(dependmap.containsKey(cur))
        {
            for(int next: dependmap.get(cur))
            {
                if(dfs(dependmap,next,visited)==false) return false;
            }
        }
        visited.remove(cur);
        return true; 
    }

}
