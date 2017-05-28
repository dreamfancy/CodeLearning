package recursion;

public class MyPower {

	public static void main(String[] args)
	{
		
	}
	
	public long getMypow(int x, int n)
	{
		if(n==1) return (long)x;
		
		long val = getMypow(x,n/2);
		//Not necessary to store n/2 because any n/2 will only occur one time here in the recursion
		
		
		//if(n%2==0) return val*val;
		//else return val*val*x;
		return n%2==0 ? val*val : val*val*x;
		
	}
	
	/*
	public long getMypow(int x, int n)
	{
		
	}
	*/
	
	
	//Cannot use DP because the same n/2 above will not occur the second time
	/*
	public long getMypow_DP(int x, int n)
	{
		if(n==1) return (long)x;
		int p=1;
		
		
		
		
	}
	*/
}
