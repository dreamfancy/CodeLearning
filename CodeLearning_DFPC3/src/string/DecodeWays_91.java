package string;

public class DecodeWays_91 
{
	//Solution 3: Official DP solution from leetcode
    public int numDecodings_3(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= s.length(); i++) {
            int one = Integer.parseInt(s.substring(i-1, i));
            int two = Integer.parseInt(s.substring(i-2, i));
            if(one >= 1 && one <= 9) dp[i] += dp[i-1];
            if(two >= 10 && two <= 26) dp[i] += dp[i-2];
        }
        
        return dp[s.length()];
    }
	
	
	//Solution 2: DP use array
    public int numDecodings(String s) 
    {
    	int[] f = new int[s.length()];
    	if(s==null || s.length()==0) return 0;
    	if(s.charAt(0)=='0') return 0;
    	f[0] = 1;
    	if(s.length()==1) return 1;
    	f[1] = 1;
    	if(s.charAt(0)=='1'&& s.charAt(1)>='1' || s.charAt(0)=='2' && s.charAt(1)<='6' && s.charAt(1)>='1')
    	{
    		f[1] = 2;
    	}
    	
    	for(int i=2; i<s.length(); i++)
    	{
    		if(s.charAt(i)>'0') f[i] += f[i-1];
    		if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2' && s.charAt(i)<='6') f[i] += f[i-2];
    	}
    	
    	return f[s.length()-1];
    }
    
    //why dp,the digit f[i] is impacted by f[i-1] and f[i-2]
	
	
	
	//My Solution Wrong!
	//What about 110,1110 you cannot assing 2 as a group because it may be impacted by the third or fourth value
    public int numDecodings_Wrong(String s) 
    {
    	if(s==null || s.length()==0) return 0;
    	if(s.charAt(0)=='0') return 0;
    	return numDecodings(s,0,1);
    }
    
    private int numDecodings(String s, int cur, int res)
    {
    	//int preres = res;
    	if(cur>=s.length()) return res;
    	if(s.charAt(cur)!='1' && s.charAt(cur)!='2' && s.charAt(cur)!='0')
    	{
    		res = numDecodings(s,cur+1,res);
    	}
    	else if(s.charAt(cur)=='1')
    	{
    		if(cur<(s.length()-1) && s.charAt(cur+1)!='0')
    		{
    			res = res * 2;
    		}
    		res = numDecodings(s, cur+2,res);
    		
    	}
    	else if (s.charAt(cur)=='2')
    	{
    		if(cur<(s.length()-1) && s.charAt(cur+1)<='6' && s.charAt(cur+1)>='1')
    		{
    			res = res * 2;
    		}
    		res = numDecodings(s,cur+2,res);	
    	}
    	else if(s.charAt(cur)=='0') 
    	{
    		return 0;
    	}
    	
    	return res;
    	
    }


}
