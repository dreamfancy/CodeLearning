package leetcode101to130;

public class BestTimeToBuyAndSellStock_1_121 {
	
	
	//Sol 2: Based On curMin Price, update curMax price: Greedy
    public int maxProfit_2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
	
	
	
	//Sol 1: My solution
    public int maxProfit_1(int[] prices) {
        if(prices==null || prices.length<=1) return 0;
        int len = prices.length;
        
        int[] minbefore = new int[len];
        int min = prices[0];
        for(int i=0; i<len; i++)
        {
            min = Math.min(prices[i],min);
            minbefore[i] = min;
        }
        
        int[] maxafter = new int[len];
        int max = prices[len-1];
        for(int j=len-1; j>=0; j--)
        {
            max = Math.max(max,prices[j]);
            maxafter[j] = max;
        }
        
        int maxInterval = 0;
        
        for(int k=0; k<len; k++)
        {
            maxInterval = Math.max(maxafter[k]-minbefore[k],maxInterval);
        }
        return maxInterval;
    }
}
