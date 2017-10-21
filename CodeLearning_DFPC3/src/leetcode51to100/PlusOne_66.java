package leetcode51to100;

public class PlusOne_66 
{
	//Official Solution: Use Feature
	public int[] plusOne_2(int[] digits) {
        
	    int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        
	        digits[i] = 0;
	    }
	    
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}
	
	//My Solution 
    public int[] plusOne_1(int[] digits) 
    {
        if(digits==null || digits.length==0) return digits;
        int length = digits.length;
        int next = 1;
        
        for(int i=length-1; i>=0; i--)
        {
            digits[i] += next;
            next = digits[i]/10;
            digits[i] = digits[i]%10;
            if(next==0) break;
            if(next==1 && i==0)
            {
                int[] newdigits = new int[length+1];
                newdigits[0] = 1;
                digits = newdigits;
            }
        }
        return digits; 
    }
}

