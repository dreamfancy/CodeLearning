package basic;

public class IntegerPractice {

	public static void main(String[] args)
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