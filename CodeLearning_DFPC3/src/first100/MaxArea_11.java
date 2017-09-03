package first100;

public class MaxArea_11 {
	
	//Solution Exceed Max Limit
    public int maxArea(int[] height) 
    {
    	if(height == null || height.length<2) return -1;
        int max = Math.min(height[0], height[1]);
        int cur = 0;
        int size = height.length;
        
        for(int i=0; i<size; i++)
        {
            for(int j=i+1; j<size; j++)
            {   
                cur = (j-i) * Math.min(height[i], height[j]);   
                if(cur>max) max = cur;
            }
        }
        return max;
    }
}
