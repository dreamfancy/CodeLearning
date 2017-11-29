package leetcode201to250;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Better than the top rated solution !!! good
public class ImplementTrie_208 {
    class TrieNode
    {
        char val;
        List<TrieNode> children;
        boolean end;
        Map<Character,TrieNode> map;
        public TrieNode(char input)
        {
            val = input;
            map = new HashMap<Character,TrieNode>();
            end = false;
        }
        
        public TrieNode addNextChar(char nextChar)
        {
            TrieNode nextNode = new TrieNode(nextChar);
            map.put(nextChar,nextNode);
            return nextNode;
        }
        
        public TrieNode getNextChar(char nextChar)
        {
            return map.get(nextChar);
        }
        
        public void reachWordEnd()
        {
            end = true;
        }
        public boolean isWordEnd()
        {
            return end==true;
        }
        
    }
    
    /** Initialize your data structure here. */
    TrieNode root;
    public ImplementTrie_208() 
    {
        root = new TrieNode('*');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null || word.length()==0) return;
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++)
        {
            if(cur.getNextChar(word.charAt(i))!=null)
            {                
                cur = cur.getNextChar(word.charAt(i));
            }
            else
            {
                cur = cur.addNextChar(word.charAt(i));
            }
        }
        cur.reachWordEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null || word.length()==0) return false;
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++)
        {
            if(cur.getNextChar(word.charAt(i))==null) return false;
            cur = cur.getNextChar(word.charAt(i));
        }
        
        return cur.isWordEnd() ? true :  false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) 
    {
        if(prefix==null || prefix.length()==0) return false;
        TrieNode cur = root;
        for(int i=0; i<prefix.length(); i++)
        {
            cur = cur.getNextChar(prefix.charAt(i));
            if(cur==null) return false;
        }
        return true;
    }
}
