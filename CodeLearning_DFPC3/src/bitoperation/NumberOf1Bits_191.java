package bitoperation;

public class NumberOf1Bits_191 
{
    public int hammingWeight_TargetRightShift(int n) {
        
        int count = 0;
        while(n!=0)
        {
            if((n & 1)==1)
                count++;
            n=n>>>1;
        }
        return count;
    }
    
    public int hammingWeight_MarkLeftShift(int n) {
        
        int count = 0;
        int mark = 1;
        for(int i=0; i<32;i++)
        {
        	if((n & mark) !=0)  //operater please add ()
        		count++;
        	mark = mark<<1;
        	
        }
        
        return count;
    }
}
