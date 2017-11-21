package leetcode131to160;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctChars_159 
{
	//sol 2: Because it is char, there are only 256 possibilities
	
    private static final int K = 2;

    public int lengthOfLongestSubstringTwoDistinct_2(String s) {
        int[] counts = new int[256];
        int total = 0;
        int ret = 0;
        
        int i = 0, j = 0;
        while (j < s.length()) {
            if (total <= K) {
                char c = s.charAt(j);
                counts[c]++;
                total += counts[c] == 1 ? 1 : 0;//REVISIT!!!
                if (total <= 2) ret = Math.max(ret, j - i + 1);
                j++;
            } else {
                char c = s.charAt(i);
                counts[c]--;
                total -= counts[c] == 0 ? 1 : 0;
                i++;
            }
        }
        return ret;
    }
	
	
	//Sol 1: My solution: slow fast + hashMap
    public int lengthOfLongestSubstringTwoDistinct(String s) 
    {
        if(s==null || s.length()==0) return 0;
        if(s.length()<=2) return s.length();
        
        int n = s.length();
        Map<Character,Integer> hash = new HashMap<Character,Integer>();
        int slow = 0;
        int fast = 0;
        int max = 1;
        while(fast<s.length())
        {
            char cur = s.charAt(fast);
            if(hash.size()<2 && !hash.containsKey(cur))
            {
                hash.put(cur,1);
            }
            else if(hash.containsKey(cur))
            {
                hash.put(cur,hash.get(cur)+1); 
            }
            else
            {
                while(hash.size()==2)
                {
                    char curslow = s.charAt(slow);
                    hash.put(curslow,hash.get(curslow)-1);
                    if(hash.get(curslow)==0) hash.remove(curslow);
                    slow++;
                }
                hash.put(cur,1);
            }
            max = Math.max(max,fast-slow+1);
            fast++;
        }
                    
        return max;
    }
	

}
