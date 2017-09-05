package first100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber_17 
{
	//My Solution 1: Iterate StringBuilde
    public List<String> letterCombinations(String digits) 
    {
    	//Map<Integer,List<Character>> repo = new HashMap<Integer,List>(); 	
    	List<String> result = new ArrayList<String>();
    	if(digits==null || digits.length()==0) return result; 
    	StringBuilder sb = new StringBuilder();
    	
    	char[] chars = digits.toCharArray();
    	//Arrays.sort(chars);
    	helper(chars,0,sb,result);
    	
    	return result;
    	
    }
    public void helper(char[] chars, int cur, StringBuilder sb, List<String> result)
    {
    	if(cur==chars.length)
    	{
    		result.add(sb.toString());
    		return;
    	}
    	if(chars[cur]=='2')
    	{
    		sb.append('a');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('b');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('c');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	else if(chars[cur]=='3')
    	{
    		sb.append('d');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('e');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('f');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	else if(chars[cur]=='4')
    	{
    		sb.append('g');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('h');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('i');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	else if(chars[cur]=='5')
    	{
    		sb.append('j');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('k');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('l');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	else if(chars[cur]=='6')
    	{
    		sb.append('m');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('n');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('o');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	else if(chars[cur]=='7')
    	{
    		sb.append('p');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('q');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('r');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('s');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	else if(chars[cur]=='8')
    	{
    		sb.append('t');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('u');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('v');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	else if(chars[cur]=='9')
    	{
    		sb.append('w');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('x');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('y');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append('z');
    		helper(chars,cur+1,sb,result);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
    

}
