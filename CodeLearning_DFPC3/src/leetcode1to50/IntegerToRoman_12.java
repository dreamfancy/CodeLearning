package leetcode1to50;

public class IntegerToRoman_12 
{
	//1 I  5 V  10 X  50  L  100  C  500 D  1000 M
	
	//My Solution 1
	public String intToRoman_1(int num) 
	{
	        String[] I = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
	        String[] X = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	        String[] C = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};        
	        String[] M = {"","M","MM","MMM"};
	        
	        StringBuilder sb = new StringBuilder();
	        
	        sb.append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[num%10]);
	        return sb.toString();	        
	}
	
	//Official Solution
	public String intToRoman_2(int num) 
	{
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
}
