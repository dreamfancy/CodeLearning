package leetcode1to50;

public class RomanToInteger_13 
{
	
	//A simple but tricky solution_2, just look instead of following
	public int romanToInt_2(String s) {
	     int sum=0;
	    if(s.indexOf("IV")!=-1){sum-=2;}
	    if(s.indexOf("IX")!=-1){sum-=2;}
	    if(s.indexOf("XL")!=-1){sum-=20;}
	    if(s.indexOf("XC")!=-1){sum-=20;}
	    if(s.indexOf("CD")!=-1){sum-=200;}
	    if(s.indexOf("CM")!=-1){sum-=200;}
	    
	    char c[]=s.toCharArray();
	    int count=0;
	    
	   for(;count<=s.length()-1;count++){
	       if(c[count]=='M') sum+=1000;
	       if(c[count]=='D') sum+=500;
	       if(c[count]=='C') sum+=100;
	       if(c[count]=='L') sum+=50;
	       if(c[count]=='X') sum+=10;
	       if(c[count]=='V') sum+=5;
	       if(c[count]=='I') sum+=1;   
	   }
	   return sum;
	}
	
	//My solution:
    public int romanToInt(String s) 
    {
        if(s==null || s.length()==0) return 0;
        int result = 0;
        
        // i can jump two steps when some situation. So do not use for loop, use while loop
        int i = 0;
        while(i<s.length())
        {
            if(s.charAt(i)=='M') result +=1000;
            else if(i<(s.length()-1) && s.charAt(i)=='C' && s.charAt(i+1)=='M')
            {
                result +=900;
                i++;
            }
            else if(s.charAt(i)=='D') result +=500;
            else if(i<(s.length()-1) && s.charAt(i)=='C' && s.charAt(i+1)=='D')
            {
                result +=400;
                i++;
            }
            else if(s.charAt(i)=='C') result +=100;
            else if(i<(s.length()-1) && s.charAt(i)=='X' && s.charAt(i+1)=='C')
            {
                result +=90;
                i++;
            }
            else if(s.charAt(i)=='L') result +=50;
            else if(i<(s.length()-1) && s.charAt(i)=='X' && s.charAt(i+1)=='L')
            {
                result +=40;
                i++;
            }
            else if(s.charAt(i)=='X') result +=10;
            else if(i<(s.length()-1) && s.charAt(i)=='I' && s.charAt(i+1)=='X')
            {
                result +=9;
                i++;
            }
            else if(s.charAt(i)=='V') result +=5;
            else if(i<(s.length()-1) && s.charAt(i)=='I' && s.charAt(i+1)=='V')
            {
                result +=4;
                i++;
            }
            else if(s.charAt(i)=='I') result +=1;
            i++;
        }
        return result;
    }

}
