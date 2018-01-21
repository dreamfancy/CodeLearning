package leetcode251to300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary_269 {

	   public String alienOrder(String[] words) 
	    {
	        if(words==null || words.length==0) return "";
	        
	        Map<Character,Set<Character>> dependMap = new HashMap<Character,Set<Character>>();
	        int[] degree = new int[26];
	        int count = 0;
	        
	        for(String word: words)
	        {
	            for(int i=0; i<word.length(); i++)
	            {
	                char c = word.charAt(i);
	                if(degree[c-'a']==0)
	                {
	                    degree[c-'a'] = 1;
	                    count++;
	                }
	            }
	        }
	        
	        //System.out.println(count);
	        
	        for(int i=0; i<words.length-1; i++)
	        {
	            char[] cur = words[i].toCharArray();
	            char[] next = words[i+1].toCharArray();
	            int len = Math.min(cur.length,next.length);
	            
	            for(int j=0; j<len; j++)
	            {
	                if(cur[j]!=next[j])
	                {
	                    if(!dependMap.containsKey(cur[j]))
	                    {
	                        dependMap.put(cur[j],new HashSet<Character>());
	                    }

	                    if(dependMap.get(cur[j]).add(next[j]))
	                        degree[next[j]-'a']++;
	                    break;
	                }
	            }
	        }
	        Queue<Character> queue = new LinkedList<Character>();
	        
	        for(int i=0; i<26; i++)
	        {
	            if(degree[i]==1)
	            {
	                queue.offer((char)(i+'a'));
	            }
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        while(!queue.isEmpty())
	        {
	            char curchar = queue.poll();
	            sb.append(curchar);
	            
	            if(dependMap.containsKey(curchar))
	            {
	                Set<Character> nextchars = dependMap.get(curchar);

	                for(char c: nextchars)
	                {
	                    degree[c-'a']--;
	                    if(degree[c-'a']==1)
	                    {
	                        queue.offer(c);
	                    }
	                }
	            }
	        }
	        
	        //System.out.println(sb.length());
	        if(count!=sb.length()) return "";
	        return sb.toString();
	           
	    }
}
