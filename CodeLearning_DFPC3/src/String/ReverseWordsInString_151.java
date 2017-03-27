package String;

public class ReverseWordsInString_151 {

//Note: StringBuilder has the method of: deleteCharAt()	
	
    public String reverseWords(String s) {

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
