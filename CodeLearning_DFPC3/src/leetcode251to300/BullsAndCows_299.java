package leetcode251to300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BullsAndCows_299 
{
	//Sol 2:
	//Revisit!!!
    public String getHint(String secret, String guess) 
    {
        if(secret==null || secret.length()==0 || guess==null || guess.length()==0) return "0A0B";
        
        int bull = 0;
        int cow = 0;
        int[] count = new int[10];
        for(int i=0; i<secret.length(); i++)
        {
            if(secret.charAt(i)==guess.charAt(i))
            {
                bull++;
            }
            else 
            {
                 if(count[secret.charAt(i)-'0']-->0)
                    cow++;   
                 if(count[guess.charAt(i)-'0']++<0)
                    cow++;
            }
            
            /*
            //Wrongbelow!!! as two possibilities can occur at the same time!
            else if(count[secret.charAt(i)-'0']-->0)
            {
                cow++;   
            }
            else if(count[guess.charAt(i)-'0']++<0)
            {
                cow++;
            }
            */
        }
        return bull+"A"+cow+"B";
    }
	
	
	//Sol 1: HashMap compare
	//Wrong for some case, cannot figure out why yet
    public String getHint_1(String secret, String guess) 
    {
        if(secret==null || secret.length()==0 || guess==null || guess.length()==0) return "0A0B";
        
        Map<Character,List<Integer>> mapsource = new HashMap<Character,List<Integer>>();
        Map<Character,List<Integer>> maptarget = new HashMap<Character,List<Integer>>();

        
        for(int i=0; i<secret.length(); i++)
        {
            char curchar = secret.charAt(i);
            if(!mapsource.containsKey(curchar))
            {
                List<Integer> posli = new ArrayList<Integer>();
                mapsource.put(curchar,posli);
            }
            mapsource.get(curchar).add(i);
        }
        
        for(int j=0; j<guess.length(); j++)
        {
            char curchar = guess.charAt(j);
            if(!maptarget.containsKey(curchar))
            {
                List<Integer> posli = new ArrayList<Integer>();
                maptarget.put(curchar,posli);
            }
            maptarget.get(curchar).add(j);
        }
        
        int a = 0;
        int b = 0;
        
        Iterator<Character> iter = mapsource.keySet().iterator();
        while(iter.hasNext())
        {
            char cur = iter.next();
            if(!maptarget.containsKey(cur))
                continue;
            List<Integer> l1 = mapsource.get(cur);
            List<Integer> l2 = maptarget.get(cur);
            
            int p1=0, p2=0;
            int same = 0;
            while(p1<l1.size() && p2<l2.size())
            {
                if(l1.get(p1)==l2.get(p2))
                {
                    same++;
                    p1++;
                    p2++;
                }
                else if(l1.get(p1)<l2.get(p2))
                {
                    p1++;
                }
                else p2++;
            }
            
            a += same;
            b += Math.min(l1.size()-same, l2.size()-same);
        }
        
        return a+"A"+b+"B";
    }

}
