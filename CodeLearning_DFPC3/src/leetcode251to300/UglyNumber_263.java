package leetcode251to300;

public class UglyNumber_263 
{
    public boolean isUgly(int num) 
    {
        if(num<=0) return false;
        while(num%30==0)
        {
            num /= 30;
        }
        while(num%6==0)
        {
            num /=6;
        }
        while(num%10==0)
        {
            num /=10;
        }
        while(num%15==0)
        {
            num /=15;
        }
        while(num%2==0)
        {
            num /=2;
        }
        while(num%3==0)
        {
            num /=3;
        }
        while(num%5==0)
        {
            num /=5;
        }
        
        return num==1;
    }


}
