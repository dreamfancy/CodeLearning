package leetcode251to300;

import java.util.Arrays;

public class HIndex_274 
{
	//Sol 2: Using another array (extra space) to change
	//time complexity from O(nlogn) to O(n)
    public int hIndex_2(int[] citations) {
        int length = citations.length;
        if (length == 0) {
        	return 0;
        }
        
        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
        	if (citations[i] > length) {
        		array2[length] += 1;
        	} else {
        		array2[citations[i]] += 1;
        	}
        }
        int t = 0;
        int result = 0;

        for (int i = length; i >= 0; i--) {
        	t = t + array2[i];
        	if (t >= i) {
        		return i;
        	}
        }
        return 0;
    }
	
	//Sol 1: My Solution O(nlogn) using sort
    public int hIndex(int[] citations) 
    {
        if(citations==null || citations.length==0) return 0;
        Arrays.sort(citations);
        int len = citations.length;
        int count = 0;
        int i = 0 ;
        for(i=0;i<len; i++)
        {
            if(citations[len-1-i]<(i+1)) break;
    
        }
        return i;
    }	

}
