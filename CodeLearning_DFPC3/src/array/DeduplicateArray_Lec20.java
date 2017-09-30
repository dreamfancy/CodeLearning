package array;

import java.util.Stack;

public class DeduplicateArray_Lec20 
{
	//Q1:
	//leave 1 only for each element
	public String deduplicate(String input)
	{
		if(input==null || input.length()<=1) return input;
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<input.length(); i++)
		{
			if(stack.empty() || stack.peek() != input.charAt(i))
			{
				stack.push(input.charAt(i));
			}
		}
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty())
		{
			sb.insert(0, stack.pop());
		}
		
		return sb.toString();
	}
	
	//Q2:
	//leave k only for each element
	public int deduplicate(int[] arr, int k)
	{
		if(arr.length<=k) return arr.length;
		int slow = k;
		
		for(int fast=k; fast<arr.length; fast++)
		{
			if(arr[slow-k]!=arr[fast])
			{
				arr[slow++] = arr[fast];
			}
		}
		return slow;
	}

	//Q3:
	//Remove all duplicates
	//Use flag to represent two states
	public int removeAllDup(int[] nums)
	{
		 if(nums==null) return 0;
		 if(nums.length<=1) return nums.length;
		 boolean flag = false;
		 int fast = 0;
		 int slow = 0;
		 
		 for(fast=0; fast<nums.length; fast++)
		 {
			 if(nums[fast]==nums[slow])
			 {
				 flag = true;
			 }
			 else if(flag==false)
			 {
				 nums[++slow] = nums[fast];
			 }
			 else
			 {
				 nums[slow] = nums[fast];
				 flag = false;
			 }
		 }
		 return slow+1;//???What does it mean here???
	}
	
	//Q4:
	//Repeatly deduplicate adjacent letters in an unsorted String
	// Use recursion: Base Case: Length input = Length output
	
	
	//Q5: MoveAll 0s
	//Sol 1: Two pointer reverse -> cannot keep order
	//Sol 2: Two pointer assign -> good and can keep order
	//Sol 3: Two pointer, we use while loop here, attention that sometimes fast does not need ++ 
	//[slow,fast)I do not care [fast,n-1) to explore
	//sol 3 is as below
	//Please compare: use while loop
	public int[] moveZero(int[] array)
	{
		if(array==null || array.length<=1) return array;
		int slow = 0;
		int fast = 0;
		
		while(slow<array.length)
		{
			if(fast<array.length)
			{
				if(array[fast]==0)
				{
					fast++;
				}
				else
				{
					array[slow++] = array[fast++];
				}
			}
			else
			{
				array[slow++] = 0;
			} 
		}
		return array;
	}
	
	//Compare: Use for loop for fast: better
	public int[] moveZero_forloop(int[] array)
	{
		if(array==null || array.length<=1) return array;
		int slow = 0;
		
		for(int fast=0; fast<array.length; fast++)
		{
			if(array[fast]!=0)
			{
				array[slow++] = array[fast];
			}
		}
		
		while(slow<array.length)
		{
			array[slow++] = 0;
		}
		return array;
	}
	
	
	 
}
