package bitoperation;

public class IntegerToRoman_12 {

		//Solution32: Generic, still consider as 10 based
    	public String intToRoman_3(int num) 
    	{
    		if (num < 1 || num > 3999) return "";
            String M[] = {"", "M", "MM", "MMM"}; //M=1000
            String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; //C=100, D=500
            String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; //L=50, X=10
            String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
        }
    	//Solution 2: Use while loop. when the value is smaller than one array element, go to the next array element
        public String intToRoman_2(int num) {
            int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
        }
    	
    	
       public String intToRoman_1(int num) {
    	//My Solution:
    	//The string is based on the sequence of possible chars
    	String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    	int[] numbers = {1000,900,500, 400,100,90, 50,  40,  10, 9,  5,   4  ,1};
    	StringBuilder sb = new StringBuilder();
    	
    	int cur = num/1000;
    	while(cur>0)
    	{
    		sb.append(strs[0]);
    		cur--;
    	}
    	
    	num = num%1000;
    	if(num/900>0)
    	{
    		sb.append(strs[1]);
    		num = num%900;
    	}
    	else if(num/500>0)
    	{
    		sb.append(strs[2]);
    		num = num%500;
    	}
    	else if(num/400>0)
    	{
    		sb.append(strs[3]);
    		num = num%400;

    	}
    	cur = num/100;
    	while(cur>0)
    	{
    		sb.append(strs[4]);
    		cur--;
    	}
    	
    	num = num%100;
    	if(num/90>0)
    	{
    		sb.append(strs[5]);
    		num = num%90;
    	}
    	else if(num/50>0)
    	{
    		sb.append(strs[6]);
    		num = num%50;
    	}
    	else if(num/40>0)
    	{
    		sb.append(strs[7]);
    		num = num%40;

    	}
    	cur = num/10;
    	while(cur>0)
    	{
    		sb.append(strs[8]);
    		cur--;
    	}
    	
    	num = num%10;
    	if(num/9>0)
    	{
    		sb.append(strs[9]);
    		num = num%9;
    	}
    	else if(num/5>0)
    	{
    		sb.append(strs[10]);
    		num = num%5;
    	}
    	else if(num/4>0)
    	{
    		sb.append(strs[11]);
    		num = num%4;

    	}
    	cur = num;
    	while(cur>0)
    	{
    		sb.append(strs[12]);
    		cur--;
    	}
    	
    	return sb.toString();
    	
    }

}
