package leetcode131to160;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordBreak_2_140 {

	
	
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
