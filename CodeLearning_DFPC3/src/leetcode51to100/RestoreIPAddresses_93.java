package leetcode51to100;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93 {
    
	//Offical Solution: Make use of substring
	static List<String> restoreIpAddresses_2(String s) {
		List<String> ans = new ArrayList<String>();
		int len = s.length();
		for (int i = 1; i <=3; ++i){  // first cut
			if (len-i > 9) continue;    		
			for (int j = i+1; j<=i+3; ++j){  //second cut
				if (len-j > 6) continue;    			
				for (int k = j+1; k<=j+3 && k<len; ++k){  // third cut
					int a,b,c,d;                // the four int's seperated by "."
					a = Integer.parseInt(s.substring(0,i));  
					b = Integer.parseInt(s.substring(i,j)); // notice that "01" can be parsed into 1. Need to deal with that later.
					c = Integer.parseInt(s.substring(j,k));
					d = Integer.parseInt(s.substring(k));
					if (a>255 || b>255 || c>255 || d>255) continue; 
					String ip = a+"."+b+"."+c+"."+d;
					if (ip.length()<len+3) continue;  // this is to reject those int's parsed from "01" or "00"-like substrings
					ans.add(ip);
				}
			}
		}
		return ans;
	}
	
	//My Solution : recur based on cur
	public List<String> restoreIpAddresses(String s) {
        
        List<String> res = new ArrayList<String>();
        if(s==null || s.length()<4 || s.length()>12) return res;
        
        List<Integer> cursol = new ArrayList<Integer>();
        
        int cur = 0;
        restoreIpAddresses(s,0,cursol,res);
        return res;
    }

    public void restoreIpAddresses(String s, int cur, List<Integer> cursol, List<String> res)
    {
        if(cur==s.length() && cursol.size()==4)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(cursol.get(0));
            for(int i=1; i<cursol.size(); i++)
            {
                sb.append(".").append(cursol.get(i));
            }
            res.add(sb.toString());
            return;
        }
        if(cur>=s.length()) return;
        if(cursol.size()>=4) return;
        
        cursol.add(s.charAt(cur)-'0');
        restoreIpAddresses(s,cur+1,cursol,res);
        cursol.remove(cursol.size()-1);

        if(cur<(s.length()-1) && s.charAt(cur)!='0')
        {
            cursol.add(Integer.parseInt(s.substring(cur,cur+2)));
            restoreIpAddresses(s,cur+2,cursol,res);
            cursol.remove(cursol.size()-1);
        }
        
        if(cur<(s.length()-2) && s.charAt(cur)=='2')
        {
            if(s.charAt(cur+1)<='4' || (s.charAt(cur+1)=='5' && s.charAt(cur+2)<='5'))
            {
                cursol.add(Integer.parseInt(s.substring(cur,cur+3)));
                restoreIpAddresses(s,cur+3,cursol,res);
                cursol.remove(cursol.size()-1);
            }
        }
        if(cur<(s.length()-2) && s.charAt(cur)=='1')
        {
            cursol.add(Integer.parseInt(s.substring(cur,cur+3)));
            restoreIpAddresses(s,cur+3,cursol,res);
            cursol.remove(cursol.size()-1);
        }
        return;
    }
}
