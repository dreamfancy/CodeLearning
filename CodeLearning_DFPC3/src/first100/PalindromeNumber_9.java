package first100;

public class PalindromeNumber_9 
{
    public boolean isPalindrome(int x) {
    	
        String s = Integer.toString(x);
        int len = s.length();
        if(len<=1) return true;
    
        int left = 0;
        int right = len-1;
        while(left<right)
        {
            if(s.charAt(left)==s.charAt(right))
            {
                continue;
            }
            return false;
        }
        return true;   
    }

}
