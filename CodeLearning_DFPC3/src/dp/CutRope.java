package dp;

public class CutRope 
{
	//Lecture DP section Q5
	//How many numbers in the rope is the dp contents
	//At least one cut -> This has great impact on base case
	public int maximumProductsOfRopeScissored(int n)
	{
		int[] dp = new int[n+1];
		dp[0] = 1;//?? no physical meaning
		dp[1] = 1; //length 2
		dp[2] = 2; //length 3
		for(int i=2; i<=n; i++)
		{	
			int curMax = 0;
			for(int j=1; j<=i/2; j++)
			{
				int curValue = Math.max(j,dp[j]) * Math.max(i-j, dp[i-j]);
				curMax = Math.max(curMax, curValue);
			}
			dp[i] = curMax;
		}
		return dp[n];
	}

}
