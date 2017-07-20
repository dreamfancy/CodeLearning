package first100;

import java.util.HashSet;
import java.util.Set;

public class LongestStringWithoutDuplicate_3
{
	//Solution 1: Brute Force: Three levels iteration
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
    
    //Solution 2: Sliding window to iterate the max number
    public int lengthOfLongestSubstring_2(String s) 
    {
    	int i=0,j=0, max=0;
    	HashSet<Character> hash = new HashSet<Character>();
    	while(j<s.length())
    	{
    		if(hash.contains(s.charAt(j)))
    		{
    			hash.remove(s.charAt(i++));
    		}
    		else
    		{
    			hash.add(s.charAt(j++));
    			max = Math.max(max, j-i);
    		}
    	}
    	
    	return max;
    }

}
