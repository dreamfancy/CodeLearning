package leetcode131to160;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_131 
{
	//Sol 2: DP to the current end
	public List<List<String>> partition_dp(String s) {
		int len = s.length();
		List<List<String>>[] result = new List[len + 1];
		result[0] = new ArrayList<List<String>>();
		result[0].add(new ArrayList<String>());

		boolean[][] dp = new boolean[len][len];
		for (int i = 0; i < s.length(); i++) {
			result[i + 1] = new ArrayList<List<String>>();
			for (int left = 0; left <= i; left++) {
				if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || dp[left + 1][i - 1])) {
					dp[left][i] = true;
					String str = s.substring(left, i + 1);
					for (List<String> r : result[left]) {
						List<String> ri = new ArrayList<String>(r);
						ri.add(str);
						result[i + 1].add(ri);
					}
				}
			}
		}
		return result[len];
	}
	
	//Sol 1: DFS: For string, the start position is the most important part of recursion
    public List<List<String>> partition(String s) {
        
        List<List<String>> resultset = new ArrayList<List<String>>();
        if(s==null || s.length()<=0) return resultset;
        List<String> cursol = new ArrayList<String>();
        partition(s,0, cursol, resultset);
        return resultset;
    }
    
    public void partition(String s, int cur, List<String> cursol, List<List<String>> resultset)
    {
        if(cur==s.length())
        {
            resultset.add(new ArrayList<String>(cursol));
            return;
        }
        
        for(int i=cur; i<s.length(); i++)
        {
            if(isPalindrome(s,cur,i))
            {
                cursol.add(s.substring(cur,i+1));
                partition(s,i+1,cursol,resultset);
                cursol.remove(cursol.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end)
    {
        if(start>end) return false;
        if(start==end) return true;
        
        while(start<=end)
        {
            if(s.charAt(start++)!= s.charAt(end--)) return false;
        }
        return true;
    }
    

}
