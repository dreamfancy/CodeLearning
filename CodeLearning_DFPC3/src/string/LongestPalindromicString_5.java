package string;

public class LongestPalindromicString_5 
{
	
	// Longest --> think about DP, what is the DP "Difference": The length of Palindromic
    public String longestPalindrome_DP(String s)  
    {
    	if(s==null || s.length()<=1) return s;
    	int len = s.length();
    	int maxLen = 1;
    	boolean[][] dp = new boolean[len][len];
    	
    	String longest = null;
    	
    	for(int l=0; l<len-1;l++)
    	{ 
    		for(int i=0; i<len-l; i++)
    		{
    			int j = l+i;
    			if((s.charAt(i)==s.charAt(j) &&(j-i<=2 || dp[i+1][j-1])))
    			{
    				dp[i][j] = true;
    				if(j-i+1>maxLen)
    				{
    					maxLen = j-i+1;
    					longest = s.substring(i,j+1);
    				}
    			}
    		}
    	}
    	
    	return longest;
    }
    
    public String longestPalindrome_Iter(String s)
    {
    	if(s.isEmpty()) return null;
    	if(s.length()<=1) return s;
    	
    	String longest = s.substring(0,1);
    	
    	for(int i=0; i<s.length(); i++)
    	{
    		String tmp = helper(s,i,i);
    		if(tmp.length()>longest.length()) longest = tmp;
    		
    		tmp = helper(s,i,i+1);
    		if(tmp.length()>longest.length()) longest = tmp;
    	}
    	return longest;
    }
    
    private String helper(String s, int i, int j)
    {
    	String result = null;
    	if(i==j)
    	{
    		int k=1;
    		for(k=1; (i>=k) && ((i+k)<s.length()); k++)
    		{
    			if(s.charAt(i-k)==s.charAt(i+k)) continue;
    			break;
    		}
    		result = s.substring(i-k+1,i+k);
    	}
    	else
    	{
    		int k=0;
    		for(k=0; (i>=k)&&(j+k)<s.length(); k++)
    		{
    			if(s.charAt(i-k)==s.charAt(j+k)) continue;
    			break;
    		}
    		result = s.substring(i-k+1,j+k);
    	}
    	
    	return result;
    }
    
    
    //Solution 3: Leetcode majority result
    private int lo, maxlen;

    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        for(int i = 0; i < s.length(); i ++) {
            palindrome(s, i, i);
            palindrome(s, i, i + 1);
        }
                  
        return s.substring(lo, lo + maxlen);
    }
    
    private void palindrome(String s, int start, int end) {
        while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start --;
            end ++;
        }
        
        if(maxlen < end - start - 1) {
            lo = start + 1;
            maxlen = end - start - 1;
        }
    }
    
    private int low, maxLen;
    //Solution 4: Leetcode best solution result
    public String longestPalindrome_best(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

}
