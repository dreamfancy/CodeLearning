package first100;

public class MaxArea_11 {
	
	//Solution 2: Two Pointer: Use the opposite direction to decide the
	//best solution, When to move left && When to move right!!!
    public int maxArea_2(int[] height) 
    {
    	if(height == null || height.length<2) return -1;
        int size = height.length;
        int max = Math.min(height[0], height[size-1]) * (size-1);
        int left=0, right=size-1;
        
        while(left<right)
        {
           max = Math.max(max, Math.min(height[left],height[right])*(right-left));
           if(height[left]<=height[right]) left++;
           else right--;
        }
        return max; 
    }
	
	
	//Solution 1 Exceed Max Time Limit
    public int maxArea_1(int[] height) 
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
