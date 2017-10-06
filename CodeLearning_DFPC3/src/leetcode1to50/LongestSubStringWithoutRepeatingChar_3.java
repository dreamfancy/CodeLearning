package leetcode1to50;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChar_3 
{
	
	//Review I
    public int lengthOfLongestSubstring(String s) {
        
        if(s==null || s.length()==0) return 0;
        if(s.length()==1) return 1;
        int max = 1;
        
        Set<Character> charSet = new HashSet<Character>();
        
        int first = 0;
        
        for(int second=0; second<s.length(); second++)
        {
            char cur = s.charAt(second);

            if(!charSet.contains(cur))
            {
                charSet.add(cur);
                int curLength = second-first+1;
                //if(curLength>max) max = curLength;
                max = Math.max(curLength, max);   //Use Math.max to avoid recur
            }
            else
            {
                while(s.charAt(first)!=cur)
                {
                    charSet.remove(s.charAt(first++));  //HashSet can remove char!!!
                    //first++;
                }
                first++;
            }
        }
        
        return max;
    }

}
