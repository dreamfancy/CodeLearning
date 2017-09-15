package first100;

public class MultiplyStrings_43 
{
    	//No use of Integer lib nor directly change to int
        public String multiply(String num1, String num2) 
        {
        	int len1 = num1.length();
        	int len2 = num2.length();
        	
        	int[] n1 = new int[len1];
        	int[] n2 = new int[len2];
        	
        	int[] ans = new int[len1+len2];
        	
        	for(int i=0; i<len1; i++)
        	{
        		n1[i] = num1.charAt(i)-'0';
        	}
        	for(int j=0; j<len2; j++)
        	{
        		n2[j] = num2.charAt(j)-'0';
        	}
        	
        	for(int m=len1-1; m>=0; m--)
        	{
        		for(int n=len2-1; n>=0; n--)
        		{
        			int prod = n1[m]*n2[n] + ans[m+n+1];
        			ans[m+n+1] = prod%10;
        			ans[m+n] = prod/10;
        		}
        	}
        	
        	StringBuilder sb =new StringBuilder();
        	
        	for(int c : ans)
        	{
        		if(c==0 && sb.length()==0) continue;
        		sb.append(c);
        	}
        		
        	return sb.toString();
        }
        	
        	/*
        	
        	int str1last = str1.length-1;
        	int str2last = str2.length-1;
        
        	int str1base = 1;
        	int str2base = 1;
        	
        	int result =0;
        	
        	for(int i=str1last; i>=0; i--)
        	{
        		int partialRes = 0;
        		int curNum1 = str1[i]-'0';
        		for(int j=str2last; j>=0; j--)
        		{
        			int curNum2 = str2[j]-'0';
        			partialRes += curNum2 * curNum1*10;
        			str2base *= 10;
        		}
        		result += partialRes;
        		str1base *= 10;
        		str2base = 1;
        	}
        	
        	//?
        	
        }
        */

}
