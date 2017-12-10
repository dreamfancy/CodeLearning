package leetcode201to250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance_2_244 
{
	
    Map<String,List<Integer>> map; 
    
    public ShortestWordDistance_2_244(String[] words) 
    {
        map = new HashMap<String,List<Integer>>();
        
     
        for(int i=0; i<words.length; i++)
        {
            String word = words[i];
            if(map.containsKey(word))
            {
                List<Integer> pos = map.get(word);
                pos.add(i);
                map.put(word,pos);
            }
            else 
            {
                List<Integer> pos = new ArrayList<Integer>();
                pos.add(i);
                map.put(word,pos);
            }
        }
    }
    
    
    
    public int  shortest_2(String word1, String word2)
    {
    	List<Integer> list1 = map.get(word1);
    	List<Integer> list2 = map.get(word2);
    	int ret = Integer.MAX_VALUE;
    	for(int i=0,j=0; i<list1.size() && j<list2.size();)
    	{
    		int index1 = list1.get(i);
    		int index2 = list2.get(j);
    		if(index1<index2)
    		{
    			ret = Math.min(ret, index2-index1);
    			i++;
    		}
    		else
    		{
    			ret = Math.min(ret, index1-index2);
    			j++;
    		}
    	}
    	return ret;
    	
    }
    
    public int shortest_1(String word1, String word2) 
    {
        List<Integer> pos1 = map.get(word1);
        List<Integer>pos2 = map.get(word2);
        int curmin = Integer.MAX_VALUE;
        int len1 = pos1.size();
        int len2 = pos2.size();
        
        int i=0,j=0;
        
        while(i<len1 && j<len2)
        {
            int cur1 = pos1.get(i);
            int cur2 = pos2.get(j);
            curmin = Math.min(Math.abs(cur1-cur2),curmin);
            if(cur1>cur2) j++;
            else i++;
        }
        while(i<len1)
        {
            int cur1 = pos1.get(i);
            int cur2 = pos2.get(len2-1);
            curmin = Math.min(Math.abs(cur1-cur2),curmin);
            i++;
        }
        while(j<len2)
        {
            int cur1 = pos1.get(len1-1);
            int cur2 = pos2.get(j);
            curmin = Math.min(Math.abs(cur1-cur2),curmin);
            j++;
        }
        return curmin;
    }
}
