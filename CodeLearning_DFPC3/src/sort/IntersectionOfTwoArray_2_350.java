package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArray_2_350 {

	//Two pointer is the best solution if 
    public static int[] intersect(int[] nums1, int[] nums2) 
    {
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	
    	int i=0,j=0,k=0;
    	int[] res = new int[Math.max(nums1.length, nums2.length)];
    	
    	while(i<nums1.length && j<nums2.length)
    	{
    		if(nums1[i] == nums2[j])
    		{
    			res[k++] = nums1[i++];
    			j++;
    			
    		}
    		else if(nums1[i] < nums2[j])
    		{
    			i++;
    		}
    		else
    		{
    			j++;
    		}
  
    	}
    	return Arrays.copyOf(res, k);
    }
    

//The other way is using a hashmap. Please check Macys laptop. Not stored there at this time.
    
    

}
