package leetcode201to250;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) 
    {
        List<String> result = new ArrayList<String>();
        if(nums==null || nums.length==0) return result;
        int i=1;
        int start = 0;
        while(i<nums.length)
        {
            if(nums[i]>nums[i-1]+1)
            {
                result.add(processString(result,nums[start],nums[i-1]));
                start = i;
            }
            i++;
        }
        if(start<nums.length)
        {
            result.add(processString(result,nums[start],nums[nums.length-1]));
        }
        return result;
    }
    
    private String processString(List<String> result, int start, int end)
    {
        StringBuilder sb = new StringBuilder();
        if(start!=end)
        {
            sb.append(start).append("->").append(end);
        }
        else return String.valueOf(start);
            
        return sb.toString();
    }
}
