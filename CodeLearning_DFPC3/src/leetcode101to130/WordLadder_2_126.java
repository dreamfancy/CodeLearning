package leetcode101to130;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder_2_126 
{
	//Sol 3: BFS + DFS
    public List<List<String>> findLadders(String start, String end, List<String> wordList) 
    {
        List<List<String>> result = new ArrayList<List<String>>();
        if(wordList==null || start==null || end==null || wordList.size()==0 || !wordList.contains(end)) return result;
        wordList.add(start);
        Map<String,List<String>> neighborMap = new HashMap<String,List<String>>();
        Map<String, Integer> distance = new HashMap<String,Integer>();
        
        bfs(start, end, wordList, neighborMap, distance);
        
        List<String> cursol = new ArrayList<String>();
        dfs(start, end, neighborMap, distance, cursol, result);
        
        return result;
    }
    
    public List<String> getNeighbors(String cur, List<String> wordList)
    {
        List<String> returnlist = new ArrayList<String>();
        char[] curchar = cur.toCharArray();
        
        for(int i=0; i<curchar.length; i++)
        {
            for(char c='a'; c<='z'; c++)
            {
                char old_char = curchar[i];
                if(c==old_char) continue;
                curchar[i] = c;
                String changedstring = new String(curchar);
                if(wordList.contains(changedstring))
                {   
                    returnlist.add(changedstring);
                }
                curchar[i] = old_char;
            }
        }
        return returnlist;
        
    }
    
    
    public void bfs(String start, String end, List<String> wordList, Map<String,List<String>> neighborMap,Map<String, Integer> distance)
    {
        
        for (String str : wordList)
            neighborMap.put(str, new ArrayList<String>());
        
        Queue<String> queue = new LinkedList<String>();
        int curlevel = 1;
        distance.put(start,0);
        boolean found = false;
        while(!queue.isEmpty() && found==false)
        {
            int count = queue.size();
            for(int i=0; i<count; i++)
            {
                String cur = queue.poll();
                int curdistance = distance.get(cur);
                List<String> curneighbors = getNeighbors(cur, wordList);
                for(String neighbor: curneighbors)
                {
                    neighborMap.get(cur).add(neighbor);
                    if(!distance.containsKey(neighbor))
                    {
                        distance.put(neighbor, curdistance+1);
                        if(neighbor.equals(end))
                        {
                            found = true;
                        }
                        else
                        {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
    }
                   
    public void dfs(String cur, String end, Map<String,List<String>> neighborMap,Map<String, Integer> distance, List<String> cursol, List<List<String>> result)
    {
        cursol.add(cur);
        if(end.equals(cur)) result.add(new ArrayList<String>(cursol));
        else
        {
            List<String> neighbors = neighborMap.get(cur);
            for(String next: neighbors)
            {
                if(distance.get(next)==(distance.get(cur)+1))
                    dfs(next,end,neighborMap,distance,cursol,result);
            }
            
        }
        cursol.remove(cursol.size()-1);                   
    }
       
	
	// Sol 2: Official Solution 1
	public List<List<String>> findLadders_2(String start, String end, List<String> wordList) {
		   HashSet<String> dict = new HashSet<String>(wordList);
		   List<List<String>> res = new ArrayList<List<String>>();         
		   HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
		   HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
		   ArrayList<String> solution = new ArrayList<String>();

		   dict.add(start);          
		   bfs(start, end, dict, nodeNeighbors, distance);                 
		   dfs(start, end, dict, nodeNeighbors, distance, solution, res);   
		   return res;
		}

		// BFS: Trace every node's distance from the start node (level by level).
		private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
		  for (String str : dict)
		      nodeNeighbors.put(str, new ArrayList<String>());

		  Queue<String> queue = new LinkedList<String>();
		  queue.offer(start);
		  distance.put(start, 0);

		  while (!queue.isEmpty()) {
		      int count = queue.size();
		      boolean foundEnd = false;
		      for (int i = 0; i < count; i++) {
		          String cur = queue.poll();
		          int curDistance = distance.get(cur);                
		          ArrayList<String> neighbors = getNeighbors(cur, dict);

		          for (String neighbor : neighbors) {
		              nodeNeighbors.get(cur).add(neighbor);
		              if (!distance.containsKey(neighbor)) {// Check if visited
		                  distance.put(neighbor, curDistance + 1);
		                  if (end.equals(neighbor))// Found the shortest path
		                      foundEnd = true;
		                  else
		                      queue.offer(neighbor);
		                  }
		              }
		          }

		          if (foundEnd)
		              break;
		      }
		  }

		// Find all next level nodes.    
		private ArrayList<String> getNeighbors(String node, Set<String> dict) {
		  ArrayList<String> res = new ArrayList<String>();
		  char chs[] = node.toCharArray();

		  for (char ch ='a'; ch <= 'z'; ch++) {
		      for (int i = 0; i < chs.length; i++) {
		          if (chs[i] == ch) continue;
		          char old_ch = chs[i];
		          chs[i] = ch;
		          if (dict.contains(String.valueOf(chs))) {
		              res.add(String.valueOf(chs));
		          }
		          chs[i] = old_ch;
		      }

		  }
		  return res;
		}

		// DFS: output all paths with the shortest distance.
		private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
		    solution.add(cur);
		    if (end.equals(cur)) {
		       res.add(new ArrayList<String>(solution));
		    } else {
		       for (String next : nodeNeighbors.get(cur)) {            
		            if (distance.get(next) == distance.get(cur) + 1) {
		                 dfs(next, end, dict, nodeNeighbors, distance, solution, res);
		            }
		        }
		    }           
		   solution.remove(solution.size() - 1);
		}
	
	
	
	//My Solution : Used continously duplicated list as cursol. Remember to duplicate as
	//for one node there can be two derived nodes.
	//Still has some defects
    public List<List<String>> findLadders_1(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        if(wordList==null || wordList.size()==0 || beginWord==null || endWord==null || beginWord.length()!=endWord.length() || !wordList.contains(endWord)) return result;
        HashSet<String> visited = new HashSet<String>();
        //Queue<String> curreached = new LinkedList<String>();
        //curreached.offer(beginWord);
        //int count = 1;
        //Map<Integer,String> hash = new HashMap<Integer,String>();
        List<List<String>> curreached = new ArrayList<List<String>>();
        List<String> firstreached = new ArrayList<String>();
        firstreached.add(beginWord);
        curreached.add(firstreached);
        if(wordList.contains(beginWord)) visited.add(beginWord);
        int count = 1;
        boolean flag = false;
        while(curreached.size()!=0 && flag == false)
        {
            int size = curreached.size();
            for(int i=0; i<size; i++)
            {
                List<String> curlist = curreached.get(i);
                String cur = curlist.get(curlist.size()-1);
                for(String wordinlist: wordList)
                {
                    if(!visited.contains(wordinlist) && checkdiff(cur,wordinlist)==1)
                    {
                        if(wordinlist.equals(endWord))
                        {
                            flag = true;
                            List<String> newlist = new ArrayList<String>(curlist);
                            newlist.add(wordinlist);
                            result.add(newlist);
                            //visited.add(wordinlist);
                        }
                        else
                        {
                            visited.add(wordinlist); //Wrong //Cause the missing part between 1 2 3 4 and 1 5 3 4
                            List<String> newlist = new ArrayList<String>(curlist);
                            newlist.add(wordinlist);
                            curreached.add(newlist);
                        }
                    }
                }
            }
            
            for(int i=0; i<size; i++)
            {
                curreached.remove(0);
            }

        }
        return result;
    }
    
    private int checkdiff(String s1, String s2)
    {
        //if(s1.length()!=s2.length()) return -1;
        int count = 0;
        for(int i=0; i<s1.length(); i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                count++;
            }
        }
        return count;
    }

}
