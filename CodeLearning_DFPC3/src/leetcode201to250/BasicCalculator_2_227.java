package leetcode201to250;

public class BasicCalculator_2_227 
{
	//sol 1: My Solution
    public int calculate(String s) 
    {
        if(s==null || s.length()==0) return 0;
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        int i=0;
        char presign = '+';
        
        boolean prio = false;
        int outval = 0;
        char outsign = '+';
        while(i<s.length())
        {
            char c = s.charAt(i);
            if(c==' ') 
            {
                i++;
                continue;
            }
            else if(c=='+' || c=='-')
            {
                int digit = Integer.parseInt(sb.toString());
                if(presign=='+' || presign=='-')
                {
                    cur = presign=='+'? (cur+digit) : (cur-digit);
                    presign = c;
                }
                else
                {
                    cur = presign=='*'? (cur*digit) : (cur/digit);
                    int temp = cur;
                    cur = outval;
                    presign = outsign;
                    cur = presign=='+'? (cur+temp) : (cur-temp);
                    presign = c;
                }
                sb = new StringBuilder();
            }
            else if(c=='*' || c=='/')
            {
                int digit = Integer.parseInt(sb.toString());
                if(presign=='+' || presign=='-')
                {
                    outval = cur;
                    outsign = presign;
                    cur = digit;
                    presign = c;
                }
                else
                {
                    cur = presign=='*'? (cur*digit) : (cur/digit);
                    presign = c;
                }
                sb= new StringBuilder();
            }
            else
            {
                sb.append(s.charAt(i));
            }
            i++;
        } 
        if(sb.length()!=0)
        {
            int digit = Integer.parseInt(sb.toString());
            if(presign=='+') cur = cur + digit;
            else if(presign=='-') cur = cur - digit;
            else
            {
                 cur = presign=='*'? (cur*digit) : (cur/digit);
                 int temp = cur;
                 cur = outval;
                 presign = outsign;
                 cur = presign=='+'? (cur+temp) : (cur-temp);                
            }
        }
        return cur;
    }

}
