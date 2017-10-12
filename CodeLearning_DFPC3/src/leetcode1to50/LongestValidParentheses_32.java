package leetcode1to50;

public class LongestValidParentheses_32 
{
	//Solution 1: My solution for loop check, time exceed limit but all test cases passed
    public int longestValidParentheses_1(String s) 
    {
        if(s==null || s.length()<=1) return 0;
        
        int n = s.length();
        int max = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)==')') continue;
            int left = 1; 
            int right = 0;
            int j=1;
            while(left>=right && (i+j)<n)
            {
                if(s.charAt(i+j)=='(') left++;
                else right++;
                if(left==right)
                {
                    max = Math.max(max,left+right);
                }
                j++;
            }
               
        }
        return max;
    }

}
