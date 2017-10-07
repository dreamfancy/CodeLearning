package leetcode1to50;

public class PalindromeNumber_9 
{
	//My Solution Best solution
    public boolean isPalindrome(int x) 
    {
        if(x>=0 && x<=9) return true;
        if(x<0) return false;
        
        long mir = 0;
        int div = x;
        while(div!=0)
        {
            mir = mir*10;
            mir += div%10;
            if(mir>Integer.MAX_VALUE) return false;
            div = div/10;
        }
        if((int)mir==x) return true;
        
        return false;
    }

}
