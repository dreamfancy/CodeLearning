package bitoperation;

public class changeNumberTo0x 
{
	static char[] hexSymbol = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e'};
	
	public String toHex(int n)
	{
		if(n==0) return "0";
		StringBuilder sb = new StringBuilder();
		while(n>0)
		{
			int cur = n%16;
			sb.append(hexSymbol[cur]);
			n = n/16;
		}
		sb = sb.reverse();
		
		return "0x" + sb.toString();
	}

}
