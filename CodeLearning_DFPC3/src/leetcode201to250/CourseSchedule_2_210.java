package leetcode201to250;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule_2_210 
{
	//Sol 2: Topologicalsort!!!
    public int[] findOrder_2(int numCourses, int[][] prerequisites) 
    {
        int[] result = new int[numCourses];
        List<List<Integer>> dependlist = new ArrayList<List<Integer>>();
        for(int i=0; i<numCourses; i++)
        {
            dependlist.add(new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++)
        {
            dependlist.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
       
        Set<Integer> visited = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<numCourses; i++)
        {
            if(!dfs(dependlist,i,new boolean[numCourses], visited, stack)) return new int[0];
        }
        
        int count = 0;
        while(!stack.isEmpty())
        {
            result[count++] = stack.pop();
        }
        return result;
    }
    
    public boolean dfs(List<List<Integer>> dependlist, int cur,boolean[] visitedinloop,Set<Integer> visited, Stack<Integer> stack)
    {
        if(visited.contains(cur)) return true;
        if(visitedinloop[cur]== true) return false;
        
        visitedinloop[cur] = true;
        List<Integer> curlist = dependlist.get(cur);
        if(curlist==null)
        {
            stack.push(cur);
            return true;
        }
        for(int next: curlist)
        {
            //visitedinloop[next] = true; //next element: please process in the next dfs's function
            if(!dfs(dependlist,next,visitedinloop,visited,stack)) return false;
        }
        visited.add(cur);
        stack.push(cur);
        
        return true;
    }
	
	
	
	//Sol 1: To get the output sequence, BFS to make conservative steps
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        int[] result = new int[numCourses];
        int cur = 0;
        
        if(numCourses==0) return result;
        if(numCourses==1)
        {
            result[0] = 0;
            return result;
        }
        if(prerequisites==null || prerequisites.length==0)
        {
            for(int i=0; i<numCourses; i++)
            {
                result[i] = i;
            }
            return result;
        }
        
        int[] dependcount = new int[numCourses];
        int prerequisiteslen = prerequisites.length;
        for(int i=0; i<prerequisiteslen; i++)
        {
            dependcount[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i=0; i<numCourses; i++)
        {
            if(dependcount[i]==0)
            {
                result[cur++] = i;
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty())
        {
            int curpoll = queue.poll();
            for(int i=0; i<prerequisiteslen; i++)
            {
                if(prerequisites[i][1]==curpoll)
                {
                    dependcount[prerequisites[i][0]]--;
                    if(dependcount[prerequisites[i][0]]==0)
                    {
                        result[cur++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);  
                    }
                }
            }
        }
        if(cur==numCourses)  //There is a cur++ in the final result!!!
            return result;
        else return new int[0];
    }	

}
