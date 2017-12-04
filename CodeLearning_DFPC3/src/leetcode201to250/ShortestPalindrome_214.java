package leetcode201to250;

public class ShortestPalindrome_214 
{
	//Sol 4: KMP
	public String shortestPalindrome_4(String s) 
	{
		String revs = new StringBuilder(s).reverse().toString();
		String revsadds = revs + "#" + s;
		int n = revsadds.length();
		int[] bmp = new int[n];
		
		for(int j=1; j<n; j++)
		{
			int i = bmp[j-1];
			while(i>1 && revsadds.charAt(i)!=revsadds.charAt(j))
			{
				i = bmp[i-1];
			}
			if(revsadds.charAt(i)==revsadds.charAt(j))
			{
				bmp[j] = i;
			}
		}
			
		int maxpalindrome = bmp[n-1];
		return revs.substring(0,revs.length()-maxpalindrome) + s;
	}
			
	//Sol 3: Two pointers + Recursion????why
	public String shortestPalindrome_3(String s) {
	    int i=0; 
	    int j=s.length()-1;
	 
	    while(j>=0){
	        if(s.charAt(i)==s.charAt(j)){
	            i++;
	        }
	        j--;
	    }
	 
	    if(i==s.length())
	        return s;
	 
	    String suffix = s.substring(i);
	    String prefix = new StringBuilder(suffix).reverse().toString();
	    String mid = shortestPalindrome_3(s.substring(0, i));
	    return prefix+mid+suffix;
	}
	
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
