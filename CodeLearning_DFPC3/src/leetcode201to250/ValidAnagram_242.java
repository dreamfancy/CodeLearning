package leetcode201to250;

public class ValidAnagram_242 
{
    public boolean isAnagram(String s, String t) 
    {
        if(s==null || t==null || s.length()!=t.length()) return false;
        int[] arr = new int[26];
        int len = s.length();
        for(int i=0; i<len; i++)
        {
            int cur = s.charAt(i)-'a';
            arr[cur]++;
        }
        for(int j=0; j<len; j++)
        {
            int cur = t.charAt(j)-'a';
            arr[cur]--;
        }
        for(int k=0; k<26; k++)
        {
            if(arr[k]!=0) return false;
        }
        return true;        
    }


}
