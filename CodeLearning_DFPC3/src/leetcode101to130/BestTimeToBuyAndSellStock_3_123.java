package leetcode101to130;

public class BestTimeToBuyAndSellStock_3_123 {
    public int maxProfit_3(int[] prices) 
    {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
 
    }
        
    //Sol 2: Optimizing : Reduce some forloop
    //Please check Tushar's video
    public int maxProfit_2_2(int[] prices) 
    {
        if(prices==null || prices.length<=1) return 0;
		int max = 0;	
		int cur = 0;
        int len = prices.length;
        return maxProfit_2_2(prices,2);
    }
    
    public int maxProfit_2_2(int[] prices, int t)
    {
        int len = prices.length;
        int[][] dp = new int[t+1][len+1];
        int[] record = new int[len];  //record[i] = dp[prices[k]
        
        
        for(int i=1; i<=t; i++)
        {
            int premaxdiff = dp[i-1][0] - prices[0];
            int curmax = premaxdiff+prices[1];
            for(int j=2; j<=len; j++)
            {
                premaxdiff = Math.max(dp[i-1][j-1]-prices[j-2],premaxdiff);
                curmax = premaxdiff + prices[j-1];
                dp[i][j] = Math.max(dp[i][j-1],curmax);
            }

        }
        return dp[t][len];
    }
    
    
    
    
    
    
    
    
    //Sol 2: DP : Two variables: until which price( how many days).
    //							 How many transactions
    public int maxProfit_2(int[] prices) 
    {
        if(prices==null || prices.length<=1) return 0;

        return maxProfit_2(prices,2);
    }
    
    public int maxProfit_2(int[] prices, int t)
    {
        int len = prices.length;
        int[][] dp = new int[t+1][len+1];
        dp[0][0] = 0;
        
        for(int j=1; j<=len; j++)
        {
            dp[0][j] = 0;
        }
        for(int i=0; i<=t; i++)
        {
            dp[i][0] = 0;
        }
        
        for(int i=1; i<=t; i++)
        {
            for(int j=1; j<=len; j++)
            {
                int curmax = 0;
                for(int k=1; k<j; k++)
                {
                    if(prices[j-1]>prices[k-1])
                    {
                        curmax = Math.max(prices[j-1]-prices[k-1] + dp[i-1][k], curmax);
                    }
                }
                dp[i][j] = Math.max(dp[i][j-1],curmax);
            }
        }
        return dp[t][len];
    }

    
    
    //Sol 1: If k==2 only    
    public int maxProfit_1(int[] prices) 
    {
        if(prices==null || prices.length<=1) return 0;
        int len = prices.length;
        
        int[] beforemaxprofit = new int[len];
        
        int min = prices[0];
        beforemaxprofit[0] = 0;
        int curmax = 0;
        for(int i=1; i<len; i++)
        {
            if(prices[i]>min)
            {
                curmax = Math.max(curmax,prices[i]-min);
                beforemaxprofit[i] = curmax;
            }
            else
            {
                min = prices[i];
                beforemaxprofit[i] = beforemaxprofit[i-1];
            }
        }
        
        int[] aftermaxprofit = new int[len];
        int max = prices[len-1];
        aftermaxprofit[len-1] = 0;
        curmax = 0;
        for(int j=len-2;j>=0; j--)
        {
            if(prices[j]<max)
            {
                curmax = Math.max(curmax,max-prices[j]);
                aftermaxprofit[j] = curmax;
            }
            else
            {
                max = prices[j];
                aftermaxprofit[j] = aftermaxprofit[j+1];
            }
        }
        int res = 0;
        for(int i=0; i<(len-1); i++)
        {
            res = Math.max(res,aftermaxprofit[i]+beforemaxprofit[i]);
        }
        return res;
    }
}
