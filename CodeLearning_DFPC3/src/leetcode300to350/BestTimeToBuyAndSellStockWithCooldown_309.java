package leetcode300to350;

public class BestTimeToBuyAndSellStockWithCooldown_309 
{
	public int maxProfit_2(int[] prices)
	{
		int sell = 0;
		int presell = 0;
		
		int buy = Integer.MIN_VALUE, prebuy = 0;
		
		for(int price: prices)
		{
			prebuy = buy;
			buy = Math.max(presell-price,prebuy);
			presell = sell;
			sell = Math.max(prebuy+price, presell);
		}
		return sell;
	}
	
	
    public int maxProfit_1(int[] prices) 
    {
        if(prices==null || prices.length<2) return 0;
        int len = prices.length;
        int[] buy = new int[len];
        int[] rest = new int[len];
        int[] sell = new int[len];
        
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0],-prices[1]);
        sell[1] = Math.max(buy[0] + prices[1],0);
        for(int i=2; i<len; i++)
        {
        	buy[i] = Math.max(rest[i-1]-prices[i], buy[i-1]);
        	rest[i] = Math.max(rest[i-1], Math.max(sell[i-1],buy[i-1]));
        	sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        	//sell[i] = Math.max(a, b)
        	//Not Finished DP
        } 
        return sell[len-1];  
    }
}
