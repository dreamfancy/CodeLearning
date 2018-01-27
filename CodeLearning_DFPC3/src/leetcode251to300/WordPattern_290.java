package leetcode251to300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordPattern_290 
{
	//Sol 2: Official Solution
    public boolean wordPattern_2(String pattern, String str) {
        Map<String, String> patternMatch = new HashMap<>();
        String[] list = str.split(" ");
        if (list.length != pattern.length()) return false;
        
        for (int i = 0; i < pattern.length(); i++) {
            String key = pattern.substring(i, i+1);
            if (patternMatch.containsKey(key)) {
                if (!patternMatch.get(key).equals(list[i])) {
                    return false;
                }
            } else {
                if (patternMatch.values().contains(list[i])) return false;
                patternMatch.put(key, list[i]);
            }
        }
        return true;
    }
	
	
	
	
	
	//Sol 1: My Sol: Compare HashMap
    public boolean wordPattern_1(String pattern, String str) 
    {
        if(pattern==null || pattern.length()==0) return str==null || str.length()==0;
        char[] patternArr = pattern.toCharArray();
        String[] stringArr = str.trim().split(" "); 
        if(patternArr.length!=stringArr.length) return false;
        Map<Character,List<Integer>> relationMap = new HashMap<>();
        
        for(int i=0; i< patternArr.length; i++)
        {
            if(!relationMap.containsKey(patternArr[i]))
            {
                List<Integer> rel = new ArrayList<Integer>();
                relationMap.put(patternArr[i],rel);
            }
            relationMap.get(patternArr[i]).add(i);
        }
        
        Set<Map.Entry<Character, List<Integer>>> entryset = relationMap.entrySet();
        Iterator<Map.Entry<Character,List<Integer>>> iter = entryset.iterator();
        while(iter.hasNext())
        {
            Map.Entry<Character,List<Integer>> pair = iter.next();
            
            String model = null;
            for(int i: pair.getValue())
            {
                if(model==null) 
                {
                    model = stringArr[i];
                    continue;
                }
                if(!model.equals(stringArr[i])) return false;
            }
        }
        return true;
    }

}
