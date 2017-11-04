package leetcode51to100;

public class DecodeWays_91 {
	
	//DP Solution : From the opposite direction
	//DP solution is used when some patterns have two different possibilities
	//and to count sum
    public int numDecodings_DP(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
	
	//My Solution:
	//Pass all the test cases but time exceeds limit
    public int numDecodings_Recur(String s) {
        if(s==null || s.length()==0) return 0;
        if(s.length()==1 && s.charAt(0)=='0') return 0;
        if(s.length()==1 && s.charAt(0)!='0') return 1;
        
        return numDecodings(s,0);
    }
    
    public int numDecodings(String s, int cur)
    {
        if(cur>=s.length()) return 1;
        int val = s.charAt(cur)-'0';
        if(val>=3 && val<=9)
            return numDecodings(s,cur+1);
        else if(val==2)
        {
            if(cur<(s.length()-1))
            {
                if((s.charAt(cur+1)-'0')>6 || s.charAt(cur+1)=='0')
                {
                    return numDecodings(s,cur+2);
                }
                else
                    return (numDecodings(s,cur+1) + numDecodings(s,cur+2));
            }
            else return 1;
        }
        else if(val==1)
        {
            if(cur<(s.length()-1))
            {
                if(s.charAt(cur+1)>'0')
                {
                    return (numDecodings(s,cur+1) + numDecodings(s,cur+2));
                }
                else return numDecodings(s,cur+2);
            }
            else return 1;
        }
        else
        {
            return 0;
        }
    }
}
