package leetcode1to50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords_30 
{
	//Solution 2:
	//Something similar to sliding window
	public List<Integer> findSubstring_2(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if(s==null || s.length()==0 || words==null || words.length==0) return result;
        int wordcount = words.length;
        int len = words[0].length();
        Map<String,Integer> hash = new HashMap<String, Integer>();
        
        for(String str: words)
        {
        	if(hash.containsKey(str))
        	{
        		hash.put(str, hash.get(str)+1);
        	}
        	else
        	{
        		hash.put(str, 1);
        	}
        }

        //There can be multiple starting position when given a repeated string such as "aaaa"
        for(int i=0; i<len; i++)
        {
        	int start = i;
        	int cur = start;        	
        	Map<String,Integer> used = new HashMap<String,Integer>();
        	
        	while(cur<=s.length()-len)
        	{
            	String candidate = s.substring(cur,cur+len);
                cur = cur+len;
            	
            	if(!hash.containsKey(candidate))
            	{
            		start = cur;
            		used = new HashMap<String,Integer>();
            	}
            	else
            	{
                    if(!used.containsKey(candidate))
                    {
                        used.put(candidate,1);
                    }
            		else 
                    {
                        used.put(candidate, used.get(candidate)+1);
                        
                        while(used.get(candidate)>hash.get(candidate))
            		    {
                           String toDelete = s.substring(start,start+len);            			  
                           used.put(toDelete,used.get(toDelete)-1);
                           if(used.get(toDelete)==0)
                           {
                                used.remove(toDelete);
                           }   
                           start = start+len;
            		    }
                    }
            	    if((cur-start)==(len*wordcount))
            		    	result.add(start);
            	}
        	}
        }
        return result; 
	}
	
	//Solution 1:
	//For each starting point, copy the hashMap and remove what has been traversed to see if it can go 0 without break
    public List<Integer> findSubstring_1(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if(s==null || s.length()==0 || words==null || words.length==0) return result;
        int wordcount = words.length;
        int len = words[0].length();
        Map<String,Integer> hash = new HashMap<String, Integer>();
        for(String str: words)
        {
            if(hash.containsKey(str))
            {
                hash.put(str,hash.get(str)+1);
            }
            else
            {
                hash.put(str,1);
            }
        }
        
        for(int i=0; i<=s.length()-len*wordcount; i++)
        {
           Map<String,Integer> curhash = new HashMap<String, Integer>(hash);
           int start= i; 
            for(int j=0; j<wordcount; j++)
            { 
                String curstr= s.substring(start,start+len);
                if(!curhash.containsKey(curstr)) break;
                int num = curhash.get(curstr)-1;
                if(num==0) curhash.remove(curstr);
                else curhash.put(curstr,num);
                start = start+len;
            }
            if(curhash.isEmpty())
            {
                result.add(i);
            }
        }  
        return result;
    }

}
