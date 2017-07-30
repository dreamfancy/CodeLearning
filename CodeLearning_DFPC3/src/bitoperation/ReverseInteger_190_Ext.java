package bitoperation;

public class ReverseInteger_190_Ext 
{
	public int reverseInteger(int n)
	{
		 int res = 0;
		 
		 while(n!=0)
		 {
			 res = res * 10 + n % 10;
			 n =  n/10; 
		 }
		 
		 return res;
	}
	
	//if it is binary or 3 jinzhi or 4 jinzhi, just change 10 to the corresponding jinzhi number
	// n%10 -> n&1
	//n/10 -> n>>>1;
	
	//erjinzhi 0b
	//shiliujinzhi 0x
}
