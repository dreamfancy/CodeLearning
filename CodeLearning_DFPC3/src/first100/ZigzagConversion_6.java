package first100;

public class ZigzagConversion_6 
{
	//Use StringBuilder[] array for levels
    public String convert(String s, int numRows) 
    {
    	if(s==null ||s.length()==0 || numRows<=1) return s;
    	char[] c = s.toCharArray();
    	
    	StringBuilder[] sb = new StringBuilder[numRows];
    	for(int i=0; i<sb.length; i++)
    	{
    		sb[i] = new StringBuilder();
    	}
    	
    	int i=0;
    	while(i<s.length())
    	{
    		for(int j=0; j<numRows && i<s.length();j++)
    		{
    			sb[j].append(c[i++]);
    		}
    		for(int k=numRows-2; k>=1 && i<s.length(); k--)
    		{
    			sb[k].append(c[i++]);
    		}
    	}
    	for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
