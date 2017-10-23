package string;

public class StringSplit 
{
	public static void main(String[] args)
	{
		testsplit3();
	

	}
	
	
	public static void testsplit1()
	{
		String s= "/chaoyang/fan/handsome/";
		String[] arr = s.split("/");
		System.out.println(arr.length);
		System.out.println(arr[0].length());
		System.out.println(arr[1].length());
		System.out.println(arr[2].length());
		System.out.println(arr[3].length());
	}
	
	public static void testsplit2()
	{
		String s= "/";
		String[] arr = s.split("/");
		System.out.println(arr.length);
	}
	
	public static void testsplit3()
	{
		String s= "//";
		String[] arr = s.split("/");
		System.out.println(arr.length);
	}
	
	public static void testsplit4()
	{
		String s= "/a/";
		String[] arr = s.split("/");
		System.out.println(arr.length);
	}
	public static void testsplit5()
	{
		String s= "/a//b/";
		String[] arr = s.split("/");
		System.out.println(arr.length);
	}
	

}
