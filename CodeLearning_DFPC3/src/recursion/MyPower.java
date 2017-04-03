package recursion;

public class MyPower {

	public static void main(String[] args)
	{
		
	}
	
	public long getMypow(int x, int n)
	{
		if(n==1) return (long)x;
		
		long val = getMypow(x,n/2);
		if(n%2==0) return val*val;
		else return val*val*x;
	}
}
