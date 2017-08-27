package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindow_76 
{
	//Solution 4: Leetcode solution: Only use one hashmap
	  public String minWindow_4(String s, String t) {
		    HashMap<Character,Integer> map = new HashMap();
		    for(char c : s.toCharArray())
		        map.put(c,0);
		    for(char c : t.toCharArray())
		    {
		        if(map.containsKey(c))
		            map.put(c,map.get(c)+1);
		        else
		            return "";
		    }
		    
		    int start =0, end=0, minStart=0,minLen = Integer.MAX_VALUE, counter = t.length();
		    while(end < s.length())
		    {
		        char c1 = s.charAt(end);
		        if(map.get(c1) > 0)
		            counter--;
		        map.put(c1,map.get(c1)-1);
		        
		        end++;
		        
		        while(counter == 0)
		        {
		            if(minLen > end-start)
		            {
		                minLen = end-start;
		                minStart = start;
		            }
		            
		            char c2 = s.charAt(start);
		            map.put(c2, map.get(c2)+1);
		            
		            if(map.get(c2) > 0)
		                counter++;
		            
		            start++;
		        }
		    }
		    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
		}
	
	
	//Solution 3: int[] solution
	public String minWindow_3(String s, String t) {
        int m = s.length(),n=t.length();
        int start=0,len=Integer.MAX_VALUE;
        int[]cnt=new int[128];
        char[]ss=s.toCharArray();
        char[]tt=t.toCharArray();
        for(char c:tt){
            cnt[c]++;
        }
        int begin=0,end=0;
        while(end<m){
            if(cnt[ss[end++]]-- >0)
                n--;
            while(n==0){
                if(len>end-begin){
                    start=begin;
                    len=end-begin;
                }
                if(++cnt[ss[begin++]]>0)
                    n++;
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
	
	
	//Solution 2: HashMap Solution Can resolve the duplicates scenarios
    public String minWindow_HashSolution(String s, String t) 
    {
    	if(s==null || s.length()==0 || t==null || t.length()==0) return "";
    	if(t.length()>s.length()) return "";
    	String result = "";
    	
    	Map<Character,Integer> target = new HashMap<Character,Integer>();
    	
    	for(int i=0; i<t.length(); i++)
    	{
    		char c = t.charAt(i);
    		if(target.containsKey(c))
    		{
    			target.put(c, target.get(c)+1);
    		}
    		else
    		{
    			target.put(c,1);
    		}
    	}
    	
    	Map<Character,Integer> map = new HashMap<Character,Integer>();
    	int left = 0;
    	int minLen = s.length()+1;
    	
    	int count = 0;
    	
    	for(int i=0; i<s.length(); i++)
    	{
    		char c = s.charAt(i);
    		
    		if(target.containsKey(c))
    		{
    			if(map.containsKey(c))
    			{
    				if(map.get(c)<target.get(c))
    				{
    					count++;
    				}
    				map.put(c,map.get(c)+1);
    			}
    			else
    			{
    				map.put(c,1);
    				count++;
    			}
    		}
    			
    		if(count==t.length())
    		{
    			char sc = s.charAt(left);
    			
    			while(!map.containsKey(sc) || map.get(sc)>target.get(sc))
    			{
    				if(map.containsKey(sc) && map.get(sc)>target.get(sc))
    				{
    					map.put(sc, map.get(sc)-1);
    				}
    				left++;
    				sc = s.charAt(left);
    			}
    			
    			if(i-left+1<minLen)
    			{
    				result = s.substring(left,i+1);
    				minLen = i-left+1;
    			}
    		}
    	}
    	return result;
    }
	
	//My solution 1: Only considered the hashset no duplicate sceanarios because set feature 
	//how about "aa" and "a"
    public String minWindow_1(String s, String t) 
    {
    	if(t==null || t.length() == 0) return t;
    	if(s==null || s.length()==0) return s;
    	Set<Character> tset = new HashSet<Character>();
    	
    	for(int i=0; i<t.length(); i++)
    	{
    		tset.add(t.charAt(i));
    	}
    	
    	Set<Character> sset = new HashSet<Character>();
    	
    	int resleft = 0;
    	int length = 0;
    	
    	int slow = 0;
    	int fast = 0;
    	//sset.add(s.charAt(fast));
    	//fast++;
    	
    	while(fast<s.length())
    	{
    		if(!sset.containsAll(tset))
    		{
    	    	sset.add(s.charAt(fast));
    	    	fast++;
    	    	if((fast-slow)>length)
    	    	{
    	    		resleft = slow;
    	    		length = fast-slow;
    	    	}
    		}
    		else
    		{
    			if((fast-slow)>length)
    	    	{
    	    		resleft = slow;
    	    		length = fast-slow;
    	    	}
    			sset.remove(s.charAt(slow));
    			slow++;
    		}
	    	
    	}
    	return s.substring(resleft,resleft+length);
    }
}
