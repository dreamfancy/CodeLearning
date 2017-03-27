package array;

import java.util.Random;

public class getRandomUsingJava {

	public static void getRandomUsingJava(int flag)
	{
		switch(flag)
		{
			case 1:
				System.out.println(Math.random()); //Math.random() can be a decimals between 0 and 1;
				break;
			case 2:
				System.out.println((int)(Math.random() * 100));
				break;
			case 3:
				Random rand = new Random();
				System.out.println(rand.nextInt(10));
				System.out.println(rand.nextInt());
				System.out.println(rand.nextFloat());
				System.out.println(rand.nextDouble());
				System.out.println(rand.nextBoolean());
		}
		
		
	}

	//public static void main(String[] args)
	{
	//	getRandomUsingJava(2);
	}
}
