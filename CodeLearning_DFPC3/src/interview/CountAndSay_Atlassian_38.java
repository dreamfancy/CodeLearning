package interview;

public class CountAndSay_Atlassian_38 
{
	//Solution 1: My Iteration. Use for loop, fast//DP
	public String countAndSay_Iteration(int n)
	{
		if(n<=0) return null;
		if(n==1) return "1";

		String cur = "1";
		for(int i=2; i<=n; i++)
		{
			StringBuilder sb = new StringBuilder();
			char[] curArray = cur.toCharArray();
			int count = 0;
			char curVal = curArray[0];
			for(int j=0; j<curArray.length; j++)
			{
				if(curArray[j]==curVal)
				{
					count++;
				}
				else
				{
					sb.append(count).append(curArray[j-1]);
					curVal = curArray[j];
					count = 1;
				}
			}
		
			sb.append(count).append(curArray[curArray.length-1]); //The last char anyways should be processed separately
			cur = sb.toString();
		}
		return cur;
	}
	//Solution 2: Recursion
	public String countAndSay_Recursion(int n)
	{
		if(n<=0) return null;
		if(n==1) return "1";
		
		char[] charArray = countAndSay_Recursion(n-1).toCharArray();
		StringBuilder sb = new StringBuilder();

		int count = 0;
		char curVal = charArray[0];
		
		for(int i=0; i<charArray.length; i++)
		{
			if(charArray[i]==curVal)
			{
				count++;
			}
			else
			{
				sb.append(count).append(charArray[i-1]);
				curVal = charArray[i];
				count = 1;
			}
		}		
		sb.append(count).append(charArray[charArray.length-1]);
		
		
		return sb.toString();
		
	}

	
	
	
	

 
}
