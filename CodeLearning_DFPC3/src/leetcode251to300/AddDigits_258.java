package leetcode251to300;

public class AddDigits_258 
{
    public int addDigits(int num) 
    {
        String curstr = num + "";
        if(curstr.length()==1) return num;
        int curnum = 0;
        while(curstr.length()>1)
        {
            curnum = 0;
            for(int i=0; i<curstr.length(); i++)
            {
                curnum += curstr.charAt(i)-'0';
            }
            curstr = curnum +"";
        }
        return curnum;
    }

}
