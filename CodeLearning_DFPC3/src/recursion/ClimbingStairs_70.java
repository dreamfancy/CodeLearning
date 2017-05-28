package recursion;

import java.util.HashMap;

public class ClimbingStairs_70 {
	static HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();

	
	//Recursion for Fibbonaci Time without space for memory: O(2^n)
	
	//Compare DP and Recursion: From small to big // From big to small
	
    public static int climbStairs(int n) {

        if(n==1 || n==0) return 1;
        
        int result = 0;
        //Att! n-2 should be ahead of n-1 to save the value ahead
        if(hash.get(n-2)!=null) result += hash.get(n-2);
        else
        { 
            int subv2 = climbStairs(n-2);
            hash.put(n-2,subv2);
            result += climbStairs(n-2);       
        }
        
        
        if(hash.get(n-1)!=null) result += hash.get(n-1);
        else 
        {
            int subv1 = climbStairs(n-1);
            hash.put(n-1,subv1);
            result += climbStairs(n-1);
        }

        return result;
    }
    
    //DP solution Use hash
    public static int climbStairs_DP_Hash(int n) {

        if(n==1 || n==0) return 1;
        
        hash.put(0, 1);
        hash.put(1, 1);
        
        for(int i=2; i<=n; i++)
        {
        	hash.put(i,hash.get(i-2)+hash.get(i-1));
        }
        
        return hash.get(n);
    }
    
    //DP solution without hash
    public static int climbStairs_DP(int n) {

        if(n==1 || n==0) return 1;
        
        int front=1, end=1;
        int cur=0;
        for(int i=2; i<=n; i++)
        {
        	cur = front+end;
        	front = end;
        	end = cur;
        }
        
        return cur;
    }
    
    public static void main(String[] args)
    {
    	climbStairs(5);
    }
}
