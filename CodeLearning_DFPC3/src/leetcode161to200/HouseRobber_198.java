package leetcode161to200;

public class HouseRobber_198 
{
	public int rob(int[] num) {
	    int prevMax = 0;
	    int currMax = 0;
	    for (int x : num) {
	        int temp = currMax;
	        currMax = Math.max(prevMax + x, currMax);
	        prevMax = temp;
	    }
	    return currMax;
	}
}
