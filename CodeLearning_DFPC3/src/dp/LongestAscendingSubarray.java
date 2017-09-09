package dp;

public class LongestAscendingSubarray {

	//return length of longest ascending sub-array
	public int LongestAscendingSubarray(int[] array)
	{
		if(array==null ||array.length==0) return 0;
		int[] dp = new int[array.length];
		dp[0] = 1;
		for(int i=1; i<dp.length; i++)
		{
			if(dp[i]>dp[i-1])
			{
				dp[i] = dp[i-1]+1;
			}
			else
			{
				dp[i] = 1;
			}
		}
		
		int max = 1;
		for(int j=0; j<dp.length;j++)
		{
			if(dp[j]>max) max = dp[j];
		}
		return max;
	}
}
