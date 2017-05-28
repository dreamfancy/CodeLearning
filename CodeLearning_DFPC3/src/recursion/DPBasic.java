package recursion;

//Idea: For the same direction, use for loop; For the opposite direction, use while loop



public class DPBasic {
	
	public static long fibseq(int n)
	{
		if(n<=-1) return -1;
		if (n<=1) return n;
		
		int cur = 2;
		int val= 1;
		int preval = 1;
		while(cur<n)
		{
			cur++;
			int temp = val;
			val = val + preval;
			preval = temp;
		}
		
		return val;
	}

}
