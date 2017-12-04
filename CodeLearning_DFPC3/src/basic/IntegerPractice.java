package basic;

public class IntegerPractice {

	public static void main(String[] args)
	{
		//integerToString();
		negativeInt();
		
	}
	
	public static void negativeInt()
	{
		System.out.println(5/2);
		System.out.println(-5/2);
		System.out.println((-5)/2);


		
	}
	public static void integerToString()
	{
		int a = 123;
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		System.out.println(sb.toString());
	}
	
	public void stringToInteter()
	{
		String numString = "123";
		int num = Integer.parseInt(numString);
	//	int num = Integer.parseInt(numString+" "+"678");
		System.out.println(num);
		
		System.out.println("****************");
		
		Integer a1= new Integer(4);
		int a2 = (int)a1;
		System.out.println(a2);
		
		int a3 = 5;
		Integer a4 = (Integer)a3;
		System.out.println(a4);
		
	}
}
