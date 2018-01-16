package leetcode251to300;

import java.util.HashSet;
import java.util.Set;

public class Palindrome_Permutation_266 
{
	
	//sol 2:
	public boolean canPermutePalindrome_2(String s) {
        Set<Character> set=new HashSet<Character>();
        for(int i=0; i<s.length(); ++i){
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else 
                set.remove(s.charAt(i));
        }
        return set.size()==0 || set.size()==1;
    }
	
	//Sol 1:
    public boolean canPermutePalindrome_1(String s) 
    {
        if(s==null || s.length()==0) return false;
        if(s.length()==1) return true;
        
        boolean[] upperletter = new boolean[26];
        boolean[] lowerletter = new boolean[26];

        
        for(int i=0; i<s.length(); i++)
        {
            int cur1 = s.charAt(i)-'a';
            int cur2 = s.charAt(i)-'A';
            if(cur1>=0 && cur1<26)
            {
            
                if(lowerletter[cur1]==false)
                {
                    lowerletter[cur1] = true;
                }
                else
                {
                    lowerletter[cur1] = false;
                }
            }
            else if(cur2>=0 && cur2<26)
            {
            
                if(upperletter[cur2]==false)
                {
                    upperletter[cur2] = true;
                }
                else
                {
                    upperletter[cur2] = false;
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<26; i++)
        {
            if(upperletter[i]==true) count++;
            if(lowerletter[i]==true) count++;

        }
        if(count>=2) return false;
        return true;
    }
}
