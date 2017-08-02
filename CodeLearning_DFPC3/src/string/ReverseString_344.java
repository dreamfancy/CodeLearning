package string;

public class ReverseString_344 
{
	//Solution 2: Recursion
	public String reverseString_recur(String s) 
    {
		if(s==null || s.length()<=1) return s;
		char[] array = s.toCharArray();   
		array = helper_1(array,0,array.length-1);
		return new String(array,0,s.length()-1);
    }
	
	private char[] helper_1(char[] array,int start,int end)
	{
		if(start>=end) return array;
		swap(array,start,end);
		return helper_1(array,start++,end--);
	}
	
	private char[] helper_2(char[] array,int start,int end)
	{
		if(start>=end) return array;
		//Wrong!!!helper_2(array,start++,end--);
		helper_2(array,start+1,end-1);
		swap(array,start,end);
		return array;
	}
	
    private void swap(char[] arr, int i, int j)
    {
    	char temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
	//My Solution: Iteration
    public String reverseString_iter(String s) 
    {
    	if(s==null || s.length()<=1) return s;
    	char[] array = s.toCharArray();
    	int i = 0;
    	int j = s.length()-1;
    	
    	while(i<j)
    	{
    		swap(array,i++,j--);
    	}	
    	return new String(array);
    }
}
