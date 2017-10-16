package leetcode1to50;

public class TrappingRainWater_42 
{
    public int trap(int[] height) {
        if(height==null || height.length<=1) return 0;
        
        int[] leftmax = new int[height.length];
        int curleftmax = 0;
        for(int i=0; i<leftmax.length; i++)
        {
            curleftmax = Math.max(curleftmax,height[i]);
            leftmax[i] = curleftmax;
        }
        
        int[] rightmax = new int[height.length];
        int currightmax = 0;
        for(int j=rightmax.length-1; j>=0; j--)
        {
            currightmax = Math.max(currightmax,height[j]);
            rightmax[j] = currightmax;
        }
        
        int result = 0;
        for(int i=0; i<height.length; i++)
        {
            int val = Math.min(rightmax[i],leftmax[i])-height[i];
            if(val>0) result += val;
        }

        return result; 
    }

}
