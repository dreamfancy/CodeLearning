package leetcode251to300;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindTheCelebrity_276 
{
    public int findCelebrity(int n) 
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<n; i++)
        {
            queue.offer(i);
            set.add(i);
        }
    
        while(!queue.isEmpty())
        {
            int cur = queue.poll();
            if(!set.contains(cur)) continue;
            int count = 0;
            for(int j=0; j<n; j++)
            {
                if(cur!=j && knows(j,cur)==true)
                {
                    set.remove(j);
                    count++;
                    if(count==(n-1))
                    {
                        for(int k=0; k<n; k++)
                        {
                            if(k!=cur && knows(cur,k)) return -1;
                        }
                        return cur;
                    }
                }
                else
                {
                    set.remove(cur);
                }
            }
        }
        return -1;
        
    }
    
    public boolean knows(int i1, int i2)
    {
    	return false;
    }

}
