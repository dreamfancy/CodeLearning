package leetcode300to350;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses_301 
{
    public List<String> removeInvalidParentheses(String s) 
    {
        List<String> result = new ArrayList<String>();
        //if(s==null || s.length()==0) return result;
        helper(result,s,0,0, new char[]{'(',')'});
        
        return result;
    }
    
    private void helper(List<String> res, String s, int last_i, int last_j, char[] pair)
    {
        int count = 0;
        for(int i=last_i; i<s.length(); i++)
        {
            if(s.charAt(i)==pair[0]) count++;
            if(s.charAt(i)==pair[1]) count--;
            if(count >=0) continue;
            for(int j=last_j; j<=i; j++)
            {
                if(s.charAt(j)==pair[1] && (j==last_j || s.charAt(j-1)!=pair[1]))
                {
                    helper(res, s.substring(0,j)+s.substring(j+1), i, j, pair);
                }
            }
            return;
        }
    
        String reversed = new StringBuilder(s).reverse().toString();
        if(pair[0]=='(')
        {
            helper(res,reversed,0, 0, new char[]{')','('});
        }
        else
        {
            res.add(reversed);
        }
    }
}
