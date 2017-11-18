package leetcode131to160;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak_2_140 
{
	//Sol 3: DFS Final Solution : Where it is saved comparing to my solution1 
	public List<String> wordBreak_3(String s, Set<String> wordDict) {
	    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}       

	// DFS function returns an array including all substrings derived from s.
	List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}
	
	
	//Sol 2: DP based on result. When n is going greater, the later 
	//result is decided by previous result
    public List<String> wordBreak_DP(String s, List<String> wordDict) 
    {
    	List<String> result = new ArrayList<String>();
        if(s==null || s.length()==0 || wordDict==null || wordDict.size()==0) return result;
            
        Map<Integer,List<StringBuilder>> hash = new HashMap<Integer,List<StringBuilder>>();
        
        for(int i=0; i<s.length(); i++)
        {
            for(int j=0; j<=i; j++)
            {
                if(wordDict.contains(s.substring(j,i+1)))
                {
                    if(!hash.containsKey(j-1) && j!=0) continue;
                    String cur = s.substring(j,i+1);
                    
                    if(j==0)
                    {
                        List<StringBuilder> newlist = new ArrayList<StringBuilder>();
                        newlist.add(new StringBuilder(cur));
                        hash.put(i,newlist);

                    }
                    else if(hash.containsKey(j-1))
                    {                        
                        List<StringBuilder> copy = new ArrayList<StringBuilder>();
                        List<StringBuilder> existing = hash.get(j-1);
                        for(StringBuilder exsb: existing)
                        {
                            StringBuilder newcreated = new StringBuilder(exsb);
                            copy.add(newcreated);
                        }
                            
                        for(StringBuilder sb: copy)
                        {
                            sb.append(" ").append(cur);    
                        }
                        
                        if(!hash.containsKey(i))
                        {
                            hash.put(i,copy);
                        }
                        else
                        {
                            List<StringBuilder> pre = hash.get(i);
                            pre.addAll(copy);
                            hash.put(i,pre);
                        }
                    }

                }
            }
        }

        if(hash.containsKey(s.length()-1))
        {
            List<StringBuilder> beforeprocess = hash.get(s.length()-1);
        
            for(StringBuilder sb: beforeprocess)
            {
                result.add(sb.toString());
            }
        }    
        return result;
    }
	
	
	
	//Sol 1: DFS //Time exceed limit
    public List<String> wordBreak_DFS(String s, List<String> wordDict) 
    {
    	List<String> result = new ArrayList<String>();
        if(s==null || s.length()==0 || wordDict==null || wordDict.size()==0) return result;
        
        Collections.sort(wordDict, new Comparator<String>()
                         {
                             @Override
                             public int compare(String s1, String s2)
                             {
                                 return s1.length()-s2.length();
                             }
                             
                         });
        List<String> cursol = new ArrayList<String>();
        findMatching(s,wordDict,cursol, result);  
        return result; 
    }
    public void findMatching(String s, List<String> wordDict, List<String> cursol, List<String> result)
    {     
        boolean res = false;
   
        for(String wd: wordDict)
        {
            int pos = s.indexOf(wd);
            if(pos==0 && wd.length()==s.length())
            {	cursol.add(wd);
            	processResult(cursol,result);
            	cursol.remove(cursol.size()-1);
            }
            else if(pos==0)
            {
            	cursol.add(wd);
            	findMatching(s.substring(wd.length()), wordDict, cursol, result);            	
            	cursol.remove(cursol.size()-1);
            }
        }
    }
    
    public void processResult(List<String> cursol,List<String> result)
    {
    	StringBuilder sb = new StringBuilder(cursol.get(0));
    	for(int i=1; i<cursol.size(); i++)
    	{
    		sb.append(" ").append(cursol.get(i));
    	}
    	result.add(sb.toString());
    }
}
