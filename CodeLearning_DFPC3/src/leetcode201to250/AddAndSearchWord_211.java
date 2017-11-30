package leetcode201to250;

public class AddAndSearchWord_211 {

	    TrieNode root;
	    public class TrieNode {
	        TrieNode[] next = new TrieNode[26];
	        String word;
	    }

	    /** Initialize your data structure here. */
	    public AddAndSearchWord_211() {
	        root = new TrieNode();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        TrieNode p = root;
	        for (char c : word.toCharArray()) {
	            if (p.next[c-'a'] == null) {
	                p.next[c-'a'] = new TrieNode();
	            }
	            p = p.next[c-'a'];
	        }
	        if (p.word == null) {
	            p.word = word;
	        }
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        return match(word.toCharArray(), 0, root);
	    }
	    
	    private boolean match(char[] str, int k, TrieNode node) {
	        if (k == str.length) return node.word != null;
	        if (str[k] != '.') {
	            return (node.next[str[k]-'a'] != null) && match(str, k+1, node.next[str[k]-'a']);
	        } else {
	            for (int i = 0; i < node.next.length; i++) {
	                if (node.next[i] != null && match(str, k+1, node.next[i])) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	}
