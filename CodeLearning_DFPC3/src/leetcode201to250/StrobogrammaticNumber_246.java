package leetcode201to250;

public class StrobogrammaticNumber_246 
{
	//sol 2:
	
	
	//Sol 1: My solution
    public boolean isStrobogrammatic_1(String num) 
    {
        if(num==null) return false;
        if(num.length()==0) return true;
        
        int i=0, j=num.length()-1;
        while(i<j)
        {
            char c1 = num.charAt(i);
            char c2 = num.charAt(j);
            if((c1=='1') && (c2=='1') || (c1=='8') && (c2=='8') || (c1=='6') && (c2=='9') || (c1=='9') && (c2=='6') || (c1=='0') && (c2=='0')) 
            {
                i++;
                j--;
                continue;
            }
            return false;
        }
        if(i==j)
        {
            char c1 = num.charAt(i);
            if(c1!='1' && c1!='8' && c1!='0') return false; 
        }
        return true;
    }
	

}
