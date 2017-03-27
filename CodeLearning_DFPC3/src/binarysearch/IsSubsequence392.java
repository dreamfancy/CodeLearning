package binarysearch;

public class IsSubsequence392 {

	public boolean isSubsequence_1(String s, String t)
	{
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		int i=0,j=0;
		while(j!=ct.length || i!=cs.length)
		{
			if(cs[i]==ct[j])
			{
				i++;
				j++;
			}
			else
			{
				j++;
			}
		}
		if(i==cs.length)
			return true;
		return false;
	}
	/*
	public boolean isSubsequence(String s, String t)
	{
		int slength = s.length();
		int tlength = t.length();
		
		
		return false;
	}
	
	*/
}
