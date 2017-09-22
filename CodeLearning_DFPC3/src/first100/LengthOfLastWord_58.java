package first100;

public class LengthOfLastWord_58 
{
	//Use string.trim()
    public int lengthOfLastWord_my(String s) 
    {
    	if(s==null || s.length()==0) return 0;
    	int cur = 0;
    	int count = 0;
    	s = s.trim();
    	while(cur<=s.length()-1)
    	{
    		count = 0;
    		while(cur<=(s.length()-1) && (s.charAt(cur)!=' '))
    		{
    			cur++;
    			count++;
    		}
    		cur++;
    	}
    	return count;  	
    }

    
    //Solution 1: Best Solution from leetcode discussion
    //string.trim() will make leading and trailing whitespace omitted
    //string.lastIndexOf("subString") can help know the string position
    public int lengthOfLastWord_LCDiscussion(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }

}
