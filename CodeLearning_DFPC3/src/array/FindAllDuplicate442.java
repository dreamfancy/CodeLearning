//Use positive or negative of the number to carry the information if it has occured before or not

package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicate442 
{
	public static List<Integer> findDuplicates(int[] nums) 
	{
		List<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<nums.length; i++)
		{
			int n = Math.abs(nums[i]);
			if(nums[n-1]<0)
			{
				arr.add(n);
			}
			else
			{
				nums[n-1] = -nums[n-1]; 
			}
		}	
		return arr;
	}
	
	public static void main (String[] args)
	{
		
		
	}
	
}
