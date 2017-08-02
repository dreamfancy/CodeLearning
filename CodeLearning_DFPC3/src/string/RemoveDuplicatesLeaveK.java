package string;

public class RemoveDuplicatesLeaveK{

	public String removeDuplicatesLeaveK(String s, int k)
	{
		if(s==null || s.length()<=k) return s;
		
		char[] chars = s.toCharArray();
		
		int slow = k;
		for(int fast=k; fast<s.length();fast++)
		{
			if(chars[fast]!=chars[fast-k])
			{
				chars[slow++] = chars[fast];
			}
		}
		
		return new String(chars,0,slow-1);
	}
}
