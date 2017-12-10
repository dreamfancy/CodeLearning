package leetcode201to250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings_249 
{
	//Sol 1: Unify the patterns based on the first letter
    public List<List<String>> groupStrings(String[] strings) 
    {
        List<List<String>> result = new ArrayList<List<String>>();
    	if(strings==null || strings.length==0) return result;
        
        Map<String,List<Integer>> map = new HashMap<String, List<Integer>>();
        
        for(int i=0; i<strings.length; i++)
        {
            String cur = strings[i];
            char[] curarr = cur.toCharArray();
            
            int first = curarr[0];
            for(int j=0; j<curarr.length; j++)
            {
                int num = (curarr[j]-first)%26;
                if(num<0) num +=26;
                curarr[j] = (char)(num + 'a');
              
            }
            String pattern = new String(curarr);
            System.out.println(pattern);
            if(map.containsKey(pattern))
            {
                map.get(pattern).add(i);
            }
            else
            {
                List<Integer> newlist = new ArrayList<Integer>();
                newlist.add(i);
                map.put(pattern,newlist);
            }
        }
        Iterator<String> iter = map.keySet().iterator();
        
        while(iter.hasNext())
        {
        	List<Integer> cur = map.get(iter.next());
        	List<String> tobeadded = new ArrayList<String>();
        	for(int i: cur)
        	{
        		tobeadded.add(strings[i]);
        	}
        	result.add(tobeadded);
        }
        return result;
    }
}
