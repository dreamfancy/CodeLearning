package leetcode161to200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences_187 
{
    public List<String> findRepeatedDnaSequences(String s) 
    {
        List<String> result = new ArrayList<String>();
        if(s==null || s.length()<10) return result;
        int n = s.length();
        Set<String> hash = new HashSet<String>();
        for(int i=0; (i+10)<=n; i++)
        {
            String cur = s.substring(i,i+10);
            if(hash.add(cur)==false && !result.contains(cur))
            {
                result.add(cur);
            }
        }
        return result;
    }
}
