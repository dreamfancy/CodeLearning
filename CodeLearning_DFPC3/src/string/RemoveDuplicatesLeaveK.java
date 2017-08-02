package string;

public class RemoveDuplicatesLeaveK{
    
	//Solution 1: Lecture Solution
	//assign slow then++,result is [0,slow) 
	public String removeDuplicatesLeaveK(String s, int k)
	{
		if(s==null || s.length()<=k) return s;
		
		char[] chars = s.toCharArray();
		
		int slow = k;
		for(int fast=k; fast<s.length();fast ++)
		{
			if(chars[fast]!=chars[slow -k])
			{
				chars[slow++] = chars[fast];
			}
		}
		
		return new String(chars,0,slow);
	}
	
		//Solution 2: Lecture Solution
		//slow++ then assign,result is [0,slow] 
		public String removeDuplicatesLeaveK_2(String s, int k)
		{
			if(s==null || s.length()<=k) return s;
			char[] chars = s.toCharArray();
			int slow = k-1;
			for(int fast=k-1; fast<chars.length; fast++)
			{
				if(chars[fast]!= chars[slow-k+1])
				chars[++slow] = chars[fast];
			}
			
			return new String(chars,0,slow+1);
			
		}
}
