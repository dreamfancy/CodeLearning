package leetcode251to300;

public class SingleNumber_3_260 
{
    public int[] singleNumber(int[] nums) 
    {
        int diff = 0;
        for(int num: nums)
        {
            diff ^= num; 
        }
        
        //Get the last set bit using the following fomula, think about why
        diff &= -diff;
        
        int[] rets = {0,0};
        
        for(int num: nums)
        {
            if((num&diff)==0)
            {
                rets[0] ^= num; 
            }
            else
            {
                rets[1] ^= num;
            }
        }
        return rets; 
    }
}
