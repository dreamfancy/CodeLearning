package bitoperation;

public class RomanToInteger_13 
{
	//Solution 3:
	//Use Array to save time
	  public int romanToInt_3(String s) {
	       int conv[] = new int[s.length()];
	        for(int i = 0; i < s.length(); i++)
	        {
	        	switch(s.charAt(i))
	        	{
	        		case 'M': conv[i] = 1000; break;
	        		case 'D': conv[i] = 500; break;
	        		case 'C': conv[i] = 100; break;
	        		case 'L': conv[i] = 50; break;
	        		case 'X': conv[i] = 10; break;
	        		case 'V': conv[i] = 5; break;
	        		case 'I': conv[i] = 1; break;
	        	}
	        } 
	        int sum = 0;
	        for(int i = 0; i < conv.length-1; i++)
	        {
	        	if(conv[i]<conv[i+1]) sum-=conv[i];
	        	else sum+=conv[i];
	        }
	        return sum+conv[conv.length-1];
	    }
	
	
	//Solution 2: 
	//Find the relations: 40 = 50-10; 4 = 5-4;
    public int romanToInt_2(String s) {
        int num = 0;
        int curr_num = 0;
        for( int i = 0 ; i < s.length(); i++ ) {
            int pre_num = curr_num;
            switch( s.charAt(i) ) {
                case 'I':
                    curr_num = 1;
                    break;
                case 'V':
                    curr_num = 5;
                    break;
                case 'X':
                    curr_num = 10;
                    break;
                case 'L':
                    curr_num = 50;
                    break;
                case 'C':
                    curr_num = 100;
                    break;
                case 'D':
                    curr_num = 500;
                    break;
                case 'M':
                    curr_num = 1000;
                    break;
                default:
                    break;             
            }
            
            if( pre_num < curr_num ) {
                num -= pre_num;
            } else {
                num += pre_num;
            }
        }
        
        num += curr_num;
        return num;
    }
	
	
	
	
	
	
	//My Solution : Check by sequence
    public int romanToInt_1(String s)
    {
    	int result = 0;
     	int c = 0;
     	if(s==null || s.length()==0) return 0;
     	
    	int length = s.length();
     	while(c<length && s.charAt(c)=='M')
    	{
    		result += 1000;
    		c++;
    	}
     	
     	if(c<(length -1) && s.charAt(c)=='C' && s.charAt(c+1)=='M')
     	{
     		result += 900;
     		c += 2;
     	}
     	else if(c<(length -1) && s.charAt(c)=='C' && s.charAt(c+1)=='D')
     	{
     		result += 400;
     		c += 2;
     	}
     	else if(c<length && s.charAt(c)=='D') 
     	{
     		result +=500;
     		c++;
     	}
     	while(c<length && s.charAt(c)=='C')
     	{
     		result +=100;
     		c++;
     	}
    	
     	if(c<(length -1) && s.charAt(c)=='X' && s.charAt(c+1)=='C')
     	{
     		result += 90;
     		c += 2;
     	}
     	else if(c<(length -1) && s.charAt(c)=='X' && s.charAt(c+1)=='L')
     	{
     		result += 40;
     		c += 2;
     	}
     	else if(c<length && s.charAt(c)=='L') 
     	{
     		result +=50;
     		c++;
     	}
     	while(c<length && s.charAt(c)=='X')
     	{
     		result +=10;
     		c++;
     	}
    	
     	if(c<(length -1) && s.charAt(c)=='I' && s.charAt(c+1)=='X')
     	{
     		result += 9;
     		c += 2;
     	}
     	else if(c<(length -1) && s.charAt(c)=='I' && s.charAt(c+1)=='V')
     	{
     		result += 4;
     		c += 2;
     	}
     	else if(c<length && s.charAt(c)=='V') 
     	{
     		result +=5;
     		c++;
     	}
     	while(c<length && s.charAt(c)=='I')
     	{
     		result +=1;
     		c++;
     	}
     	
    	return result;
    }

}
