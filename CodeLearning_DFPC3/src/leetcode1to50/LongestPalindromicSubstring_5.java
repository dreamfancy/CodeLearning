package leetcode1to50;

public class LongestPalindromicSubstring_5 
{
	//str.substring(1); All "substring" are lower case
	
	
	//Optimized official solution:
	//use result[] array to keep the three value needed for result: max, start, end
	// Process the result in sub method to avoid discuss i,i  i,i+1 two different situation
    public String longestPalindrome_2(String s) 
    {    
        if(s==null || s.length()<=1) return s;
        
        int[] result = {1,0,0}; //result[0]: max; result[1]:start; result[2]: end;
        int start = 0;
        int end = 0;
        
        for(int i=0; i<s.length()-1;i++)
        {
            helper(s,i,i,result);
            helper(s,i,i+1,result);
        }
        
        return s.substring(result[1],result[2]+1);
            
    }
    
    public void helper(String s, int left, int right, int[] result)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        int cur = right-left-1;
        if(cur>result[0])
        {
            result[0] = cur;
            result[1] = left+1;
            result[2] = right-1;
        }
    }
	
	
	
	
	//Official Solution(not best)
	//Two models traversed in one loop!!!
    public String longestPalindrome_1(String s) 
    {    
        if(s==null || s.length()<=1) return s;
        
        int max = 1;
        int start = 0;
        int end = 0;
        
        for(int i=0; i<s.length()-1;i++)
        {
            int len1 = helper(s,i,i);
            int len2 = helper(s,i,i+1);
            int len = Math.max(len1,len2);
            
            if(len>max)
            {
                max = len;
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        
        return s.substring(start,end+1);
            
    }
    
    public int helper(String s, int left, int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        return right-left-1;
    }
	
	
	//My solution 
	//very slow according to leetcode result
	//Reason: two for loop is similar, need to consider code reuse
	
    public String longestPalindrome_my(String s) 
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
