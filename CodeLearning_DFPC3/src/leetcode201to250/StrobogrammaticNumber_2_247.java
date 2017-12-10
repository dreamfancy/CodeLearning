package leetcode201to250;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumber_2_247 
{
	//Sol 2: chararray
	public List<String> findStrobogrammatic_2(int n) {
	    findStrobogrammaticHelper(new char[n], 0, n - 1);
	    return res;
	}

	List<String> res = new ArrayList<String>();

	public void findStrobogrammaticHelper(char[] a, int l, int r) {
	    if (l > r) {
	        res.add(new String(a));
	        return;
	    }
	    if (l == r) {
	        a[l] = '0'; res.add(new String(a));
	        a[l] = '1'; res.add(new String(a));
	        a[l] = '8'; res.add(new String(a));
	        return;
	    }
	    
	    if (l != 0) {
	        a[l] = '0'; a[r] = '0';
	        findStrobogrammaticHelper(a, l+1, r-1);
	    }
	    a[l] = '1'; a[r] = '1';
	    findStrobogrammaticHelper(a, l+1, r-1);
	    a[l] = '8'; a[r] = '8';
	    findStrobogrammaticHelper(a, l+1, r-1);
	    a[l] = '6'; a[r] = '9';
	    findStrobogrammaticHelper(a, l+1, r-1);
	    a[l] = '9'; a[r] = '6';
	    findStrobogrammaticHelper(a, l+1, r-1);
	}
	
	//Sol 1: My Solution stringBuilder
    public List<String> findStrobogrammatic_1(int n) 
    {
        List<StringBuilder> result = new ArrayList<StringBuilder>();
        List<String> convertedStrings = new ArrayList<String>();

        if(n<=0) return convertedStrings;
        if(n%2==1)
        {
            //List<StringBuilder> li = new ArrayList<StringBuilder>();
            result.add(new StringBuilder("1"));
            result.add(new StringBuilder("0"));
            result.add(new StringBuilder("8"));
            int k = n-1;
            while(k>2)
            {
                result = addonemorelayer(result,false);
                k = k-2;
            }
            if(k==2)
                result = addonemorelayer(result,true);
        }
        else
        {
            result.add(new StringBuilder("11"));
            result.add(new StringBuilder("69"));
            result.add(new StringBuilder("96"));
            result.add(new StringBuilder("88"));
            if(n!=2)
            {
                result.add(new StringBuilder("00"));
            }
            
            int k = n-2;
            while(k>2)
            {
                result = addonemorelayer(result,false);
                k = k-2;
            }
            if(k==2)
                result = addonemorelayer(result,true);
        }
                    
        for(StringBuilder sb: result)
        {
            convertedStrings.add(sb.toString());
        }
        
        return convertedStrings;
    }
    
    private List<StringBuilder> addonemorelayer(List<StringBuilder> li, boolean lastround)
    {
        List<StringBuilder> res = new ArrayList<StringBuilder>();
        for(StringBuilder oldsb: li)
        {
            StringBuilder sb = new StringBuilder(oldsb);
            sb.insert(0,'1');
            sb.append('1');
            res.add(sb);
            
            sb = new StringBuilder(oldsb);
            sb.insert(0,'6');
            sb.append('9');
            res.add(sb);
            
            sb = new StringBuilder(oldsb);
            sb.insert(0,'9');
            sb.append('6');
            res.add(sb);
            
            sb = new StringBuilder(oldsb);
            sb.insert(0,'8');
            sb.append('8');
            res.add(sb);
            if(lastround==false)
            {
                sb = new StringBuilder(oldsb);
                sb.insert(0,'0');
                sb.append('0');
                res.add(sb);
            }
        }
        return res;
    }
	

}
