package leetcode251to300;

import java.util.ArrayList;
import java.util.List;

public class FlipGame_293 
{
    public List<String> generatePossibleNextMoves(String s) 
    {
        List<String> result = new ArrayList<String>();
        if(s==null || s.length()<2) return result;
        
        for(int i=0; i<s.length()-1; i++)
        {
            //if(s.charAt(i)=='+' && s.charAt(i+1)=='+')   sol 1
            //if(s.substring(i).startsWith("++"))          sol 2
            if(s.startsWith("++",i))
            {
                result.add(s.substring(0,i) + "--" + s.substring(i+2));
            }
        }
        return result;
    }
	

}
