package leetcode251to300;

import java.util.ArrayList;
import java.util.List;

public class EncodingAndDecodingStrings_271 
{
    public String encode(List<String> strs) {
        if(strs.size()==0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.size(); i++)
        {
            int len = strs.get(i).length();
            sb.append(len).append('#').append(strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) 
    {
        List<String> result = new ArrayList<String>();
        if(s==null || s.length()==0)
        {
            return result;
        }
        
        //char[] sarray = s.toCharArray();
        int cur = 0;
        
        while(cur<s.length())
        {
            int i=0;
            while(s.charAt(cur+i)!='#')
                i++;
            int num = Integer.parseInt(s.substring(cur,cur+i));
           // if(num==0) result.add("");
           // else
                result.add(s.substring(cur+i+1,cur+i+num+1));
            cur = cur+i+num+1;
        }
        
        return result;
    }	

}
