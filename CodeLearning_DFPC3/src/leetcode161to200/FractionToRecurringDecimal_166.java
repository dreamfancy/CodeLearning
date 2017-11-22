package leetcode161to200;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal_166 
{
    public String fractionToDecimal(int numerator, int denominator) 
    {
        if(denominator==0) return "";    
        if(numerator==0) return "0";
        StringBuilder result = new StringBuilder();
        
        result.append( (numerator>0)^(denominator>0) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        result.append(num/den);
        num = num%den;
        if(num==0) return result.toString();
        
        result.append(".");
        
        Map<Long,Integer> hash = new HashMap<Long,Integer>();
        hash.put(num, result.length());
        while(num!=0)
        {
            num = num*10;
            result.append(num/den);
            num = num%den;
            if(hash.containsKey(num))
            {
                result.insert(hash.get(num),"(");
                result.append(")");
                return result.toString();
            }
            else 
            {
                hash.put(num,result.length());
            }
        }
        
        return result.toString();
        
    }

}
