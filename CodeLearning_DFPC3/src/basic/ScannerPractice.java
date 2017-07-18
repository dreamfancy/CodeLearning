package basic;

import java.util.Scanner;

public class ScannerPractice {

	public static void main(String[] args)
	{
		//howToUserscannerHasNext();
		//readALine();
		
		
	}
	
	public void readALine()
	{
		//data to input
		//1 2 3 4
				
		Scanner scanner = new Scanner(System.in);
				
		String cur1 = scanner.next();
		System.out.println(cur1);
		String cur2 = scanner.nextLine();
		System.out.println(cur2);
				
		scanner.close();
	}
	
	
	public static void howToUserscannerHasNext()
	{
		//data to input
		// 1 2 3
		//  4 5
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext())
		{
			int curNum = scanner.nextInt();
			System.out.println(curNum);
			if(curNum==-1) break;
		}
		scanner.close();
	}
}
