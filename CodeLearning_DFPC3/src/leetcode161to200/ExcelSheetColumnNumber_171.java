package leetcode161to200;

public class ExcelSheetColumnNumber_171 
{
    public int titleToNumber(String s) 
    {
        if(s==null || s.length()==0) return 0;
        
        int result = 0;
        for(int i=0; i<s.length(); i++)
        {
            result *= 26;
            result += s.charAt(i)-'A'+1;
        }
        return result;
    }

}
