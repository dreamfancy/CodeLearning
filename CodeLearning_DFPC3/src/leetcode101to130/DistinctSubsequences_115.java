package leetcode101to130;

public class DistinctSubsequences_115 {
    public int numDistinct(String s, String t) {
        if(s==null ||s.length()==0)
        {
            return 0;
        }
        if(t==null || t.length()==0) return 1;
        
        int slen = s.length();
        int tlen = t.length();
        
        int[][] dp = new int[t.length()+1][s.length()+1];
        
        dp[0][0] = 1;
        
        for(int j=1; j<slen+1; j++)
        {
            dp[0][j] = 1;
        }
        
        for(int i=1; i<=tlen; i++)
        {
            for(int j=1; j<=slen; j++)
            {
                dp[i][j] += dp[i][j-1];
                if(t.charAt(i-1)==s.charAt(j-1))
                {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        
        return dp[tlen][slen];
        
        
    }
}
