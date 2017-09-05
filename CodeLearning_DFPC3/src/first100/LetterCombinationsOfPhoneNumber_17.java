package first100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber_17 
{
	//My Solution 1: Iterate StringBuilder
    public List<String> letterCombinations_1(String digits) 
    {
    	Map<Integer,String> repo = new HashMap<Integer,String>(); 	
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
    
    //Solution 2  from program creek
    //Use char[] array, then String.valueOf(charArray) to convert
    //Use HashMap to store value, Use String to save different possibilities
    //of chars, then use for loop with charAt to loop
    
    public List<String> letterCombinations_2(String digits) 
    {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");
     
        ArrayList<String> result = new ArrayList<String>();
     
        if(digits == null || digits.length() == 0)
            return result;
     
        ArrayList<Character> temp = new ArrayList<Character>();
        getString(digits, temp, result, map);
     
        return result;
    }
     
    public void getString(String digits, ArrayList<Character> temp, ArrayList<String> result,  HashMap<Integer, String> map){
        if(digits.length() == 0){
            char[] arr = new char[temp.size()];
            for(int i=0; i<temp.size(); i++){
                arr[i] = temp.get(i);
            }
            result.add(String.valueOf(arr));
            return;
        }
     
        Integer curr = Integer.valueOf(digits.substring(0,1));
        String letters = map.get(curr);
        for(int i=0; i<letters.length(); i++){
            temp.add(letters.charAt(i));
            getString(digits.substring(1), temp, result, map);
            temp.remove(temp.size()-1);
        }
    }

}
