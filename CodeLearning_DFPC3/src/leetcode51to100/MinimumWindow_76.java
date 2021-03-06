package leetcode51to100;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindow_76 
{
	//My Solution: Set two HashMap and compare their relations
    public String minWindow(String s, String t) 
    {
        if(t==null || t.length()==0) return "";
    	if(s==null || s.length()==0) return "";
        
        String res = "";
        Map<Character,Integer> target = new HashMap<Character,Integer>();
        for(int i=0; i<t.length(); i++)
        {
            char tchar = t.charAt(i);
            if(target.containsKey(tchar))
            {
                target.put(tchar,target.get(tchar)+1);
            }
            else
            {
                target.put(tchar,1);
            }
        }
        
        Map<Character,Integer> source = new HashMap<Character,Integer>();
        int slow = 0;
        int fast = 0;
        int n = t.length();
        int minlen = s.length()+1;
        int count = 0;
        
        while(fast<s.length())
        {
            char cur = s.charAt(fast);
            if(!target.containsKey(cur))
            {
                fast++;
                continue;
            }
            else
            {
                if(source.containsKey(cur))
                {
                    source.put(cur,source.get(cur)+1);
                }
                else
                {
                    source.put(cur,1);
                }
                
                if(source.get(cur)<=target.get(cur))
                {
                    count++;
                }
                
                while(count==n && slow<=fast)
                {
                    int curlen = fast-slow+1;
                    if(curlen<minlen)
                    {
                        minlen = curlen;
                        res = s.substring(slow,fast+1);
                    }
                    char delchar = s.charAt(slow);
                    if(!target.containsKey(delchar))
                    {
                        slow++;
                        continue;
                    }
                    else if(source.get(delchar)>target.get(delchar))
                    {
                        source.put(delchar,source.get(delchar)-1);
                        slow++;
                    }
                    else
                    {
                        source.put(delchar,source.get(delchar)-1);
                        slow++;
                        count--;
                    }
                
                }
                fast++;
                
            }
        }
        return res;
    }


}
