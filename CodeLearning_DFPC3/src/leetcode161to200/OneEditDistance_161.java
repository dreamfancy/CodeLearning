package leetcode161to200;

public class OneEditDistance_161 
{
	//sol 2: process in one for loop
	
    public boolean isOneEditDistance_2(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int slen = s.length();
        int tlen = t.length();
        int min = Math.min(slen, tlen);
        
        for (int i = 0; i < min; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (slen == tlen) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    if (slen > tlen) {
                        return s.substring(i + 1).equals(t.substring(i));
                    } else {
                        return s.substring(i).equals(t.substring(i + 1));
                    }
                }
            }
        }
        return Math.abs(slen - tlen) == 1;
    }
	
	//Sol 1: Discuss different situations
    public boolean isOneEditDistance_1(String s, String t) 
    {
        if(s==null || s.length()==0)
        {
            if(t!=null && t.length()==1) return true;
            else return false;
        }
        if(t==null || t.length()==0)
        {
            if(s!=null && s.length()==1) return true;
            else return false;
        }
        int len1 = s.length();
        int len2 = t.length();
        if(Math.abs(len1-len2)>=2) return false;
        
        if(s.length()==t.length())
        {
            int count = 0;
            for(int i=0; i<s.length(); i++)
            {
                if(s.charAt(i)!=t.charAt(i)) count++;
                if(count>=2 ) return false;
            }
            if(count==0) return false;
            return true;
        }
        if(s.length()==t.length()-1)
        {
            String temp = s;
            s = t;
            t = temp;
        }
        for(int i=0; i<s.length()-1; i++)
        {
           if(s.charAt(i)!=t.charAt(i))
           {
               if(s.substring(i+1).equals(t.substring(i))) return true;
               else return false;
           }
        }
         return true;
    }
}
