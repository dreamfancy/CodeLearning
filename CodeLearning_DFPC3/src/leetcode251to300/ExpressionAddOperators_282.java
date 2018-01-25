package leetcode251to300;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_282 
{
    public List<String> addOperators(String num, int target) 
    {
        List<String> result = new ArrayList<String>();
        if(num==null || num.length()==0) return result;
        if(num.length()==1)
        {
            if(target==(num.charAt(0)-'0'))
            {
                result.add(num);
            }
            return result;
        }
    
        processExpression(0,0,0,num,new StringBuilder(), target, result);
        
        return result;
    }
    
    private void processExpression(int cur, long cursum, long prenum, String str, StringBuilder cursol, int target, List<String> result)
    { 
        if(cur==str.length() && cursum==target)
        {
            result.add(cursol.toString());
            return;
        }
        if(cur>=str.length())
        {
            return;
        }
        
        long curnum = str.charAt(cur) - '0';
        
        //+
        if(cur==0)
        {
            /*
            cursol.append(curnum);
            processExpression(cur+1, cursum+curnum, curnum, str, cursol, target, result);
            cursol.setLength(cursol.length()-1);
            */
            
            for(int i=0; (i+cur)<str.length(); i++)
            {
                curnum = Long.parseLong(str.substring(cur,cur+i+1));
                cursol.append(curnum);
                processExpression(cur+1+i, cursum+curnum, curnum, str, cursol, target, result);
                cursol.setLength(cursol.length()-1-i);
                if(str.charAt(cur)=='0') break;
            }
            return;
        }
        else
        {
            /*
            cursol.append('+').append(curnum);
            processExpression(cur+1, cursum+curnum, curnum, str, cursol, target, result);
            cursol.setLength(cursol.length()-2);
            */
            
            for(int i=0; (i+cur)<str.length(); i++)
            {
                
                curnum = Long.parseLong(str.substring(cur,cur+i+1));
                cursol.append('+').append(curnum);
                processExpression(cur+1+i, cursum+curnum, curnum, str, cursol, target, result);
                cursol.setLength(cursol.length()-2-i);
                if(str.charAt(cur)=='0') break;
            }
        }
        
        //-
        /*
        cursol.append('-').append(curnum);
        processExpression(cur+1, cursum-curnum, -curnum, str, cursol, target, result);
        cursol.setLength(cursol.length()-2);
        */
        for(int i=0; (i+cur)<str.length(); i++)
        {
            curnum = Long.parseLong(str.substring(cur,cur+i+1));
            cursol.append('-').append(curnum);
            processExpression(cur+1+i, cursum-curnum, -curnum, str, cursol, target, result);
            cursol.setLength(cursol.length()-2-i);
            if(str.charAt(cur)=='0') break;

        }
        
        //*
        /*
        cursol.append('*').append(curnum);
        processExpression(cur+1,cursum-prenum + prenum*curnum, prenum*curnum, str, cursol, target, result);
        cursol.setLength(cursol.length()-2);
        */
        
        for(int i=0; (i+cur)<str.length(); i++)
        {    
            curnum = Long.parseLong(str.substring(cur,cur+i+1));
            cursol.append('*').append(curnum);
            processExpression(cur+1+i,cursum-prenum + prenum*curnum, prenum*curnum, str, cursol, target, result);
            cursol.setLength(cursol.length()-2-i);
            if(str.charAt(cur)=='0') break;

        }   
    }

}
