package leetcode201to250;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 
{
	//Sol 2:
    public boolean isIsomorphic_256array(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] ms = new int[256];
        int[] mt = new int[256];
        for(int i = 0; i < s.length(); i++) {
            if(ms[s.charAt(i)] != mt[t.charAt(i)]) return false;
            ms[s.charAt(i)] = i+1;
            mt[t.charAt(i)] = i+1;
        }
        return true;
    }
	
	
	//Sol 1: Using HashMap
    public boolean isIsomorphic_UsingHashMap(String s, String t) 
    {
        if(s==null || s.length()<=1) return true;
        Map<Character,Character> map = new HashMap<Character,Character>();

        for(int i=0; i<s.length(); i++)
        {
            char scur = s.charAt(i);
            char tcur = t.charAt(i);
            if(map.containsKey(scur))
            {
                if(tcur!=map.get(scur)) return false;
            }
            else
            {
                if(map.containsValue(tcur)) return false;
                map.put(scur,tcur);
            }   
        }
        return true;
    }
}
