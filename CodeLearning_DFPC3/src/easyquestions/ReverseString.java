//Char cannot char.toString()
//However we should use String.valueOf(char[])
package easyquestions;

public class ReverseString {
	
    public static String reverseString(String s) {
        if(s == null) return null;
        if(s.length() == 0) return "";
    
        char[] str = s.toCharArray();
        int i=0, j=str.length-1;
        while(i<j)
        {
        	str = swap(str,i,j);
        	i++;
        	j--;
        }
        
        return String.valueOf(str);
    }
    
    public static char[] swap(char[] str, int i, int j)
    {
    	char temp = str[i];
    	str[i] = str[j];
    	str[j] = temp;
    	return str;
    }
    /*
    public static void main(String[] args)
    {
    	System.out.println(reverseString("helloa"));
    }
     */
}
