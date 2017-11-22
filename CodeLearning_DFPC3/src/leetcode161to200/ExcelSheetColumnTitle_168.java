package leetcode161to200;

public class ExcelSheetColumnTitle_168 
{
    public String convertToTitle(int n)
    {
    	if(n<=0) return "";
    	StringBuilder sb = new StringBuilder();
        
        while(n>0)
        {
        	n--;
            int cur = n%26;
            sb.append((char)('A'+cur));
            n = (n-cur)/26;
        }
        return sb.toString();
    }
	

}
