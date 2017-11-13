package leetcode101to130;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder_127 {
	
	//My Solution : Use pre-known-sized queue to do recursion as different levels
	//One round count 1
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null || wordList.size()==0 || beginWord==null || endWord==null || beginWord.length()!=endWord.length() || !wordList.contains(endWord)) return 0;
        
        HashSet<String> visited = new HashSet<String>();
        Queue<String> curreached = new LinkedList<String>();
        curreached.offer(beginWord);
        int count = 0;
        while(!curreached.isEmpty())
        {
            int size = curreached.size();
            
            for(int i=0; i<size; i++)
            {
                String cur = curreached.poll();
                System.out.println(cur);
                for(String wordinlist: wordList)
                {
                    if(!visited.contains(wordinlist) && checkdiff(cur,wordinlist)==0)
                    {
                        count++;
                    }
                    else if(!visited.contains(wordinlist) && checkdiff(cur,wordinlist)==1)
                    {
                        if(wordinlist.equals(endWord))
                        {
                            return ++count;
                        }
                        else
                        {
                            visited.add(wordinlist);
                            curreached.add(wordinlist);
                        }
                    }
                }
                count++;
            }
        }
        return 0;
    }
    
    private int checkdiff(String s1, String s2)
    {
        //if(s1.length()!=s2.length()) return -1;
        int count = 0;
        for(int i=0; i<s1.length(); i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                count++;
            }
        }
        return count;
    }
}
