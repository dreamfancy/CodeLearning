package leetcode201to250;

import java.util.Stack;

public class BitWiseAndofNumbersRange_201 
{
	//Sol 2: shift two numbers at the same time until one point when they are same
	public int rangeBitwiseAnd_2(int m, int n) {
        int index = 0;
        while( m != n){
            m >>>= 1;
            n >>>= 1;
            index ++ ;
        }
        return m << index;
    }
	
	//Sol 1: My Solution,comparing bit with help of stack to track position
    public int rangeBitwiseAnd_1(int m, int n) 
    {
        Stack<Integer> stm = new Stack<Integer>();
        Stack<Integer> stn = new Stack<Integer>();
        
        for(int i=0; i<32; i++)
        {
            stm.push(m&1);
            stn.push(n&1);
            m >>>=1;
            n >>>=1;
        }
        
        int result = 0;
        while(!stm.isEmpty() && !stn.isEmpty() && stm.peek()==stn.peek())
        {
            result |= stm.pop();
            stn.pop();
            if(!stm.isEmpty())
                result <<= 1;
        }
        while(!stm.isEmpty())
        {
            stm.pop();
            if(!stm.isEmpty())
                result <<= 1;
        }
        return result;
    }
}
