package tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) 
    {
    	List<String> result = new ArrayList<String>();
    	if(n<=0) return result;
    	StringBuilder sb = new StringBuilder();
    	return helper(n,0,0,sb,result);
    }
    
    private List<String> helper(int n, int curL, int curR, StringBuilder sb, List<String> res)
    {
    	if(curL + curR == n*2)
    	{
    		res.add(sb.toString());
    		return res;
    	}
    	if(curL<n)
    	{
    		sb.append("(");
    		res = helper(n,curL+1,curR,sb,res);
    		sb.deleteCharAt(sb.length()-1);  
    		//sb.setLength(sb.length()-1);
    	}
    	if(curL>curR)
    	{
    		//sb.append("(");
    		//res = helper(n,curL+1,curR,sb,res);
    		sb.append(")");
    		res = helper(n,curL,curR+1,sb,res);
    		sb.deleteCharAt(sb.length()-1);  //It is necessary!!!
    		//Attention because of using recursion, we should always make it clean even in the last step in the method
    		//The sb is used across all the recursion levels. 
    	}
    	return res;
    }

}
