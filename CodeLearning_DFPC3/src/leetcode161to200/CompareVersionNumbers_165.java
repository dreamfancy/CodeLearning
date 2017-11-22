package leetcode161to200;

public class CompareVersionNumbers_165 
{
    public int compareVersion(String version1, String version2) {
        if(version1==null || version1.length()==0 || version2==null || version2.length()==0) return 0;
        String[] str1s = version1.split("\\.");        
        String[] str2s = version2.split("\\.");        
        int len1 = str1s.length;
        int len2 = str2s.length;
        int maxlen = Math.max(len1,len2);    
    
        int cur = 0;
        while(cur<maxlen)
        {
            int dig1 = cur>=len1 ? 0 : Integer.parseInt(str1s[cur]);
            int dig2 = cur>=len2 ? 0 : Integer.parseInt(str2s[cur]);
            if(dig1>dig2) return 1;
            else if(dig1<dig2) return -1;
            cur++;
        }
        return 0;
    }
	
}
