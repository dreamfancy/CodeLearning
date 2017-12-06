package leetcode201to250;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthese_241 
{
    public List<Integer> diffWaysToCompute(String input) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if(input==null || input.length()==0) return result;
        int len = input.length();
        for(int i=0; i<len; i++)
        {
            char oper = input.charAt(i);
            if(!Character.isDigit(oper))
            {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,len));
                for(Integer i1: left)
                {
                    for(Integer i2: right)
                    {
                        if(oper=='+')
                            result.add(i1+i2);
                        else if(oper=='-')
                            result.add(i1-i2);
                        else if(oper=='*')
                            result.add(i1*i2);
                    }
                }
            }
        }
        if(result.size()==0) result.add(Integer.parseInt(input));
        return result;
    }

}
