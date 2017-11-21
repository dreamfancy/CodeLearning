package leetcode161to200;

public class CompareVersionNumbers_165 
{
    public int compareVersion(String version1, String version2) {
        if(version1==null || version1.length()==0 || version2==null || version2.length()==0) return 0;
        String[] strs1 = version1.split(".");
        String[] strs2 = version2.split(".");
        if(strs1.length>=3 || strs2.length>=3) return 0;
        
        int v1 = Integer.parseInt(strs1[0]);
        int v2 = Integer.parseInt(strs2[0]);
        if(v1>v2) return 1;
        else if (v1<v2) return -1;
        else
        {
            if(strs1.length==1 && strs2.length==1) return 0;
            else if(strs1.length==1) return -1;
            else if(strs2.length==1) return 1;
            else if(Integer.parseInt(strs1[1])>Integer.parseInt(strs2[1])) return 1;
            else if(Integer.parseInt(strs1[1])<Integer.parseInt(strs2[1])) return -1;
            else return 0;
        } 
    }
	
}
