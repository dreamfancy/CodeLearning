package string;

public class ReverseWordsInString_151 {

//Note: StringBuilder has the method of: deleteCharAt()	
	
	//How many space???
	//Consider remove space question
	
	public String reverseWords_2(String s) {

    	if(s == null || s.length() == 0) return s;
    	
    	s = removeSpaces(s);
    	String[] arr = s.split(" ");
    	if(arr.length==1) return s;
    	
    	int i=0;
    	int j=arr.length-1;
    	
    	while(i<j)
    	{
    		swap(arr,i++,j--);
    	}
    	
    	StringBuilder res = new StringBuilder();
    	for(int k=0; k<arr.length; k++)
    	{
    		res.append(arr[k]);
    	}
    	return res.toString();
    }
	
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
	
	private void swap(String[] arr, int i, int j)
	{
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	//Old Solution: Traverse from the end of array
    public String reverseWords_1(String s) {

    	if(s == null || s.length() == 0) return s;
    	String[] arr = s.split(" ");
    	if(arr.length==1) return s;
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=arr.length-1; i>=0; i--)
    	{
    		if(arr[i].length()>=1)
    		sb.append(arr[i]).append(" ");
    	}
    	if(sb.length()>1)
    	sb.setLength(sb.length()-1);
    
    	return sb.toString();
    }
	
}  
