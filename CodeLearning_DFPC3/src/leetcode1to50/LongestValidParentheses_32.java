package leetcode1to50;

import java.util.Stack;

public class LongestValidParentheses_32 
{
	//Official Solution 3: Trick
	//Scan from left to right one time, then scan from right to left one time
    public int longestValidParentheses_Trick(String s)
    {
    	if(s==null || s.length()<=1) return 0;
    	int max = 0;
    	int left = 0; int right = 0;
    	for(int i=0; i<s.length(); i++)
    	{
    		if(s.charAt(i)=='(') left++;
    		else right++;
    		if(right>left)
    		{
    			left = 0; 
    			right = 0;
    		}
    		if(left==right)
    			max = Math.max(left+right, max);
    	}
    	
    	left = 0; 
    	right = 0;
    	for(int i=s.length()-1; i>=0; i--)
    	{
    		if(s.charAt(i)=='(') left++;
    		else right++;
    		if(left>right)
    		{
    			left = 0; 
    			right = 0;
    		}
    		if(left==right)
    			max = Math.max(left+right, max);
    	}
    	
    	return max;
    }
	
	//Official Solution 2: Stack
    public int longestValidParentheses_Stack(String s)
    {
    	if(s==null || s.length()<=1) return 0;
    	int max = 0;
    	Stack<Integer> st = new Stack<Integer>();
    	st.push(-1);
    	for(int i=0; i<s.length(); i++)
    	{
    		if(s.charAt(i)=='(')
    		{
    			st.push(i);
    		}
    		else
    		{
    			
    			if(st.isEmpty())
    			{
    				st.push(i);
    			}
    			else
    			max = Math.max(max, i-st.peek());
    		}
    	}
    	return max;
    }
	
	//Official Solution 1: DP
	//DP represents the length of the longest valid substring ENDING AT ith index!
    public int longestValidParentheses_DP(String s)
    {
    	if(s==null || s.length()<=1) return 0;
    	int max = 0;
    	int[] dp = new int[s.length()];
    	dp[0] = 0;
    	dp[1] = 0;
    	if(s.length()>=2 && s.charAt(0)=='(' && s.charAt(1)==')')
    	{
    		dp[1] = 2;
    		max = 2;
    	}
    	
    	for(int i=2; i<s.length(); i++)
    	{
    		if(s.charAt(i-1)=='(' && s.charAt(i)==')')
    		{
    			dp[i] = dp[i-2]+2;
    		}
    		if(dp[i-1]!=0 && s.charAt(i)==')' && (i-dp[i-1]-1>=0) && s.charAt(i-dp[i-1]-1)=='(')
    		{
                if(i-dp[i-1]-2>=0)
    			    dp[i] = Math.max(dp[i], 2+dp[i-1]+dp[i-dp[i-1]-2]);
                else
                    dp[i] = Math.max(dp[i], 2+dp[i-1]);

    		}
    		max = Math.max(dp[i], max);
    	}
    	return max;
    }
	
	//My Solution 2: DP
	//My DP Solution: 110/229 cases passed. It cannot cover ((()))((())) scenario
	//The transfer function does not cover all
    public int longestValidParentheses_2(String s) 
    {
        if(s==null || s.length()<=1) return 0;
        
        int n = s.length();
        int max = 0;
        
        boolean[][] dp = new boolean[n][n];
        boolean flag =false;
        for(int i=0; i<n-1; i++)
        {
            if(s.charAt(i)=='(' && s.charAt(i+1)==')')
            {
                dp[i][i+1] = true;
                flag = true;
            }
        }
        if(flag==false) return 0;
        
        for(int j=4; j<n;j=j+2)
        {
            flag = false;
            for(int i=0; i<=(n-j);i++)
            {
                if(dp[i][i+j-3]==true && s.charAt(i+j-2)=='(' && s.charAt(i+j-1)==')')
                {
                    dp[i][i+j-1] = true;
                    flag = true;
                    continue;
                }
                
                if(dp[i+2][i+j-1]==true && s.charAt(i)=='(' && s.charAt(i+1)==')')
                {
                    dp[i][i+j-1] = true;
                    flag = true;
                    continue;

                }
                
                if(dp[i+1][i+j-2]==true && s.charAt(i)=='(' && s.charAt(i+j-1)==')')
                {
                    dp[i][i+j-1] = true;
                    flag = true;
                }
            }
            if(flag==false) return j-2;
        }
        return n-n%2;
        
    }
	//My Solution 1: My solution for loop check, time exceed limit but all test cases passed
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
