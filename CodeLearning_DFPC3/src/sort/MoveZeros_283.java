package sort;

public class MoveZeros_283 {

	//Most easy way
	public static void moveZeroes(int[] nums)
	{
		if(nums==null ||nums.length<=1) return;
		int curn = 0;
		for(int i=0; i<nums.length; i++)
		{
			if(nums[i]!=0)
			{
				nums[curn++]= nums[i];
			}
		}
		
		for(int j=curn; j<nums.length; j++)
		{
			nums[j]=0;
		}
	}
	
	//Solution Of Lecture: Use quick sort, this is a wrong solution because
	//it will not keep the order of the existing non-zero elements
	//Just for your reference that it is a good appliance of sorting
	public static void moveZeroesQS(int[] nums)
	{
		int left = 0;
		int right = nums.length-1;
		
		while(left<=right)
		{
			//while(nums[left]!=0 && left<=right) left++;
			while(left<=right && nums[left]!=0) left++;
			while(left<=right && nums[right]==0) right--;
			
			if(left<right) swap(nums,left,right);
		}	
	}
	
	public static void swap(int[] nums, int first, int second)
	{
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}
}
