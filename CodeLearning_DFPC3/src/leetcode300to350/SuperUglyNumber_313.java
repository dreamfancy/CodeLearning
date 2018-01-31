package leetcode300to350;

import java.util.ArrayList;
import java.util.List;

public class SuperUglyNumber_313 
{
    public int nthSuperUglyNumber(int n, int[] primes) 
    {
        if(n<=1 || primes==null || primes.length==0) return 1;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int k = primes.length;
        int[] p = new int[k];
 
        for(int i=2; i<=n; i++)
        {
            int curmin = Integer.MAX_VALUE;
            int pnum = -1;
            for(int j=0; j<k; j++)
            {
                int cur = primes[j] * list.get(p[j]);
                if ( cur < curmin)
                {
                    curmin = primes[j]*list.get(p[j]);
                    pnum = j;
                }
            }
            list.add(curmin);
            p[pnum]++;
            
            for(int j=0; j<k; j++)
            {
                while(primes[j]*list.get(p[j])<=curmin) p[j]++;
            }
        }
        return list.get(list.size()-1);
    }

}
