package first100;

public class PalindromeNumber_9 
{
	//Solution 2: bit operation
    public boolean isPalindrome_2(int x) {
        if(x<0||(x>0&&x%10==0)) return false;
        int reverse=0;
        while(x>reverse){
            reverse=reverse*10+x%10;//Revisit!
            x/=10;
        }
        return x==reverse||x==reverse/10;
    }
	
	
	
	//My Solution : Integer to String
    public boolean isPalindrome_1(int x) {
    	
        String s = Integer.toString(x);
        int len = s.length();
        if(len<=1) return true;
    
        int left = 0;
        int right = len-1;
        while(left<right)
        {
            if(s.charAt(left)==s.charAt(right))
            {
            	left++;
            	right--;
                continue;
            }
            return false;
        }
        return true;   
    }

}
