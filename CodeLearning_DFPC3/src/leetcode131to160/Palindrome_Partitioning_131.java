package leetcode131to160;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_131 
{
	
	
	
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
