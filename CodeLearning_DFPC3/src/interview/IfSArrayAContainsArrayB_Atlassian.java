package interview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


// Question 1:
//Input as below by scanner
//3 The first array size is 3
//0 first array element 1
//1 first array element 2
//2 first array element 3
//2 The second array size is 2
//1 second array element 1
//2 second array element 2


public class IfSArrayAContainsArrayB_Atlassian 
{
	
    public static void main(String args[] ) throws Exception 
    {
    	Stack<Integer> st1 = new Stack<Integer>();
    	Stack<Integer> st2 = new Stack<Integer>();
    	try
    	{
    		Scanner scanner = new Scanner(System.in);
    	
    		int array1Size = scanner.nextInt();
    		if(array1Size<=0 || array1Size > Integer.MAX_VALUE)
    		{
    			System.out.println(-1);
    			return;
    		}
	    	for(int i=0; i<array1Size; i++)
	    		st1.push(scanner.nextInt());
	    	
	    	int array2Size = scanner.nextInt();
	    	if(array2Size <= 0)
	    	{
	    		System.out.println(0);
	    		return;
	    	}
	    	for(int i=0; i<array2Size; i++)
	    		st2.push(scanner.nextInt());
	    	
	    	scanner.close();
    	}
    	catch(Exception e)
    	{
    		System.out.println("IO Exception");
    		return;
    	}

    	while(!st1.empty() && !st2.empty())
    	{
    		if(st1.pop()!=st2.pop())
    		{
    			System.out.println(-1);
    		}
    	}
    	if(st1.empty() && st2.empty())
    	{
			System.out.println(0);
    	}
    	else if(st1.empty() && !st2.isEmpty())
    	{
    		System.out.println(-1);
    		return;
    	}
    	else
    	{
    		int count = 0;
    		while(!st1.empty())
    		{
    			count++;
    			st1.pop();
    		}
    		System.out.println(count);
    	}
    	
     }		
    
    

	
	
	

}
