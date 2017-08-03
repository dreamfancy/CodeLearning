package string;

public class RotateStringByOffset {

	public String rotateStringByOffset(String s, int offset)
	{
		if(s==null || s.length()==0) return s;
		
		char[] str = s.toCharArray();
		
		offset = offset % str.length;
		
		reverse(str,0,str.length-1);
		reverse(str,0,offset-1);
		reverse(str,offset,str.length-1);
		
		return new String(str);
	}
	
	private void reverse(char[] str, int i, int j)
	{
		while(i<j)
			swap(str,i,j);
	}
	
	private void swap(char[] str, int i, int j)
	{
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
	
	
}
