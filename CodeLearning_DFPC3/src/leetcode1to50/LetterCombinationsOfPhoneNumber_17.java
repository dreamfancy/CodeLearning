package leetcode1to50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber_17 
{
	//Official Solution:
	//Consider how to save the limitted number-letter mapping, use what data structure to save
	//Sol 1:
	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	//Sol 2:
	
    public List<String> letterCombinations_2(String digits) 
    {
	    LinkedList<String> ans = new LinkedList<String>();
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	            String t = ans.remove();
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
    }
	
	
	
	
	
	
	
	
	
	//My Solution: correct
	   public List<String> letterCombinations(String digits) {
	        
	        List<String> res = new ArrayList<String>();
	        if(digits==null || digits.length()==0) return res;
	        
	        StringBuilder sb = new StringBuilder();
	        
	        dfs(digits,0,sb,res);
	        
	        return res;
	    }
	    
	    public void dfs(String digits, int pos, StringBuilder sb, List<String> res)
	    {
	        if(pos==digits.length())
	        {
	            res.add(sb.toString());
	            return;
	        }
	        
	        char digit = digits.charAt(pos);
	        int cur = digit -'0';
	        if(cur==2)
	        {
	            sb.append('a');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('b');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('c');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	        }
	        
	        if(cur==3)
	        {
	            sb.append('d');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('e');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('f');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	        }
	        if(cur==4)
	        {
	            sb.append('g');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('h');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('i');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	        }
	        
	        if(cur==5)
	        {
	            sb.append('j');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('k');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('l');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	        }
	        
	        if(cur==6)
	        {
	            sb.append('m');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('n');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('o');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	        }
	        
	        if(cur==7)
	        {
	            sb.append('p');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('q');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('r');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('s');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	        }
	        
	        if(cur==8)
	        {
	            sb.append('t');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('u');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('v');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	        }
	        
	        if(cur==9)
	        {
	            sb.append('w');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('x');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('y');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	            
	            sb.append('z');
	            dfs(digits,pos+1,sb,res);
	            sb.deleteCharAt(sb.length()-1);
	        }
	    }

}
