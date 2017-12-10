package leetcode251to300;

public class PaintHouse_256 
{
	//Sol 2: DP
	//The min of current value can be impacted by all possible previous values, not only the previous min.
	//so for every node, we need to keep all the minimum when selecting each.
    public int minCost_2(int[][] costs) 
    {
        if(costs==null || costs.length==0) return 0;
        
        for(int i=1; i<costs.length; i++)
        {
        	costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
        	costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
        	costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        int n = costs.length-1;
        return Math.min(costs[n][0], Math.min(costs[n][1], costs[n][2]));
    }
	
	
	//Sol 1: Recursion : Time Exceeds Limit
    public int minCost_1(int[][] costs) 
    {
        if(costs==null || costs.length==0) return 0;
        int housecount = costs.length;
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        
        helper(costs,0,-1,0,min);
        
        return min[0];
    }
    
    private void helper(int[][] costs,int cur,int presel, int cursol,int[] min)
    {
        if(cur==costs.length)
        {
            min[0] = Math.min(cursol,min[0]);
            return;
        }
        for(int i=0; i<3;i++)
        {
            if(i==presel) continue;
            helper(costs,cur+1,i,cursol+costs[cur][i],min);
        }
    }


}
