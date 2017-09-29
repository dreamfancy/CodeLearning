package array;

public class ArrayEqualsPractice {

	public static void main(String[] args)
	{
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,3,4,5};
		int[] arr3 = {5,4,3,2,1};
		
		System.out.println(arr1.equals(arr2));//NOT Working
		System.out.println(arr1.equals(arr3));

		
	}
}
