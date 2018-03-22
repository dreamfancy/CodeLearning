package leetcode300to350;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RemoveDuplicateLetters_316 
{
    public String removeDuplicateLetters(String s) 
    {
        if(s==null || s.length()==0) return "";
        if(s.length()==1) return s;
        
        Map<Character, Integer> lastPosMap = new HashMap<Character,Integer>();
        for(int i=0;i<s.length(); i++)
        {
            lastPosMap.put(s.charAt(i),i);
        }
        int size = lastPosMap.size();
        StringBuilder sb = new StringBuilder();
        
        int left = 0;
        int right = findMinLastPos(lastPosMap);
        System.out.println("Initial Right value: " + right);
        char[] scharArr = s.toCharArray();
        
        for(int c=0; c<size; c++)
        {
            char minChar = 'z'+1;
            for(int j=left; j<=right; j++)
            {
                if(lastPosMap.containsKey(scharArr[j]) && scharArr[j]<minChar)
                {
                    minChar = scharArr[j];
                    left = j+1;
                }
            }
            sb.append(minChar);
            lastPosMap.remove(minChar);
            if(scharArr[right]==minChar)
            {
                right = findMinLastPos(lastPosMap);
            }
        }
        return sb.toString();
    }
    
    private int findMinLastPos(Map<Character,Integer> lastPosMap)
    {
        int minPos = Integer.MAX_VALUE;
        Iterator<Character> iter = lastPosMap.keySet().iterator();
        while(iter.hasNext())
        {
            int val = lastPosMap.get(iter.next());
            minPos = Math.min(val,minPos);
        }
        return minPos;
    }

}
