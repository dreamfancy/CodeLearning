package leetcode201to250;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 
{
	
	//Use hashSet to avoid loop
	public boolean isHappy(int n)
	{
		Set<Integer> hash = new HashSet<Integer>();
		int squaresum, remain;
		while(hash.add(n))
		{
			squaresum = 0;
			while(n>0)
			{
				remain = n%10;
				squaresum += remain*remain;
				n /= 10;
			}
			if(squaresum ==1) return true;
			n = squaresum;
		}
		return false;
	}

}
