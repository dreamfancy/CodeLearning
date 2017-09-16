package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorldBreak_139 {
	
	//Solution 1: My solution = lecture solution
	//What is the variable between dps: the length of the word
    public boolean wordBreak(String s, List<String> wordDict) {
        
    	boolean[] dp = new boolean[s.length()];

    	Set<String> wordDictSet = new HashSet<String>();
    	
    	for(String word : wordDict)
    	{
    		wordDictSet.add(word);
    	}
    	
    	if(wordDictSet.contains(s.substring(0,1)))
    	{
    		dp[0] = true;
    	}
    	else dp[0] = false;
    	
    	for(int i=1; i<s.length(); i++)
		{
    		for(int j=0; j<i; j++)
    		{
    			//if(dp[j]==false) continue;
    			if(dp[j]==true && wordDictSet.contains(s.substring(j+1,i+1)))
    			{
    				dp[i] = true;
    				break;
    			}		
    		}
            if(wordDictSet.contains(s.substring(0,i+1))) dp[i] = true;
            //if(i==3) System.out.println(dp[3]);
		}
    	return dp[s.length()-1];	
    }
    
    
    //Solution 2: Similar to solution 1 as getting from leadsheet toppest answer, but
    //1 HashSet can get initialized by argument of a list
    //2 add a dp[0] to avoid ambiguities
public boolean wordBreak_2(String s, List<String> wordDict) {
        
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }  
}
