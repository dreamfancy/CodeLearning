package string;

public class RemoveLeadingTrailingAndDuplicateSpaceWithOneRemaining 
{
	
	//What if all the words are spaces!!!
	
	//check using the rule below:
	// char[fast]=='' && (fast==0 || char[fast-1]=='')
	public String removeSpaces(String s)
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
