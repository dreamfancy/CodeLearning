package first100;

public class LongestCommonPrefix_14 
{
	//Solution 1: Horizontal
	//Use str.indexOf(subString)?== 0 to judge
	//Good thing: O(n) time and O(1) space??? from leetcode official solution
    public String longestCommonPrefix_1(String[] strs) 
    {
    	if(strs==null || strs.length==0) return "";
    	if(strs.length==1) return strs[0];
    	
    	String prefix = strs[0];
    	for(int i=1; i<strs.length; i++)
    	{
    		while(strs[i].indexOf(prefix)!=0)
    		{
    			prefix = prefix.substring(0,prefix.length()-1);
    			if(prefix=="") return "";
    		}
    	}
    	return prefix;
    }
    
    //Solution 2: Vertical
    public String longestCommonPrefix_2(String[] strs) 
    {
    	if(strs==null || strs.length==0) return "";
    	if(strs.length==1) return strs[0];
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<strs[0].length(); i++)
    	{
    		char c = strs[0].charAt(i);
    		for(int j=1; j<strs.length; j++)
    		{
    			if(i==strs[j].length() || strs[j].charAt(i)!= c) return sb.toString();
    		}
    		sb.append(c);
    	}
    	return sb.toString();
    }
    
    //Solution 3: Divide and Conquer
    public String longestCommonPrefix_3(String[] strs)
    {
    	if(strs==null || strs.length==0) return "";
    	if(strs.length==1) return strs[0];
    	
    	return divideAndConquer(strs,0,strs.length-1);
    }
    
    public String divideAndConquer(String[] strs, int left, int right)
    {
    	if(left>right) return "";
    	if(left==right) return strs[left];
    	int mid = left + (right-left)/2;
    	
    	String s1 = divideAndConquer(strs,left,mid);
    	String s2 = divideAndConquer(strs,mid+1,right);
    	return merge(s1,s2);
    }
    
    public String merge(String left, String right)
    {
    	int min = Math.min(left.length(), right.length());
    	
    	for(int i=0; i<min; i++)
    	{
    		if(left.charAt(i)!=right.charAt(i))
    		{
    			return left.substring(0,i);
    		}
    	}
    	return left.substring(0,min);
    }
    
    //Solution 4: Binary Search
    //Divide And Conquer is to generate results from groups
    //Binary search is to use YES or NO boolean value to shrink the scope
    public String longestCommonPrefix_4(String[] strs)
    {
    	if(strs==null || strs.length==0) return "";
    	if(strs.length==1) return strs[0];
    	
    	int minLen = Integer.MAX_VALUE;
    	int size = strs.length;
    	
    	for(String s: strs)
    	{
    		minLen = Math.min(minLen, s.length());
    	}
    	
    	int low = 1;
    	int high = minLen;
    	
    	while(low<=high)
    	{
    		int mid = low + (high-low)/2;
    		if(isCommonPrefix(strs,mid))
    		{
    			low = mid+1;
    		}
    		else
    		{
    			high = mid-1;
    		}
    	}	
    		
    	return strs[0].substring(0,low+(high-low)/2);
    			
    }
    
    private boolean isCommonPrefix(String[] strs, int len)
    {
    	String s = strs[0].substring(0, len);
    	for(int i=1; i<strs.length; i++)
    	{
    		if(!strs[i].startsWith(s)) return false;
    	}
    	return true;
    }

    //Remember API" str1.startsWith(subString);

}
