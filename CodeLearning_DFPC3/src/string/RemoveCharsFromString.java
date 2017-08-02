package string;

public class RemoveCharsFromString {

	//Solution 1: Slow Fast Pointer, In place operation
	//assign
	//[0,s) solution so far
	//[s,f)i don't care
	//[f,array.length-1] to explore
	//return [0,s) new String(chars,0,s)
	//How to make charArray back to String:
	//1 new String(chars,startIndex,length);
	//2 String str = String.valueOf(chars)
	//3 s.subString(startIndex,endIndex);  //[startIndex,endIndex)
	
	public String removeCharsFromString_1(String s, char t)
	{
		if(s==null ||s.length()==0) return new String();
		char[] charArr = s.toCharArray();
		
		int j=0;
		for(int i=0; i<charArr.length; i++)
		{
			if(charArr[i]!='t' && i!=j)
			{
				charArr[j] = charArr[i];
				j++;//there is a j++ at the end,so the last j should not be included
			}
		}
		//Attention and remember!!!
		 return new String(charArr,0,j);//zuobiyoukai
		 
		 //or  !!!Attention
		 //return String.valueOf(charArr).substring(0,j);
	}
	 
	//Cannot use swap because order needs to be kept!!!
	
	  
	
}
