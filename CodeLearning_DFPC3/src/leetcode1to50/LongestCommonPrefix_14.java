package leetcode1to50;

public class LongestCommonPrefix_14 
{
	//Solution 4: Divide and Conquer
	public String longestCommonPrefix_4(String[] strs) 
	{
		if(strs==null || strs.length==0) return "";
		if(strs.length==1) return strs[0];
        
        return divideAndConquer(strs,0,strs.length-1);        
	}
    
    public String divideAndConquer(String[] strs, int first, int last)
    {
        if(first == last) return strs[first];
        int mid = first+ (last-first)/2;
        String prefix1 = divideAndConquer(strs,first,mid);
		String prefix2 = divideAndConquer(strs,mid+1,last);	    
        if(prefix1.length()==0 || prefix2.length()==0) return "";
        return commonPrefix(prefix1,prefix2);
    }
    
    public String commonPrefix(String s1,String s2) {
    {
        int i=0;
        while(i<s1.length() && i<s2.length())
        {
            if(s1.charAt(i)==s2.charAt(i))
                i++;
            else break;
        }
        if(i==0) return "";
        return s1.substring(0,i);   
    }
    
    /*
    public String commonPrefix(String left,String right) {
    int min = Math.min(left.length(), right.length());       
    for (int i = 0; i < min; i++) {
        if ( left.charAt(i) != right.charAt(i) )
            return left.substring(0, i);
    }
    return left.substring(0, min);
    */
}
	
	//Solution 3: Binary Search
	public String longestCommonPrefix_3(String[] strs) 
	{
		if(strs==null || strs.length==0) return "";
        
		int minlen = Integer.MAX_VALUE;
		for(String str: strs)   //For: java 8 can used by array
		{
			minlen = Math.min(minlen, str.length());
		}
		
        System.out.println("minlen is " + minlen);
        
        if(minlen==0) return "";
        
		int low = 1;
		int high = minlen;
		while(low<high-1)
		{
			int mid = low + (high-low)/2;
			if(isCommonPrefix(strs,mid))
			{
				low = mid;  //flexible here!!!
			}
			else
			{
				high = mid - 1; 
			}
		}
		
		if(isCommonPrefix(strs,high)==true) return strs[0].substring(0, high);
		else if (isCommonPrefix(strs,low)==true) return strs[0].substring(0, low);
        else return "";
	}
	
	public boolean isCommonPrefix(String[] strs, int mid)
	{
		String pattern = strs[0].substring(0, mid);
		for(String s: strs)
		{
			if(s.indexOf(pattern)!=0) return false;
		}
        
        System.out.println("isCommonPrefix return true here when mid is" + mid);
		return true;
	}
	
	
	
	
	
	//Solution 2: Think prefix from max to min to reduce the time
	public String longestCommonPrefix_my2(String[] strs) 
	{
		if(strs==null || strs.length==0) return "";
        int len = strs.length;
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++)
        {
        	while(strs[i].indexOf(prefix)!=0)
        	{
        		prefix = prefix.substring(0,prefix.length()-1);
        		if(prefix.isEmpty()) return "";
        	}
        }
        
        return prefix;
		
	}
	
	//My Solution 1: for loop cur++ with flag
    public String longestCommonPrefix_my1(String[] strs) 
    {
        if(strs==null || strs.length==0) return "";
        int len = strs.length;
        int cur = 0;
        boolean flag = true;
        while(flag==true)
        {
            if(cur>=strs[0].length()) 
            {
                flag = false;
                break;
            }
            char curChar = strs[0].charAt(cur);
            
            for(int i=1; i<len; i++)
            {
                if(cur>=strs[i].length() || strs[i].charAt(cur)!=curChar)
                {
                    flag = false;
                    cur--;
                    break;
                }
            }
            cur++;
        }
        if(cur==0) return "";
        return strs[0].substring(0,cur);        
    }

}
