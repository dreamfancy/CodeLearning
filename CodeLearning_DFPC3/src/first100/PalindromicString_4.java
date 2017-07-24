package first100;

public class PalindromicString_4 {
	
	public static void main(String[] args)
	{
		System.out.println(longestPalindrome("adccbbccad"));
	}
	
	
	//Solution 3: KMP  Will check later
	//Solution 4: Manchester
	
	
	
	//Solution 2: DP: What is the differences of the levels:
	// j-i
    public static String longestPalindrome_2(String s) 
    {
    	if(s.length()<=1) return s;
    	
    	boolean[][] dp = new boolean[s.length()][s.length()];
    	
    	for(int i=0; i<s.length(); i++)
    	{
    		for(int j=0; j<s.length(); j++)
    		{
    			if(i>=j) 
    			{
    				dp[i][j] = true;
    			}
    			else
    			{
    				dp[i][j] = false;
    			}
    		}
    	}
    	
    	int maxVal = 1;
    	int first = 0;
    	int	tail=0;
    	
    	for(int d=1; d<s.length();d++)
    	{
    		for(int i=0; d+i<s.length();i++)
    		{
    			int j = i+d;
    			if(s.charAt(i)!=s.charAt(j))
    			{
    				dp[i][j] = false;
    			}
    			else
    			{
    				dp[i][j] = dp[i+1][j-1];
    				if(dp[i][j])
    				{
    					if(d+1>maxVal)
    					{
    						maxVal = d+1;
    						first = i;
    						tail = j;
    					}
    				}
    			}
    		}
    	}
    	return s.substring(first,tail+1);
    }
	
	
	
	
	
	//Solution 1: This is the basic solution but will not pass leetcode because it will pass the time limit for a very huge String.
	//The solution is to consider the two conditions separately
    public static String longestPalindrome(String s) 
    {
        if(s==null || s.length() <=1) return s;
        int length = s.length();
        String result = "";
        int maxVal = 0;
        int leftStart = -1;
        int rightEnd = -1;
        boolean flagodd;
        for(int i=1; i<=length-1; i++)
        {
            //Possibility 1
            flagodd = true;
            int countOdd = 1;
            while(i-countOdd>=0 && i+countOdd<s.length() && flagodd)
            {
                if(s.charAt(i-countOdd)==s.charAt(i+countOdd))
                {
                    countOdd++;
                }
                else
                {
                    flagodd = false;
                }
            }
            countOdd--;
            
            if((2*countOdd+1)>maxVal)
            {
                leftStart = i-countOdd;
                rightEnd = i+countOdd;
                maxVal = 2*countOdd+1;
            }
           
            //Possibility 2
            int countEven = 0;
            boolean flagEven = true;
            while(i-countEven-1>=0 && i+countEven<s.length() && flagEven)
            {
                if(s.charAt(i+countEven)==s.charAt(i-1-countEven))
                {
                 countEven++;
                }
                else
                {
                    flagEven = false;
                }
            }
            countEven--;
        
            if((2*countEven+2)>maxVal)
            {
                leftStart = i-countEven-1;
                rightEnd = i+countEven;
                maxVal = 2*countEven+2;
            }
        }
        
        StringBuilder res = new StringBuilder();
        
        for(int j=leftStart; j<=rightEnd; j++)
        {
            res.append(s.charAt(j));
        }
        return res.toString();
    }
	
	
}
