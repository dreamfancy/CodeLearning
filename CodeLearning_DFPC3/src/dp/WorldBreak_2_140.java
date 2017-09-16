package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WorldBreak_2_140 
{
	//Solution 1: My Solution List of list of String
	//Cannot pass leetcode because time exceeding the limit
    public List<String> wordBreak(String s, List<String> wordDict) 
    {
       	List<List<String>> dp = new ArrayList<List<String>>();
        
    	Set<String> wordDictSet = new HashSet<String>();
    	
    	for(String word : wordDict)
    	{
    		wordDictSet.add(word);
    	}
    	
    	if(wordDictSet.contains(s.substring(0,1)))
    	{
    		dp.add(new ArrayList<String>());
    		dp.get(0).add((s.substring(0,1)));
    	}
    	else
    	{
    		dp.add(new ArrayList<String>());
    	}
    	
    	for(int i=1; i<s.length(); i++)
		{
    		dp.add(new ArrayList<String>());
    		for(int j=0; j<i; j++)
    		{
    			//if(dp[j]==false) continue;
    			if(dp.get(j).size()!=0 && wordDictSet.contains(s.substring(j+1,i+1)))
    			{
    				for(String p:  dp.get(j))
    				{
    					dp.get(i).add(new StringBuilder(p).append(" ").append(s.substring(j+1,i+1)).toString());
    				}
    			}		
    		}
            if(wordDictSet.contains(s.substring(0,i+1))) dp.get(i).add(s.substring(0,i+1).toString());
            //if(i==3) System.out.println(dp[3]);
		}
    	
    	for(int k=0; k<dp.size();k++)
    	{
    		for(int l=0; l<dp.get(k).size(); l++)
    		{
    			System.out.println(dp.get(k).get(l));
    		}
    	}
    	return dp.get(s.length()-1);	
    }
    
    //Solution 2:
    //From program geek
    
    //Please revisit!!!
    public static List<String> wordBreak(String s, Set<String> dict) {
        //create an array of ArrayList<String>
        List<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();
     
        for(int i=0; i<s.length(); i++){
            if( dp[i] == null ) 
                continue; 
     
            for(String word:dict){
                int len = word.length();
                int end = i+len;
                if(end > s.length()) 
                    continue;
     
                if(s.substring(i,end).equals(word)){
                    if(dp[end] == null){
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }
     
        List<String> result = new LinkedList<String>();
        if(dp[s.length()] == null) 
            return result; 
     
        ArrayList<String> temp = new ArrayList<String>();
        dfs(dp, s.length(), result, temp);
     
        return result;
    }
     
    public static void dfs(List<String> dp[],int end,List<String> result, ArrayList<String> tmp){
        if(end <= 0){
            String path = tmp.get(tmp.size()-1);
            for(int i=tmp.size()-2; i>=0; i--){
                path += " " + tmp.get(i) ;
            }
     
            result.add(path);
            return;
        }
     
        for(String str : dp[end]){
            tmp.add(str);
            dfs(dp, end-str.length(), result, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
    
    //Leetcode Official Answer:
    public List<String> wordBreak_LC(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }       

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
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
}
