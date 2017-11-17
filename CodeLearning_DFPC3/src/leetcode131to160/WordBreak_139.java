package leetcode131to160;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordBreak_139 
{
	//Sol 2 : DP
    public boolean wordBreak_DP(String s, List<String> wordDict) 
    {
        if(s==null || s.length()==0 || wordDict==null || wordDict.size()==0) return false;
        boolean[] dp = new boolean[s.length()];
        
        for(int i=0; i<s.length(); i++)
        {
        	for(int j=0; j<=i; j++)
        	{
        		if(wordDict.contains(s.substring(j,i+1)) &&(j==0 || dp[j-1]==true))
        		{
        			dp[i] = true;
        		}
        	}
        }
        return dp[s.length()-1];    
    }

	//Sol 1: My Solution : Time Exceeds Limit: DFS
    public boolean wordBreak_DFS(String s, List<String> wordDict) 
    {
        if(s==null || s.length()==0 || wordDict==null || wordDict.size()==0) return false;
        
        Collections.sort(wordDict, new Comparator<String>()
                         {
                             @Override
                             public int compare(String s1, String s2)
                             {
                                 return s1.length()-s2.length();
                             }
                             
                         });
        return findMatching(s,0,wordDict);  
        
    }
    public boolean findMatching(String s, int cur, List<String>wordDict)
    {
        if(cur==s.length()) return true;
        else if(cur>s.length()) return false;
        
        boolean res = false;
        
        for(String wd: wordDict)
        {
            int pos = s.substring(cur).indexOf(wd);
            if(pos==0)
            {
                res |= findMatching(s,cur + wd.length(), wordDict);   
            }
            if(res==true) return true;
        }
        
        return false;
    }

}
