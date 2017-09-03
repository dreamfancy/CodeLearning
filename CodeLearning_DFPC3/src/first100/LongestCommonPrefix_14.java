package first100;

public class LongestCommonPrefix_14 
{
	//Solution 1: Horizontal
	//Use str.indexOf(subString)?== 0 to judge
	//Good thing: O(n) time and O(1) space??? from leetcode official solution
    public String longestCommonPrefix(String[] strs) 
    {
    	if(strs==null || strs.length==0) return "";
    	if(strs.length==1) return strs[0];
    	
    	String prefix = strs[0];
    	for(int i=1; i<strs.length; i++)
    	{
    		while(strs[i].indexOf(prefix)!=0)
    		{
    			prefix = prefix.substring(0,prefix.length()-1);
    			if(prefix=="") return "";
    		}
    	}
    	return prefix;
    }
    
    //Solution 2: Vertical
    public String longestCommonPrefix(String[] strs) 
    {
    	
    }
}
