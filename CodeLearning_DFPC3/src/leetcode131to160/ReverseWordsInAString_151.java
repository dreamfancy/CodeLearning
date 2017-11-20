package leetcode131to160;

public class ReverseWordsInAString_151 {
	
	//Sol 2: Without trim() without split
	public String reverseWords_purecode(String s)
	{
		if(s==null) return null;
		char[] arr = s.toCharArray();
		int n = arr.length;
		
		reverse(arr,0,n-1);
		reverseWords(arr,n);
		return cleanSpaces(arr,n);
	}
	
	//Revisit!!! greedy to reverse the words
	public void reverseWords(char[] a, int n)
	{
		int i=0, j=0;
		while(i<n)
		{
			while(i<j || i<n && a[i]==' ') i++;
			while(j<i || j<n && a[j]!=' ') j++;
			reverse(a,i,j-1);
		}
	}
	
	public String cleanSpaces(char[] a, int n)
	{
		int i=0,j=0;
		while(j<n)
		{
			while(j<n && a[j]==' ') j++;
			while(j<n && a[j]!=' ') a[i++] = a[j++];
			while(j<n && a[j]==' ') j++;
			if(j<n) a[i++] = ' ';
		}
		return new String(a).substring(0,i);
	}
	
	  private void reverse(char[] a, int i, int j) {
		    while (i < j) {
		      char t = a[i];
		      a[i++] = a[j];
		      a[j--] = t;
		    }
	  }
	//My Sol :
    public String reverseWords_usefunc(String s) {
        if(s==null || s.length()==0) return s;
        String strim = s.trim();
        if(strim.length()==0) return "";
        String[] arr = strim.split(" ");
        int size = arr.length;
        if(size==0) return "";
        if(size==1) return strim;
        
        StringBuilder sb = new StringBuilder(arr[size-1]);
        for(int i=size-2; i>=0; i--)
        {
            if(arr[i].equals("")) continue;
            sb.append(" ").append(arr[i]);
        }
        return sb.toString();
    }
}
