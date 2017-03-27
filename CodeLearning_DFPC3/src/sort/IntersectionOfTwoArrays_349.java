package sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {

	//Sort and Two Pointer Go Through, Use While when it is not head nor end
    public static int[] intersection(int[] nums1, int[] nums2) 
    {
    	if(nums1 == null || nums2 == null) return null;
    	if(nums1.length == 0 || nums2.length == 0) return new int[0];
    	int length1 = nums1.length;
    	int length2 = nums2.length;
    	
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	
    	int[] res = new int[Math.max(length1, length2)];
    	
    	int i=0,j=0,k=0;
    	while(i!=length1 && j!=length2)
    	{    		    		
    		if(nums1[i]==nums2[j]) 
    		{
    			res[k] = nums1[i];
    			i++;
    			j++;
    			k++;
    		}
    		else if(nums1[i]<nums2[j])
    		{
    			i++;
    		}
    		else if(nums1[i]>nums2[j])
    		{
    			j++;
    		}	
    		
    		if(i>=1 && i<=length1-1)
    		{
    			while(nums1[i]==nums1[i-1])
    			{
    				i++;
    				if(i>=length1-1) break;
    			}
    		}
    		
    		if(j>=1 && j<length2-1)
    		{
    			while(nums2[j]==nums2[j-1])
    			{
    				j++;
    				if(j>=length2-1) break;

    			}
    		}
    		
    	}
    	
    	int[] result = Arrays.copyOf(res, k);
    	
    	return result;	
    }
    	
    //Sort and use two pointer, Use the temperary generated result as a reference
    public static int[] intersection_1(int[] nums1, int[] nums2) 
    {
    	if(nums1 == null || nums2 == null) return null;
    	if(nums1.length == 0 || nums2.length == 0) return new int[0];
    	int length1 = nums1.length;
    	int length2 = nums2.length;
    	
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	
    	int[] res = new int[Math.max(length1, length2)];
    	
    	int i=0,j=0,k=0;
    	while(i!=length1 && j!=length2)
    	{    		    		
    		if(nums1[i]==nums2[j]) 
    		{
    			if(k==0 || nums1[i] != res[k-1])
    			{
        			res[k] = nums1[i];
        			k++;
    			}
    			i++;
    			j++;
    		}
    		else if(nums1[i]<nums2[j])
    		{
    			i++;
    		}
    		else if(nums1[i]>nums2[j])
    		{
    			j++;
    		}	
    		
    	}
    	
    	int[] result = Arrays.copyOf(res, k);
    	
    	return result;	
    }
    
    //HashMap
    public static int[] intersection_2(int[] nums1, int[] nums2) 
    {
    	Set<Integer> s1 = new HashSet<Integer>();
    	
    	for(int i=0; i<nums1.length;i++)
    	{
    		s1.add(nums1[i]);
    	}
    	
    	Set<Integer> s2 = new HashSet<Integer>();
    	
    	for(int j=0; j<nums2.length;j++)
    	{
    		if(s1.contains(nums2[j]))
    		{
    			s2.add(nums2[j]);
    		}
    	}
    	
    	int[] res = new int[s2.size()];
    	Iterator<Integer> itr = s2.iterator();
    	for(int i=0; i<res.length; i++)
    	{	if(itr.hasNext())
    		res[i]= itr.next();   		
    	}
    	return res;
    }
    //Sort One Array and Binary search the other array.
    public static int[] intersection_3(int[] nums1, int[] nums2)
    {
    	Arrays.sort(nums1);
    	Set<Integer> s2 = new HashSet<Integer>();
    	for(int num2: nums2)
    	{
    		if(Arrays.binarySearch(nums1, num2)>=1)
    		{
    			s2.add(num2);
    		}
    	}

    	int[] res = new int[s2.size()];
    	int index = 0;
    	for(int resnum:s2)
    	{
    		res[index++] = resnum;
    	}
    	return res;
    }
    
    
    
    
}
