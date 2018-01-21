package leetcode251to300;

import java.util.ArrayList;
import java.util.List;

public class IntegerToEnglishWords_273 
{
    public String numberToWords(int num) 
    {
        if(num==0) return "Zero";
        if(num<0) return "Exception 1";
        
        String[] digit = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
                                       "Seventeen","Eighteen","Nineteen"};
        String[] degrees = {"","Ten", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        
        
        String numstr = String.valueOf(num);
        int len = numstr.length();
        if(len>10) return "Exception 2";
        List<StringBuilder> sblist = new ArrayList<StringBuilder>();
        int cur = len-1;
        
        int round = 1;
        while(cur>=0)
        {
            StringBuilder sb= new StringBuilder();
            int three = 0;
            if((cur-2)>=0)
                three = numstr.charAt(cur-2)-'0';
            if(three!=0)
            {
                sb.append(digit[three]).append(" Hundred ");
            }
            int two = 0;
            if((cur-1)>=0)
                two = numstr.charAt(cur-1)-'0';
            
            int one = numstr.charAt(cur)-'0';
            if(three==0 && two==0 && one==0)
            {
                cur = cur-3;
                round++;
                continue;
            }
            if(two>=2)
            {
                sb.append(degrees[two]).append(" ");
                if(one!=0)
                    sb.append(digit[one]).append(" ");
            }
            else
            {
                int twoone = two*10+one;
                if(twoone!=0)
                    sb.append(digit[twoone] +" ");
            }
            if(round==2)
            {
                sb.append("Thousand ");
            }
            else if(round==3)
            {
                sb.append("Million ");
            }
            else if(round==4)
            {
                sb.append("Billion ");
            }
            cur = cur-3;
            round++;
            sblist.add(sb);
        }
                                
        int level = sblist.size();                        
        for(int i=1; i<level; i++)
        {
            sblist.get(level-1).append(sblist.get(level-1-i));
        }
        return sblist.get(level-1).toString().trim();                                 
    }

}
