package leetcode1to50;

public class RegularExpressionMatchDP_10 
{

	//Sol 1: My DP solution Review III
    public boolean isMatch_DP(String s, String p) 
    {
        int plen = p.length();
        int slen = s.length();
        
        boolean[][] dp = new boolean[plen+1][slen+1];
        dp[0][0] = true;
        for(int i=1; i<=slen; i++)
        {
            dp[0][i] = false;
        }
        
        for(int j=1; j<=plen; j++)
        {
            if(p.charAt(j-1)!='*') dp[j][0] = false;
            else
            {
                dp[j][0] = dp[j-2][0];
            }
        }
        
        for(int j=1; j<=plen; j++)
        {
            for(int i=1; i<=slen; i++)
            {
                if(p.charAt(j-1)!='*')
                {
                    if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')
                    {
                        dp[j][i] = dp[j-1][i-1];
                    }
                }
                else
                {
                    if(dp[j-2][i]==true) 
                    {
                        dp[j][i] = true;
                    }
                    else if((s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.' )&& dp[j][i-1]==true)
                    {
                        dp[j][i] = true;
                    }
                    else dp[j][i] = false;
                }
            }
        }
        
        for(int j=0; j<=plen; j++)
        {
            for(int i=0; i<=slen; i++)
            {
            	System.out.print(dp[j][i] + "  ");
            }
            System.out.println();
            System.out.println();
        }
        return dp[plen][slen];
    }
    
    public boolean isMatch(String s, String p)
    {
    	if(p.isEmpty()) return s.isEmpty();
    	boolean firstMatch = !s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
    	//if(!firstMatch) return false; !!!Wrong, does not consider the consequent * possibility
    	
    	if(p.length()>=2 && p.charAt(1)=='*')
    	{
    		return isMatch(s,p.substring(2)) || (firstMatch && isMatch(s.substring(1),p));
    	}
    	else
    	{
    		return firstMatch && isMatch(s.substring(1),p.substring(1));
    	}
    }

}
