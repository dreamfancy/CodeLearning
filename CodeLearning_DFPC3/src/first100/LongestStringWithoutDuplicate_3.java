package first100;

import java.util.HashMap;
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
    // O(n) at most 2n steps
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
    
    //Solution 3: Reduce duplicate steps, once found a duplicate element, we are sure the front pointer can be go to the position after the previous occurance of the element
    public int lengthOfLongestSubstring_3(String s) 
    {
    	int max=0,i=0,j=0;
    	HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
    	while(j<s.length())
    	{
    		if(hash.containsKey(s.charAt(j)))
    		{
    			i = Math.max(hash.get(s.charAt(j)), i);
    		}	
   			hash.put(s.charAt(j), j+1); //Why here is j+1: to resolve the corner case when there is only one element
   			max = Math.max(j-i+1,max);
     	}
    	return max;
    }
    
    
    //Solution 4: When the String only has letters, please use int[] array: the number of possibility is fixed: 128
    public int lengthOfLongestSubstring_4(String s) 
    {
    	int max=0,i=0,j=0;
    	int[] indexArr = new int[128];
    	while(j<s.length())
    	{
    		int index = indexArr[s.charAt(j)];
    		if(index!=0)
    		{
    			i = Math.max(index, i);
    		}
    		indexArr[s.charAt(j)] = j+1;
    		max = Math.max(max, j-i+1);
    	}
    	return max;
    }


}
