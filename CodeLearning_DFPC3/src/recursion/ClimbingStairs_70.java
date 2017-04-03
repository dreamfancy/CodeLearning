package recursion;

import java.util.HashMap;

public class ClimbingStairs_70 {
	static HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();

    public static int climbStairs(int n) {

        if(n==1 || n==0) return 1;
        
        int result = 0;
        
        if(hash.get(n-2)!=null) result += hash.get(n-2);
        else
        {
            int subv2 = climbStairs(n-2);
            hash.put(n-1,subv2);
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
    
    public static void main(String[] args)
    {
    	climbStairs(5);
    }
}
