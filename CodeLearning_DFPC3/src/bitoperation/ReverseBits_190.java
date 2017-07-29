package bitoperation;

public class ReverseBits_190 
{
	//My solution: get bit then assign;
    public int reverseBits(int n) {
        
        if(n==0) return 0;
        
        int result = 0;;
        int leftmask = 1;
        int rightmask = 1<<31;
        
        for(int i=0; i<32; i++)
        {
            int bit = (n & leftmask)==0? 0 : 1;
            
            if(bit==1)
            result = result | rightmask;
            
            leftmask = leftmask<<1;
            rightmask = rightmask>>>1;
        }
        return result;
    }

}
