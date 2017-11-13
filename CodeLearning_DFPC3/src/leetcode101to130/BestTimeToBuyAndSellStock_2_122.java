package leetcode101to130;

public class BestTimeToBuyAndSellStock_2_122 
{
	
	//Sol 3: Optimizing for sol 2: We can also make big changes from scratch
    public int maxProfit_3(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
	
	//sol 2: Always use valley and peek
	
	public int maxProfit_2(int[] prices)
	{
        if(prices==null || prices.length<=1) return 0;
		int max = 0;	
		int cur = 0;
		
		while(cur<prices.length)
		{
			int peak = cur;
			int valley = cur;
			
			while(cur<(prices.length-1) && prices[cur]>=prices[cur+1])
			{
				cur++;
			}
			if(cur==(prices.length-1)) break;
			valley = cur;
			
			while(cur<(prices.length-1) && prices[cur]<=prices[cur+1])
			{
				cur++;
			}
			peak = cur;
			max += peak-valley;
			cur++;
		}
		return max;
	}
	
	
	//sol 1: forloop brute force
    public int maxProfit_1(int[] prices) 
    {
        if(prices==null || prices.length<=1) return 0;
        
        return calculate(prices,0);
    }
    
    private int calculate(int[] prices, int start)
    {
        if(start>=(prices.length-1)) return 0;
        int maxprofit = 0;
        for(int j=start; j<(prices.length-1); j++)
        {
            int cur = prices[j];
            for(int i=(j+1); i<prices.length; i++)
            {
                if(prices[i]>cur)
                {
                    int profit = prices[i]-cur+ calculate(prices,i+1);
                    maxprofit = Math.max(maxprofit,profit);
                }
            }
        }
        return maxprofit;
    }
}
