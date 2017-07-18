package recursion;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LookAndSay_Atlassian {

    public static void main(String args[] ) throws Exception 
    {
   
    		
    }

    public static String lookAndSay(String input)
    {
    	char[] inputArr = input.toCharArray();
		/*
		for(int i=0; i<inputArr.length; i++)
		{
			System.out.println(inputArr[i]);
		}
		*/
		
		if(inputArr.length==1)
		{
			String newString = new String("1" + inputArr[0]);
			System.out.println (newString);
			return newString;
		}
		StringBuilder result = new StringBuilder();
		
		char curchar = inputArr[0];
		int curIndex = 0;
 		for(int i=1; i<inputArr.length-1; i++)
		{
			if(inputArr[i]==curchar)
			{
				continue;
			}
			int numOfPrevious = i-curIndex;
			result.append(numOfPrevious).append(curchar);
			curIndex = i;
			curchar = inputArr[i];
		}
 		
 		int last = inputArr.length - 1;
 		if(inputArr[last]==curchar)
 		{
 			int numOfPrevious = last-curIndex+1;
			result.append(numOfPrevious).append(curchar);
 		}
 		else
 		{
 			int numOfPrevious = last-curIndex;
			result.append(numOfPrevious).append(curchar);
			
 			result.append("1").append(inputArr[last]);
 		}
   
 		System.out.println(result.toString());
 		return result.toString();
    }
}

