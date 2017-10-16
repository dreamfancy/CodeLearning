package leetcode1to50;

public class WildcardMatching_44 
{
    public boolean isMatch(String s, String p) 
    {
        if((s==null || s.length()==0) && (p==null || p.length()==0)) return true;
        if(p==null || p.length()==0) return false;
        
        int slen = s.length();
        int plen = p.length();
        
        boolean [][] dp = new boolean[slen+1][plen+1];
        dp[0][0] = true;
        
        
        //Not necessary, default value for boolean array is false
        /*
        for(int i=1; i<=slen; i++)
        {
            dp[i][0] = false;
        }
        */
        
        for(int j=1;j<=plen; j++)
        {
            if(p.charAt(j-1)=='*' && dp[0][j-1]==true)
            {
                dp[0][j]=true;
            }
        }
        
        for(int i=1; i<=slen; i++)
        {
            for(int j=1; j<=plen; j++)
            {
                if((s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') && dp[i-1][j-1] == true)
                {
                    dp[i][j] = true;
                }
                else if(p.charAt(j-1)=='*')
                {
                    for(int a=0; a<=i; a++)
                    {
                        if(dp[a][j-1]==true) 
                        {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
                else
                {
                    dp[i][j] = false;
                }
            }
        }
        return dp[slen][plen];
     
    }
}
