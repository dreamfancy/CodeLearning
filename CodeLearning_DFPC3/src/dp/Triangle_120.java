package dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle_120 
{
	//Solution 3: Bottom to Up more understandable
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;
	 
		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}
	 
		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
		}
	 
		return total[0];
	}
	
	//Solution 2: From back to front
    public int minimumTotal_2(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
	
	
	//Solution 1: My solution
	//Duplicate ArrayList result every time as the previous value is
	//needed in next value but previous value has been updated.
	//Very bad run time in leetcode run
    public int minimumTotal_1(List<List<Integer>> triangle) 
    {
    	List<Integer> cur = new ArrayList<Integer>();
    	cur.add(triangle.get(0).get(0));
        List<Integer> pre = new ArrayList<Integer>(cur);
    	
    	for(int i=1; i<triangle.size(); i++)
    	{
    		cur.set(0, pre.get(0)+ triangle.get(i).get(0));
    		for(int j=1; j<triangle.get(i).size()-1; j++)
    		{
    			cur.set(j,Math.min(pre.get(j),pre.get(j-1))+triangle.get(i).get(j));
    		}
    		cur.add(pre.get(pre.size()-1)+ triangle.get(i).get(triangle.get(i).size()-1));
            for(int a=0; a<cur.size();a++)
            {
                System.out.print(cur.get(a) + " ");
            }
            System.out.println();
            pre = new ArrayList<Integer>(cur);
    	}
    	
    	int min = cur.get(0);
    	for(int k=1; k<cur.size(); k++)
    	{
    		if(cur.get(k)<min) 
            {
                System.out.println("Update min  ");
                min = cur.get(k);
            }
    	}
    	
    	return min;
    }
}
