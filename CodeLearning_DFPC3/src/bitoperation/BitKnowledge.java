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
}
