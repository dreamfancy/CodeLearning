package leetcode1to50;

public class ContainerWithMostWater_11 
{
	//Official Solution
	   public int maxArea(int[] height) 
	    {
	        if(height==null || height.length<=1) return 0;
	        int left = 0;
	        int right = height.length-1;
	        
	        int maxWater = 0;
	        
	        while(left<right)
	        {
	            int curTop = Math.min(height[left],height[right]);
	            int curVal = (right-left)*curTop;
	            if(curVal>maxWater) maxWater = curVal;
	            
	            if(height[left]>=height[right]) right--;
	            else left ++;
	        }
	        
	        return maxWater;
	        
	    }
	
	
	//My solution
    public int maxArea_My(int[] height) 
    {
        if(height==null || height.length<=1) return 0;
        int left = 0;
        int right = height.length-1;
        
        int maxWater = 0;
        
        while(left<right)
        {
            int curTop = Math.min(height[left],height[right]);
            int curVal = (right-left)*curTop;
            if(curVal>maxWater) maxWater = curVal;
            
            if(height[left+1]>=(height[left]+1)) left++;
            else if(height[right-1]>=(height[left]+1)) right--;
            else
            {
                left++;
                right--;   
            }
        }
        
        return maxWater;
        
    }
	
	//My original solution: Wrong understanding of the question
	//Think about all lines are drawn //Wrong understanding of the question
    public int maxArea_MyOriginal(int[] height) 
    {
        if(height==null || height.length<=1) return 0;
        int left = 0;
        int right = height.length-1;
        
        int maxWater = 0;
        
        while(left<right)
        {
            int curVal = 0;
            int curTop = Math.min(height[left],height[right]);
            for(int i=left+1; i<right; i++)
            {
                if(height[i]<curTop) curVal += curTop - height[i];
            }
            if(curVal>maxWater) maxWater = curVal;
            
            while(left<right && height[left+1]<=(height[left]+1)) left++;
            while(left<right && height[right-1]<=(height[left]+1)) right--;
        }
        
        return maxWater;
        
    }

}
