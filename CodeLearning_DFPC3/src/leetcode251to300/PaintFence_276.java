package leetcode251to300;

public class PaintFence_276 
{
    public int numWays(int n, int k) 
    {
        if(n==0) return 0;
        if(n==1) return k;
        //while n==2
        int diffcount = k *(k-1);
        int samecount = k;
        for(int i=2; i<n; i++)
        {
            int temp = diffcount;
            diffcount = (diffcount+samecount)*(k-1);
            samecount = temp;
        }
        return diffcount+samecount;
    }

}
