package leetcode51to100;

import java.util.Arrays;

public class ScrambleString_87 {
    public boolean isScramble(String s1, String s2) {
        if(s1==null || s2==null || s1.length()!=s2.length()) return false;
        if(s1.length()==1 && s1.equals(s2)) return true;
        
        char[] s1char = s1.toCharArray();
        char[] s2char = s2.toCharArray();
        Arrays.sort(s1char);
        Arrays.sort(s2char);
        String sortedS1 = new String(s1char);
        String sortedS2 = new String(s2char);
        if(!sortedS1.equals(sortedS2)) return false;
        
        int len = s1.length();
        for(int i=1; i<s1.length(); i++)
        {
            String leftstr1 = s1.substring(0,i);
            String rightstr1 = s1.substring(i,len);
            
            String leftstr2 = s2.substring(0,i);
            String rightstr2 = s2.substring(i,len);
            
            String altleftstr2 = s2.substring(len-i,len);
            String altrightstr2 = s2.substring(0,len-i);
            
            if((isScramble(leftstr1,leftstr2) && isScramble(rightstr1,rightstr2)) || (isScramble(leftstr1,altleftstr2) && isScramble(rightstr1,altrightstr2))) return true;
        }
        return false;
    }
}
