package leetcode251to300;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_2_291 
{
	// My Solution 1: Pretty good!
	
    Map<Character,String> relationMap = new HashMap<Character,String>();
    public boolean wordPatternMatch(String pattern, String str) 
    {
        if(pattern==null || pattern.length()==0) return str==null || str.length()==0;
        
        char curchar = pattern.charAt(0);
        
        if(relationMap.containsKey(curchar))
        {
            String curstr = relationMap.get(curchar);
            if(str.startsWith(curstr))
            {
                if(wordPatternMatch(pattern.substring(1),str.substring(curstr.length())))
                {
                    return true;
                }
            }
        }
        else
        {
            for(int i=1; i<=str.length(); i++)
            {
                String potentialstr = str.substring(0,i);
                if(relationMap.values().contains(potentialstr)) continue;
                
                relationMap.put(curchar,potentialstr);
                if(wordPatternMatch(pattern.substring(1),str.substring(i)))
                    return true;
                relationMap.remove(curchar);
            }
        }
        return false;
    }	

}
