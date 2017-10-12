package leetcode1to50;

public class ImplementstrStr_28 
{
	
	//Offical Solution
	public int strStr_2(String haystack, String needle) {
		  for (int i = 0; ; i++) {
		    for (int j = 0; ; j++) {
		      if (j == needle.length()) return i;
		      if (i + j == haystack.length()) return -1;
		      if (needle.charAt(j) != haystack.charAt(i + j)) break;
		    }
		  }
		}
	
	
    public int strStr_1(String haystack, String needle) 
    {
        if(haystack==null || needle==null) return -1;
        if(needle.length()==0) return 0;
        else if(haystack.length()==0) return -1;
        
        for(int i=0; i<haystack.length()-needle.length()+1; i++)
        {
           int n = needle.length();
            for(int j=i; j<i+n; j++)
            {
                if(haystack.charAt(j)!=needle.charAt(j-i)) break;
                if(j==i+n-1) return i;
            }
        }        
        return -1;
    }

}
