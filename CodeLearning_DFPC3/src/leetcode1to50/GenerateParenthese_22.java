package leetcode1to50;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese_22 
{
	//My Solution: best solution
    public List<String> generateParenthesis(int n) {
    	   
        List<String> result = new ArrayList<String>();
        if(n<=0) return result;
        
        StringBuilder sb = new StringBuilder();
        
        dfs(n,n,sb,result);
        
        return result;
    }
    
    public void dfs(int left, int right, StringBuilder sb, List<String> result)
    {
        if(left==0 && right ==0)
        {
            result.add(sb.toString());
            return;
        }
        if(left>0)
        {
            sb.append("(");
            dfs(left-1,right,sb,result);
            sb.deleteCharAt(sb.length()-1);
        
        }
        if(left<right)
        {
            sb.append(")");
            dfs(left,right-1,sb,result);
            //sb.deleteCharAt(sb.length()-1);
            sb.setLength(sb.length()-1); //Same: Two approaches to delete the last element of StringBuilder
        }
    }

}
