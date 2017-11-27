package leetcode161to200;

public class DungeonGame_174 {
    public int calculateMinimumHP(int[][] dungeon) 
    {
        if(dungeon==null || dungeon.length==0 || dungeon[0].length==0) return 0;
        
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int minstart = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];

        
        dp[m-1][n-1] = (1-dungeon[m-1][n-1])>=1 ? (1-dungeon[m-1][n-1]): 1;
            
        for(int i=n-2; i>=0; i--)
        {
            int cur = dp[m-1][i+1] - dungeon[m-1][i];
            dp[m-1][i] = cur>=1 ? cur: 1;
        }
            
        for(int j=m-2; j>=0; j--)
        {
            int cur = dp[j+1][n-1] - dungeon[j][n-1];
            dp[j][n-1] = cur>=1 ? cur : 1;    
        }
        
        for(int j=m-2; j>=0; j--)
        {
            for(int i=n-2; i>=0; i--)
            {
                int cur1 = dp[j+1][i] - dungeon[j][i];
                int cur2 = dp[j][i+1] - dungeon[j][i];
                
                int curmin = Math.min(cur1,cur2);
                dp[j][i] = curmin>=1 ? curmin : 1;    
            }
        }
        return dp[0][0];
    
    }
}
