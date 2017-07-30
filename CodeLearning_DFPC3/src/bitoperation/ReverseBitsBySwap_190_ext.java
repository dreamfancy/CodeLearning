package bitoperation;

public class ReverseBitsBySwap_190_ext {

	public int reverseBits(int n)
	{
		if(n==0 || n==-1) return n;
		for(int i=0; i<16; i++)
		{
			int left = 1 & n>>(31-i);
			int right = 1 & n>>i;
			
			if(left!=right)
			{
				n ^= 1<<(31-i);
				n ^= 1<<i; 
			}
			 
		}
		
		return n;
		
	} 
}
