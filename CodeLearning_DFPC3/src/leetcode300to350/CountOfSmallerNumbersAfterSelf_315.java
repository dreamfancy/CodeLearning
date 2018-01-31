package leetcode300to350;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf_315 
{
    public List<Integer> countSmaller(int[] nums) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null || nums.length==0) return result;
        
        List<Integer> sorted = new ArrayList<Integer>();
        
        for(int i=nums.length-1; i>=0; i--)
        {
            int cur = nums[i];
            int index = findIndex(sorted,cur);
            result.add(index);
        }
        Collections.reverse(result);
        return result;
    }
    
    private int findIndex(List<Integer> sorted, int cur)
    {
        if(sorted.size()==0) 
        {
            sorted.add(cur);
            return 0;
        }
        int left = 0, right = sorted.size()-1;
        
        while(left<right-1)
        {
            int mid = left + (right-left)/2;
            if(sorted.get(mid)<cur)
            {
                left = mid+1;
            }
            else
            {
                right = mid;
            }
        }
        if(sorted.get(left)>=cur)
        {
            sorted.add(left,cur);
            return left;
        }
        else if(sorted.get(right)>=cur)
        {
            sorted.add(right,cur);
            return right;
        }
        
        sorted.add(cur);
        return sorted.size()-1;   //Never size here
    }
    
    private int findIndex_withoutBS(List<Integer> sorted, int cur)
    {
        if(sorted.size()==0) 
        {
            sorted.add(cur);
            return 0;
        }
        for(int i=0; i<sorted.size(); i++)   //Wrong!!! search a position in a sorted array: Binary search
        {
            if(sorted.get(i)>=cur) 
            {
                sorted.add(i,cur);
                return i;
            }
        }
        sorted.add(cur);
        return sorted.size()-1; //!!!Attention, after the add operation. The sorted size has been changed
    }

}
