package leetcode201to250;

public class ShortestPalindrome_214 
{
	
	//Sol 2: Create the reversed string to speed up the comparation
    public String shortestPalindrome_2(String s)
    {
    	StringBuilder sb = new StringBuilder(s);
    	String revs = sb.reverse().toString();
    	int n = s.length();
    	for(int i=0; i<s.length(); i++)
    	{
    		if(s.substring(0,n-i).equals(revs.substring(i)));
    				return revs.substring(0,i)+ s;
    	}
    	return "";
    }

	
	
	
	
	
	//Sol 1: My Sol: find the biggest starting from beginning
	//then make up the left parts at the front.
    public String shortestPalindrome_1(String s) 
    {
        if(s==null || s.length()==0) return "";
        if(s.length()==1) return s;
        
        int end = 0;
        for(int i=s.length()-1;i>=0; i--)
        {
            if(isPalindrome(s,0,i)) 
            {
                end = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        
        for(int i=end+1; i<s.length(); i++)
        {
            sb.insert(0,s.charAt(i));
        }
        return sb.toString();
    }
    
    private boolean isPalindrome(String s, int start, int end)
    {
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

}
