package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//First traverse the sum of AB and get all the sums in one place, 
//
public class FourSumTwo454 {

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D)
	{
		Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
		
		if(A==null || A.length<=0 || B==null || B.length<0 || C==null || C.length<0 || D==null || D.length<0) {
			return -1;
		}
		
		
		for(int i : A) {
			for(int j: B) {
				int key = A[i] + B[j];
				int value = hash.get(key);
				
				if(value == -1) {
					hash.put(key , value+1);
				} else {
					hash.put(key,1);
				}
				
				
				if(hash.containsKey(key))
				{
					hash.put(key,hash.get(key)+1);
				}
				else
				{
					hash.put(key,1);
				}
			}
		}
		int count =0;
		List<Integer> cd = new ArrayList<Integer>();
		for(int m: C)
		{
			for(int n: D)
			{
				int cur = -(C[m] + D[n]);
				if(hash.containsKey(cur))
				{
					count += hash.get(cur);
				}
			}
		}
		
		return count;
		
	}
	
}
