package string;

public class ImplementstrStr_28 {

	
	//Solution 2:
	
	public int subString(String s1, String s2)
	{
		if(s1==null || s1.length()==0 || s2==null || s2.length()==0) return -1;
		
		if(s2.length()>s1.length()) return subString(s2,s1);
		
		for(int i=0; i<s1.length(); i++)
		{
			int j;
			for(j=0; j<s1.length()-s2.length(); j++)//i does not need to i.length
			{
				if(s1.charAt(i+j)!=s2.charAt(j)) break;
			}
			if(j==s2.length()) return i;
		}
		return -1;
	}
	
	
	//Solution 1: i++ j++, attention the break or continue will only jump out /in the most inner while loop
 
}
