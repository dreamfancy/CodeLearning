package basic;

import java.util.List;

public class CharPractice {

	
	public static void main(String[] args)
	{
		//Collecitons cannot be arrayed
		//ArrayList<Integer>[] listArray = new ArrayList<Integer>[3];
		
	}
	
	public void practice2()
	{
		char[] chararray = new char[5];
		
		System.out.println(chararray[0]);
		System.out.println(chararray[0]);
	}
	
	public void practice1()
	{
		/*
		char ch1 = 'a';
		char ch2 = 'b';
		char ch3 = 'A';
		int diff12 = ch1-ch2;
		int diff13 = ch1-ch3;

		System.out.println(diff12);
		System.out.println(diff13);

		char cur = 'A';
		for(int i=0; i<256; i++)
		{
			char c = (char) (cur + 1);
			System.out.println(c);
			cur = c;
		}
		*/
		
		
		Character c1 = 'a';
		Character c2 = 'a';
		
		System.out.println(c1.equals(c2));
		
		char c3 = 'a';
		char c4 = 'a';
		
		System.out.println(c3==c4);
	}
}
