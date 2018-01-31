package leetcode300to350;

public class AdditiveNumber_306 
{
    public boolean isAdditiveNumber(String num) 
    {
        if(num==null || num.length()==0) return false;
      
        for(int i=1; i<num.length()-1; i++)
        {
            String s1 = num.substring(0,i);
            if(s1.length()>1 && s1.charAt(0)=='0') break;
            for(int j=i+1;j<num.length(); j++)
            {
                String s2 = num.substring(i,j);
                if(s2.length()>1 && s2.charAt(0)=='0') break;
                long l1 = Long.parseLong(s1);
                long l2 = Long.parseLong(s2);
                
                //  System.out.println(l1+" "+l2);
                if(helper(num.substring(j),l1,l2)==true)
                    return true;
            }
        }
        return false;
    }
    
    private boolean helper(String str, long pre1, long pre2)
    {
        //System.out.println(str+"  "+  pre1 +" " + pre2);
        long cur = pre1+pre2;
        String next = String.valueOf(cur);
        if(str.equals(next)) return true;
        if(str.startsWith(next))
            return helper(str.substring(next.length()),pre2,cur);
        
        return false;
    }

}
