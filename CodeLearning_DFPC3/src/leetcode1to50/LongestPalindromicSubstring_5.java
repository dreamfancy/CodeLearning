package leetcode1to50;

public class LongestPalindromicSubstring_5 
{
	//str.substring(1); All "substring" are lower case
	
	
	//My solution 
	//very slow according to leetcode result
	
    public String longestPalindrome(String s) 
    {    
        if(s==null || s.length()<=1) return s;
        
        int max = 1;
        int start = 0;
        int end = 0;
        
        for(int i=1; i<s.length()-1;i++)
        {
            int count=1;
            int j=1;
            while((i-j)>=0 && (i+j)<=(s.length()-1))
            {
                if(s.charAt(i-j)==s.charAt(i+j))
                {
                    count +=2;
                }
                else
                {
                    break;
                }
                j++;
            }
            j--;
            if(count>max)
            {
                max = count;
                System.out.println(count);
                start = i-j;
                end = i+j;
            }
        }
        
        for(int i=0; i<s.length()-1;i++)
        {
            int count=0;
            int j=0;
            while((i-j)>=0 && (i+1+j)<=(s.length()-1))
            {
                if(s.charAt(i-j)==s.charAt(i+j+1))
                {
                    count +=2;
                }
                else
                {
                    break;
                }
                j++;
            }
            j--;
            if(count>max)
            {
                max = count;
                start = i-j;
                end = i+j+1;
            }
        }
        return s.substring(start,end+1);
    }

}
