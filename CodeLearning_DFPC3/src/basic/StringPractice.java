package basic;

public class StringPractice {

	public static void main(String[] args)
	{
		StringSplitPractice_2();
	}
	
	
	
	public static void StringCharPractice()
	{
		String str = "Chaoyang";
		char ch1 = str.charAt(2);
		Character ch11 = (Character) ch1;
		System.out.println(ch1);
		System.out.println(ch11);
		
		Character ch2 = str.charAt(3);
		char ch22 = (char) ch2;
		System.out.println(ch2);
		System.out.println(ch22);
		
		System.out.println("*****************");

		
	}
	
	
	public static void StringSplitPractice_2()
	{
		String str = "   ";
		String[] arr = str.split(" ");
		System.out.println(arr.length);
		
		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]);
		}
		System.out.println("end");

		
		String str2 = "111 ";
		String[] arr2 = str2.split("1");
		System.out.println(arr2.length);
		
		for(int i=0; i<arr2.length;i++)
		{
			System.out.print(arr2[i]);
			System.out.println("#");
		}
		System.out.println("end");

	}
	
	
	
	public static void StringSplitPractice_1()
	{
	// SubString, Replace and Split
	/*
		String stra = new String("chaoyang");
		System.out.println(stra);
		
		String strb = stra.replace('a', 'b');
		System.out.println(strb);
		
		String strc = new String("chaoyang is good  ").trim();
		System.out.println(strc);
		
		String strd = new String("01 345  8 ");
		String stre = strd.substring(2);
		System.out.println(stre);
		
		String strf = new String("01 345  8 ");
		String strg = strf.substring(2,4); //The end index will not be printed
		System.out.println(strg);
		*/
		
		//Split
		String strh = new String("01 345  8 12345 12 3 45 ");
		String[] stri = strh.split("3", 5);//Split will delete the char which to split and then make the lefthand righthand chars to two elements of the String
		for(int i=0; i<stri.length; i++)
		{
			System.out.println(stri[i]);
		}
		
		System.out.println("###################");

		String strk = new String("01 345 3 8 33 12 33 43 43 233");
		String[] strl = strk.split("3", 5); //the n in second argument means the first n record.
		for(int i=0; i<strl.length; i++)
		{
			System.out.println(strl[i]);
		}
		
		System.out.println("###################");

	}
	
}
