package leetcode201to250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordDictionary {

    class CharNode
    {
        char val;
        Map<Character,CharNode> map;
        boolean end;
        
        public CharNode(char input)
        {
            val = input;
            map = new HashMap<Character, CharNode>();
            end = false;
        }
        
        public char getValue()
        {
        	return val;
        }
        public CharNode addChar(char nextChar)
        {
            CharNode nextCharNode = new CharNode(nextChar);
            map.put(nextChar,nextCharNode);
            return nextCharNode;
        }
        
        public CharNode searchChar(char nextChar)
        {
            return map.get(nextChar);
        }
        
        public List<CharNode> getAllNextChars()
        {
        	List<CharNode> charNodeList = new ArrayList<CharNode>();	
        	for(Map.Entry<Character,CharNode> entry : map.entrySet())
        	{
        		charNodeList.add(entry.getValue());
        	}
        	return charNodeList;
        }
    }
    
    /** Initialize your data structure here. */
    CharNode root;
    public WordDictionary() 
    {
        root = new CharNode('*');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) 
    {
        CharNode cur = root;
        for(int i=0; i<word.length(); i++)
        {
            char curChar = word.charAt(i);
            CharNode nextNode = cur.searchChar(curChar);
            if(nextNode==null)
            {
                nextNode = cur.addChar(curChar);
            }
            cur = nextNode;
        }
        cur.end = true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) 
    {
        CharNode cur = root;
        return searchrecursive(word,cur);
        
    }
    
    private boolean searchrecursive(String word, CharNode cur)
    {
        if(word==null || word.length()==0) return false;
        int len = word.length();
        char curchar = word.charAt(0);
        if(curchar!='.')
        {
        	CharNode nextNode = cur.searchChar(curchar);
        	if(nextNode==null) return false;
        	if(nextNode.end==true && len==1) return true;
        	else
        	{
        		boolean nextlevel = searchrecursive(word.substring(1),nextNode);
        		if(nextlevel==true) return true;
        	}
        }
        else
        {
        	List<CharNode> nextNodes = cur.getAllNextChars();
        	if(len==1)
        	{
            	for(CharNode nextNode: nextNodes)
            	{
            		if(nextNode.end==true) return true;
            	}
            	return false;

        	}
        	char nextchar = word.charAt(1);
        	
        	for(CharNode nextNode: nextNodes)
        	{
    			boolean nextlevel = searchrecursive(word.substring(1), nextNode);
    			if(nextlevel==true) return true;	
        	}
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
