package string;

public class RemoveLeadingTrailingAndDuplicateSpaceWithOneRemaining 
{
	
	//What if all the words are spaces!!!
	
	//check using the rule below:
	// char[fast]=='' && (fast==0 || char[fast-1]=='')
	
	//Lecture Solution
	public String removeSpaces(String s)
	{
		if(s==null || s.length()==0) return s;
		char[] chars = s.toCharArray();
		int slow = 0;
		for(int fast=0; fast<chars.length; fast++)
		{
			if(!(chars[fast]==' ' && (fast==0 || chars[fast-1] ==' ' )))
			{
				chars[slow++] = chars[fast];
			}
		}
		if(slow==0) return " ";
		return chars[slow-1]==' ' ? new String(chars,0,slow-1) : new String(chars,0,slow);
		
	} 
	
	//Solution 2: leave the space before word
	//When it can be skipped
	//char[fast]==' ' && ((fast<chars.length-1) ||char[fast+1]==' ')
	//check index 0 if it is space return new String(array,1,slow-1)
	//                        else return new String(array,0,slow)
	
	
	
	//My solution:
	public String removeSpaces_1(String s)
	{
		char[] charArr = s.toCharArray();
		int j=0;
		//boolean flag = false;
		for(int i=0; i<s.length();i++)
		{
			if(charArr[i]!=' ')
			{
				charArr[j] = charArr[i];
				j++;
			}
			else if(i>=1 && charArr[i]==' ' && charArr[i-1]!=' ')
			{
				charArr[j] = ' ';
				j++;
			}
		} 
		
		if(charArr[j-1]==' ') j--;
		 
		return new String(charArr,0,j);	 
	}

}
