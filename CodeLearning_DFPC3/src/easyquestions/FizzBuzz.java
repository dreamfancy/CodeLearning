//OneTimePass

package easyquestions;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz 
{

	public static List<String> FizzBuzz(int n)
	{
		List<String> arr = new ArrayList<String>();
		
		for(int i=1; i<=n; i++)
		{	
			String res = "";
			if(i%15==0)
			{
				res = "FizzBuzz";
			}
			else if(i%3==0)
			{
				res = "Fizz";			}
			else if(i%5==0)
			{
				res = "Buzz";
			}
			else
			{
				res = i+"";
			}
			arr.add(res);
		}
		
		return arr;
	}
/*	
	public static void main(String[]args)
	{
		System.out.println(FizzBuzz(40));
	}
*/
}
