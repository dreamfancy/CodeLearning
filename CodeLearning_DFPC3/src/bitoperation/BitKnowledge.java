package bitoperation;

public class BitKnowledge 
{
	//int: 32bits = 4bytes
	//  most significant 0000 0000 0000 0000 0000 0000 0000 0001 least significant
	//  1K 1k           1024                2 ^ 10  10bits
	//  1M 1m           1024 * 1024                 20bits
	//  1G 1billion     1024 ^ 3                    30bits
	//  1T 1trillion    1024 ^ 4                    40bits
	
	// 32bits int -> 4G  -FAT32
	
	//java all signed number:
	//-2^31 ~ 2^31-1 
	// -2^31:  1000 0000 0000 0000 0000 0000 0000 0000
	
	//Complement for negative number: get oppersite by bit then add 1
	
	/*
		& bit and
		| bit or
		~ bit not
		^ bit xor
		<< left shift
		>> right shift
		>>>right shift with zero filled
		
		Time O(1)
		
	*/
	
	//set index k bit to 1 of int x:
	// x | 1<<k
	
	//set kth bit to 0 of int x
	// x & ~(1<<k)
	
	//check kth bit is 1 of int x
	// x&(1<<k)
	// ( x>>k)&1
	
	//check kth bit is 0 of int x
	// (x&1<<k)==0?
	// (1&x>>k)==0?
	 
	
	//lecture 14 2:41
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5,1,2,3,4};
		
		int sum = 0;
		for(int i=0; i<array.length; i++)
		{
			sum ^= array[i];
		}
		System.out.println(sum);
	}
}
