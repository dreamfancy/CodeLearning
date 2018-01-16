package leetcode251to300;

import java.util.HashSet;
import java.util.Set;

public class PaintHouse_2_265 
{
    public int minCostII_1(int[][] costs) 
    {
        if(costs==null || costs.length==0 || costs[0].length==0) return 0;
        int n= costs.length;
        int k = costs[0].length;
        if(k==1) return (n==1? costs[0][0] : -1);
        
        int premin = 0;
        int presecmin = 0;
        int preminindex = -1;
        
        for(int i=0; i<n; i++)
        {
            int curmin = Integer.MAX_VALUE;
            int curminindex = -1;
            int cursec = Integer.MAX_VALUE;
            for(int j=0; j<k; j++)
            {
                int val = costs[i][j] + (j==preminindex ? presecmin : premin);
                if(curminindex<0)
                {
                    curmin = val;
                    curminindex = j;
                }
                else if(val<curmin)
                {
                    cursec = curmin;
                    curmin = val;
                    curminindex = j;
                }
                else if(val<cursec)
                {
                    cursec = val;
                }
            }
            premin = curmin;
            presecmin = cursec;
            preminindex = curminindex;
        }
        return premin;
    }	

}
