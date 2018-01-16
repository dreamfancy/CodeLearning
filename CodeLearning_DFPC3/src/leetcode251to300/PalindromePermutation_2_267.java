package leetcode251to300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePermutation_2_267 
{
    Set < String > set = new HashSet < > ();
    public List < String > generatePalindromes_3(String s) {
        int[] map = new int[128];
        char[] st = new char[s.length() / 2];
        if (!canPermutePalindrome(s, map))
            return new ArrayList < > ();
        char ch = 0;
        int k = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 == 1)
                ch = (char) i;
            for (int j = 0; j < map[i] / 2; j++) {
                st[k++] = (char) i;
            }
        }
        permute(st, 0, ch);
        return new ArrayList < String > (set);
    }
    public boolean canPermutePalindrome(String s, int[] map) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }
    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    void permute(char[] s, int l, char ch) {
        if (l == s.length) {
            set.add(new String(s) + (ch == 0 ? "" : ch) + new StringBuffer(new String(s)).reverse());
        } else {
            for (int i = l; i < s.length; i++) {
                if (s[l] != s[i] || l == i) {
                    swap(s, l, i);
                    permute(s, l + 1, ch);
                    swap(s, l, i);
                }
            }
        }
    }
	
	
	
	//sol 2: My Solution : Consider half
    public List<String> generatePalindromes(String s) 
    {
    	List<String> result = new ArrayList<String>();
        if(s==null || s.length()==0) return result;
        if(s.length()==1)
        {
            result.add(s);
            return result;
        }
    	char[] letter= s.toCharArray();
    	Arrays.sort(letter);
    	int countsingle = 0;
    	int countdouble = 0;
    	char[] doubleletter = new char[letter.length];
    	char singleletter = '*';
    	
        int c = 0;
    	while(c<letter.length-1)
    	{
    		if(letter[c]==letter[c+1])
            {
    			doubleletter[countdouble++] = letter[c];
                c +=2;
            }
            else
    		{
    			singleletter = letter[c];
    			countsingle++;
                c++;
    		}
    	}
        if(c==letter.length-1)
        {
                singleletter = letter[c];
    			countsingle++;
                c++;
        }
    	if(countsingle>1) return result;
    	
    	List<String> oristr = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
    	getallpermutations(doubleletter,countdouble,0,sb,oristr,new boolean[countdouble]);
    	
    	for(String oris : oristr)
    	{
    		String revs = new StringBuilder(oris).reverse().toString();
    		if(singleletter!='*')
    		{
    			result.add(oris+singleletter+revs);
    		}
    		else
    		{
    			result.add(oris+revs);
    		}
    	}
    	return result;
    }
    
    private void getallpermutations(char[] arr,int arrlen,int cur,StringBuilder sb,List<String> result,boolean[] used)
    {
    	if(cur==arrlen)
    	{
    		result.add(sb.toString());
    		return;
    	}
    	
    	for(int i=0; i<arrlen; i++)
    	{
            if(used[i]==true) continue;
            if(i>0 && arr[i-1]==arr[i] && used[i-1]==false) continue;
    		sb.append(arr[i]);
            used[i] = true;
    		getallpermutations(arr,arrlen,cur+1,sb,result,used);
    		sb.deleteCharAt(sb.length()-1);
            used[i] = false;
    	}	
    }
	
	
	
	//Sol 1: Wrong. Did not consider the possibilities of duplicates
    public List<String> generatePalindromes_1(String s) 
    {
    	List<String> result = new ArrayList<String>();
    	char[] letter= s.toCharArray();
    	Arrays.sort(letter);
    	int countsingle = 0;
    	int countdouble = 0;
    	char[] doubleletter = new char[letter.length];
    	char singleletter = '*';
    	
    	for(int i=0; i<letter.length-1; i++)
    	{
    		if(letter[i]==letter[i+1])
    			doubleletter[countdouble++] = letter[i];
    		else
    		{
    			singleletter = letter[i];
    			countsingle++;
    		}
    	}
    	if(countsingle>1) return result;
    	
    	List<String> oristr = new ArrayList<String>();
    	getallpermutations(doubleletter,countdouble,0,oristr);
    	
    	for(String oris : oristr)
    	{
    		String revs = new StringBuilder(oris).reverse().toString();
    		if(singleletter!='*')
    		{
    			result.add(oris+singleletter+revs);
    		}
    		else
    		{
    			result.add(oris+revs);
    		}
    	}
    	return result;
    }
    
    private void getallpermutations(char[] arr,int arrlen,int cur,List<String> result)
    {
    	if(cur==arrlen-1)
    	{
    		result.add(new String(arr).substring(0,arrlen));
    		return;
    	}
    	
    	for(int i=cur; i<arrlen; i++)
    	{
    		char temp = arr[i];
    		arr[i] = arr[cur];
    		arr[cur] = temp;
    		getallpermutations(arr,arrlen,cur+1,result);
    		temp = arr[i];
    		arr[i] = arr[cur];
    		arr[cur] = temp;
    	}	
    }
}
